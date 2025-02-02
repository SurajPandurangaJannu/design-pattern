package com.github.surajjannu.designpattern;

public class Application {

    public static void main(String[] args) {

        final Coffee basicCoffee = new BasicCoffee();
        printCoffeeDetails("Basic Coffee", basicCoffee);

        final Coffee milkCoffee = new MilkDecorator(new BasicCoffee());
        printCoffeeDetails("Milk Coffee", milkCoffee);

        final Coffee sugarCoffee = new SugarDecorator(new BasicCoffee());
        printCoffeeDetails("Sugar Coffee", sugarCoffee);

        final Coffee chocolateCoffee = new ChocolateDecorator(new BasicCoffee());
        printCoffeeDetails("Chocolate Coffee", chocolateCoffee);

        final Coffee myFavouriteCoffee = new ChocolateDecorator(new SugarDecorator(new MilkDecorator(new BasicCoffee())));
        printCoffeeDetails("My Favourite Coffee", myFavouriteCoffee);
    }

    private static void printCoffeeDetails(String coffeeType, Coffee coffee) {
        System.out.println(coffeeType + " :: has --> " + coffee.getDescription());
        System.out.println(coffeeType + " :: costs --> " + coffee.getCost());
        System.out.println();
    }

}
