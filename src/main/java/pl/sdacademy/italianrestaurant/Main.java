package pl.sdacademy.italianrestaurant;

import pl.sdacademy.italianrestaurant.staff.Chef;
import pl.sdacademy.italianrestaurant.staff.Kitchen;
import pl.sdacademy.italianrestaurant.staff.Waiter;

public class Main {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        new Waiter(kitchen,"Antonio").start();
        new Waiter(kitchen,"Giulia").start();
        new Chef(kitchen, "Luigi").start();
        new Chef(kitchen,"Fabricio").start();
        new Chef(kitchen,"Francesca").start();

        System.out.println("PREGO restaurant is working now!");
        System.out.flush();


    }
}