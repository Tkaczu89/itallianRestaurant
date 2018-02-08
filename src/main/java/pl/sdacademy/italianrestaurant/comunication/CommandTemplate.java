package pl.sdacademy.italianrestaurant.comunication;

import pl.sdacademy.italianrestaurant.staff.Waiter;

import java.io.IOException;
import java.io.InputStreamReader;

public abstract class CommandTemplate {


    private Waiter waiter;

    public CommandTemplate(Waiter waiter) {
        this.waiter = waiter;
    }

    public final void execute() {
        scrollTheScreen();
        greetings();
        printMenu();
        if (userActionIsRequired()) {
            int userSelection = getUserSelection();
            CommandTemplate nextCommand = processSelection(userSelection);
            executeCommand(nextCommand);

        }
    }

    private void executeCommand(CommandTemplate nextCommand) {
        //waiter.executeCommand(nextCommand);
    }

    protected abstract CommandTemplate processSelection(int userSelection);

    private int getUserSelection() {
        InputStreamReader reader = new InputStreamReader(System.in);
        int readSelection = '0';
        try {
            readSelection = reader.read();
        } catch (IOException e) {
            System.out.println("Could not read input");
        }
        return readSelection - '0';
    }

    protected boolean userActionIsRequired() {
        return true;
    }

    protected abstract void printMenu();

    private void greetings() {
        System.out.println("Hello my name is " + waiter.getWaiterName());
    }

    private void scrollTheScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

}
