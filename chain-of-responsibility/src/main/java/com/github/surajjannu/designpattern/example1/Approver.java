package com.github.surajjannu.designpattern.example1;

public abstract class Approver {
    private Approver nextApprover;

    public Approver getNextApprover(){
        return nextApprover;
    }

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approve(PurchaseOrder purchaseOrder);
}
