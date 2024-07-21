package states;

import interfaces.State;
import services.GumballMachineService;

public class ChooseFavorState implements State {

    GumballMachineService service;

    public ChooseFavorState(GumballMachineService service) {
        this.service = service;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Already inserted a quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        service.setState(service.getNoQuarterState());
    }

    @Override
    public void choose(String flavor) {
        if (!flavor.equals("Mango") && !flavor.equals("Orange")) {
            System.out.println("There are no " + flavor + "flavor.");
            return;
        }
        service.setGumballFlavor(flavor);
        System.out.println("You have chosen the flavor " + flavor);
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int randInt = (int) Math.floor(Math.random() * 10);

        if (randInt == 1 && service.getGumballAmount() >= 2) {
            service.setState(service.getWinnerState());
            return;
        }

        service.setGumballAmount(service.getGumballAmount() - 1);
        service.setState(service.getGumballSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("You have to choose the flavor first");
    }
}
