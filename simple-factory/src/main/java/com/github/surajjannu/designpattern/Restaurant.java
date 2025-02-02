package com.github.surajjannu.designpattern;

public class Restaurant {

    public void prepareBurger(String burgerType) {
        if ("BEEF".equals(burgerType)) {
            final BeefBurger beefBurger = new BeefBurger();
            beefBurger.prepare();
        } else if ("VEGGIE".equals(burgerType)) {
            final VeggieBurger veggieBurger = new VeggieBurger();
            veggieBurger.prepare();
        } else {
            System.out.println("Can't prepare burger of type " + burgerType);
        }
    }

}
