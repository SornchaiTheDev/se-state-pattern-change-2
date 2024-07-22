// 6510405814 Sornchai Somsakul

package states;

import interfaces.State;
import services.GumballMachineService;

public class HasQuarterState implements State {

    GumballMachineService service;

    public HasQuarterState(GumballMachineService service) {
        this.service = service;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        service.setState(service.getNoQuarterState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void turnCrank() {
        System.out.println("You have to choose the flavor first");
    }

    @Override
    public void choose(String flavor) {
        if (!flavor.equals("Mango") && !flavor.equals("Orange")) {
            System.out.println("There are no " + flavor + " flavor.");
            return;
        }
        service.setGumballFlavor(flavor);
        service.setState(service.getChooseFavorState());
        System.out.println("You have chosen the flavor " + flavor);
    }
}
