package com.github.surajjannu.designpattern;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.github.surajjannu.designpattern.example1.DirectorApprover;
import com.github.surajjannu.designpattern.example1.ManagerApprover;
import com.github.surajjannu.designpattern.example1.PurchaseOrder;
import com.github.surajjannu.designpattern.example1.SeniorManagerApprover;
import com.github.surajjannu.designpattern.example2.ErrorLogProcessor;
import com.github.surajjannu.designpattern.example2.InfoLogProcessor;
import com.github.surajjannu.designpattern.example2.LogLevel;
import com.github.surajjannu.designpattern.example2.WarnLogProcessor;

public class ChainOfResponsibility {

    /*
     *
     * 1. Chain of Responsibility is a type of Behavioral Design Pattern
     * 2. Chain of Responsibility pattern allows a number of classes to attempt to
     *       handle a request without any of them knowing about the capabilities of the other classes
     * 3. C-O-R pattern lets more than 1 object handle a request without manual knowledge
     * 4. It provides loose coupling between the classes
     * 5. Request is taken up by the first handler, once done he passes to the next handler down the chain.
     *       This goes until the proper handler takes it up and completes the processing.
     *
     * */

    public static void main(String[] args) throws InterruptedException {
        // Example 1 i.e Approval Chain
        var purchaseOrder = new PurchaseOrder(6000L, "MAC Mouse");

        var manegerApprover = new ManagerApprover();
        var seniorManagerAppprover = new SeniorManagerApprover();
        var directorApprover = new DirectorApprover();

        manegerApprover.setNextApprover(seniorManagerAppprover);
        seniorManagerAppprover.setNextApprover(directorApprover);

        manegerApprover.approve(purchaseOrder);

        // Example 2 i.e Logging
        var logger = new InfoLogProcessor(new ErrorLogProcessor(new WarnLogProcessor(null)));

        logger.log(LogLevel.INFO, "info log");
        logger.log(LogLevel.WARN, "warn log");
        logger.log(LogLevel.ERROR, "error log");

        // run multiple times to see diffrent thread names in output
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        System.out.println("Main :: " + Thread.currentThread().getName());
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(ChainOfResponsibility::order)
                .thenApply(ChainOfResponsibility::enrich)
                .thenApplyAsync(ChainOfResponsibility::payment, executorService)
                .thenApplyAsync(ChainOfResponsibility::dispatch,executorService)
                .thenApplyAsync(ChainOfResponsibility::sendEmail);

        completableFuture.whenComplete((result, err) -> {
            if (err == null) {
                System.out.println("Final output :: " + result);
            } else {
                System.out.println(err);
            }
        });

        executorService.shutdown();
    }

    private static String sendEmail(String order) {
        System.out.println("sendEmail :: " + Thread.currentThread()
                .getName());
        return order + "sendEmail ";
    }

    private static String dispatch(String order) {
        System.out.println("dispatch :: " + Thread.currentThread()
                .getName());
        return order + "dispatch ";
    }

    private static String payment(String order) {
        System.out.println("payment :: " + Thread.currentThread()
                .getName());
        return order + "payment ";
    }

    private static String enrich(String order) {
        System.out.println("enrich :: " + Thread.currentThread()
                .getName());
        return order + "enrich ";
    }

    private static String order() {
        System.out.println("order :: " + Thread.currentThread()
                .getName());
        return "order ";
    }
}
