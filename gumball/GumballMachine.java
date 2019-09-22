import java.util.Arrays;
import java.util.HashSet;

public class GumballMachine{

    private int num_gumballs;
    private int cost;
    private int current_balance;
    private HashSet<Integer> acceptedCoinValue;  /*Accepted coin values, such as 5, 10, 25, etc.*/


    public GumballMachine(int size, int cost, Integer[] acceptedCoinValue) {
        // initialise instance variables
        this.num_gumballs = size;
        this.cost = cost;
        this.current_balance = 0;
        this.acceptedCoinValue = new HashSet<>(Arrays.asList(acceptedCoinValue));
    }

    public void insertCoin(int coin) {
        if(acceptedCoinValue.contains(coin)) {
            this.current_balance += coin;
            System.out.println( "Coin accepted. Current balance is " + this.current_balance ) ;
        }else{
            System.out.println( "Sorry, cannot accept this type of coin." ) ;
        }

    }

    public void turnCrank() {
        if ( this.current_balance >= this.cost ){
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs--;
                this.current_balance -= this.cost;
                System.out.println( "Thanks for your coins.  Gumball Ejected!" ) ;
            }else{
                System.out.println( "No More Gumballs!  Sorry, can't return your coins." ) ;
            }
        }else{
            System.out.println( "Please insert enough coins. Cost is " + this.cost + ". Current balance is " + this.current_balance);
        }
    }

    public static void main(String[] arg){
        System.out.println("Create Model 1 machine.");
        GumballMachine machineModel1 = new GumballMachine(50,25, new Integer[]{25});
        machineModel1.insertCoin(10);
        machineModel1.insertCoin(25);
        machineModel1.turnCrank();
        System.out.println("\n");

        System.out.println("Create Model 2 machine.");
        GumballMachine machineModel2 = new GumballMachine(50,50, new Integer[]{25});
        machineModel2.insertCoin(25);
        machineModel2.insertCoin(10);
        machineModel2.turnCrank();
        machineModel2.insertCoin(25);
        machineModel2.turnCrank();
        System.out.println("\n");

        System.out.println("Create Model 3 machine.");
        GumballMachine machineModel3 = new GumballMachine(50,50, new Integer[]{5,10,25});
        machineModel3.insertCoin(25);
        machineModel3.insertCoin(10);
        machineModel3.turnCrank();
        machineModel3.insertCoin(25);
        machineModel3.turnCrank();
        machineModel3.turnCrank();
        machineModel3.insertCoin(40);
        machineModel3.turnCrank();
        System.out.println("\n");

        System.out.println("Create empty machine.");
        GumballMachine machineModelEmpty = new GumballMachine(0,25, new Integer[]{25});
        machineModelEmpty.insertCoin(25);
        machineModelEmpty.turnCrank();


    }
}
