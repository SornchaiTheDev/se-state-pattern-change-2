// 6510405814 Sornchai Somsakul

import services.GumballMachineService;

public class Main {
    public static void main(String[] args) {
        GumballMachineService service = new GumballMachineService(5);

        System.out.println(service);
        service.insertQuarter();
        service.turnCrank();
        service.ejectQuarter();

        System.out.println(service);

        service.insertQuarter();
        service.choose("Mango");
        service.choose("Orange");
        service.turnCrank();

        System.out.println(service);
    }
}