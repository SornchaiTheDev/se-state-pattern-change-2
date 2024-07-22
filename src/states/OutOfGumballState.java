// 6510405814 Sornchai Somsakul

package states;

import interfaces.State;
import services.GumballMachineService;

public class OutOfGumballState implements State {
    GumballMachineService service;

    @Override
    public void dispense() {
        System.out.println("Oops, out of gumballs");
    }

    public OutOfGumballState(GumballMachineService service) {
        this.service = service;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void choose(String color) {

    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }
}
