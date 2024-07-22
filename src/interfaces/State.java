// 6510405814 Sornchai Somsakul

package interfaces;

public interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    void choose(String flavor);
}
