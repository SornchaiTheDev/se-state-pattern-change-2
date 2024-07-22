// 6510405814 Sornchai Somsakul

package states;

import interfaces.State;
import services.GumballMachineService;

public class GumballSoldState implements State {
    GumballMachineService service;

    public GumballSoldState(GumballMachineService service) {
        this.service = service;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You already insert quarter wait for gumball to roll out!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("It's to late to eject the quarter now :P");
    }

    @Override
    public void turnCrank() {
        System.out.println("Please wait for gumball to roll out!");
    }

    @Override
    public void dispense() {
        System.out.println("A " + service.getGumballFlavor() + " gumball comes rolling out the slot");
        if (service.getGumballAmount() <= 0) {
            System.out.println("Oops, out of gumballs!");
            service.setState(service.getOutOfGumballState());
            return;
        }
        service.setState(service.getNoQuarterState());
    }

    @Override
    public void choose(String color) {
        System.out.println("It's to late you already turn the crank!");
    }


}
