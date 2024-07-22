// 6510405814 Sornchai Somsakul

package states;

import interfaces.State;
import services.GumballMachineService;

public class WinnerState implements State {

    GumballMachineService service;

    public WinnerState(GumballMachineService service) {
        this.service = service;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You already insert a quarter!");
    }

    @Override
    public void choose(String color) {
        System.out.println("It's to late you already turn the crank!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("It's to late you already turn the crank!");
    }

    @Override
    public void turnCrank() {
        System.out.println("You already turn the crank!");
    }

    @Override
    public void dispense() {
        service.setGumballAmount(service.getGumballAmount() - 2);
        System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter");
        for (int i = 0; i < 2; i++) {
            System.out.println("A "+ service.getGumballFlavor() +" gumball comes rolling out the slot...");
        }

        if (service.getGumballAmount() > 0) {
            service.setState(service.getNoQuarterState());
        }else {
            service.setState(service.getOutOfGumballState());
        }
    }
}
