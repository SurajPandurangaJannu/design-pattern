package com.github.surajjannu.designpattern;

public class Application {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        restaurant.prepareBurger("BEEF");

        restaurant.prepareBurger("VEGGIE");

        restaurant.prepareBurger("UNKNOWN");
    }
}
