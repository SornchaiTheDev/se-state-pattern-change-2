package states;

import interfaces.State;
import services.GumballMachineService;

public class NoQuarterState implements State {
    GumballMachineService service;

    public NoQuarterState(GumballMachineService service) {
        this.service = service;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        service.setState(service.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first!");
    }
}
