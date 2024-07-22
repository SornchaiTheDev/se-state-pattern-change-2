// 6510405814 Sornchai Somsakul

package services;

import interfaces.State;
import states.*;

public class GumballMachineService {
    private int gumballAmount;
    private String gumballFlavor;
    private State currentState;
    private State noQuarterState;
    private State hasQuarterState;
    private State gumballSoldState;
    private State outOfGumballState;
    private State winnerState;
    private State chooseFavorState;


    public int getGumballAmount() {
        return gumballAmount;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getGumballSoldState() {
        return gumballSoldState;
    }

    public State getOutOfGumballState() {
        return outOfGumballState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public GumballMachineService(int gumballAmount) {
        this.gumballAmount = gumballAmount;
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.gumballSoldState = new GumballSoldState(this);
        this.outOfGumballState = new OutOfGumballState(this);
        this.winnerState = new WinnerState(this);
        this.chooseFavorState = new ChooseFavorState(this);
        this.currentState = noQuarterState;

    }

    public State getChooseFavorState() {
        return chooseFavorState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void insertQuarter() {
        currentState.insertQuarter();
    }

    public void ejectQuarter() {
        currentState.ejectQuarter();
    }

    public void turnCrank() {
        currentState.turnCrank();
        currentState.dispense();
    }

    public void setGumballFlavor(String gumballFlavor) {
        this.gumballFlavor = gumballFlavor;
    }

    public String getGumballFlavor() {
        return gumballFlavor;
    }

    public void choose(String color) {
        currentState.choose(color);
    }

    public void setGumballAmount(int gumballAmount) {
        this.gumballAmount = gumballAmount;
    }

    @Override
    public String toString() {
        String status;
        if (gumballAmount == 0) {
            status = "Machine is sold out";
        } else {
            status = "Machine is waiting for quarter\n";
        }

        return String.format("\nMighty Gumball Inc.\nJava-enabled Standing Gumball Model #2004\nInventory: %d gumballs\n%s", gumballAmount, status);
    }
}
