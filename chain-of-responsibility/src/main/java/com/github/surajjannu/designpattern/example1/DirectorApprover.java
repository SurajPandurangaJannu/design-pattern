package com.github.surajjannu.designpattern.example1;

public class DirectorApprover extends Approver {

    @Override
    public void approve(PurchaseOrder purchaseOrder) {
        System.out.printf("Director has approved the purchase order %s of amount %d",purchaseOrder.name(),purchaseOrder.amount());
        System.out.println();
        var nextApprover = getNextApprover();
        if (nextApprover != null)
            nextApprover.approve(purchaseOrder);
    }
}
