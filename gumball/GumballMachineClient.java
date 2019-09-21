public class GumballMachineClient {
    public static void main(String[] arg){
        VendingMachineFactory factory = new VendingMachineFactory();

        VendingMachine machine;
        machine = factory.getMachine("Model3", 0);
        machine.insertCoin(5);
        //machine.insertQuarter(25);
        machine.turnCrank();
        machine.insertCoin(25);
        machine.turnCrank();
        machine.insertCoin(25);
        machine.turnCrank();
    }
}
