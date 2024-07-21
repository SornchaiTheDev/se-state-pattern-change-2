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
        System.out.println("You need to turn crank first");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int randInt = (int)Math.floor(Math.random() * 10);

        if(randInt == 1 && service.getGumballAmount() >= 2) {
            service.setState(service.getWinnerState());
            return;
        }

        service.setGumballAmount(service.getGumballAmount() - 1);
        service.setState(service.getGumballSoldState());
    }
}
