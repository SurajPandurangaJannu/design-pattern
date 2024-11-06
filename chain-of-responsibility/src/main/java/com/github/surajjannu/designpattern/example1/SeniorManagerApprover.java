package com.github.surajjannu.designpattern.example1;

public class SeniorManagerApprover extends Approver {

    @Override
    public void approve(PurchaseOrder purchaseOrder) {
        System.out.printf("Senior Manager has approved the purchase order %s of amount %d",purchaseOrder.name(),purchaseOrder.amount());
        System.out.println();
        var nextApprover = getNextApprover();
        if (nextApprover != null)
            nextApprover.approve(purchaseOrder);
    }
}
