import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GumballMachine
{
    /** Quarter: 25 cents in U.S. */
    private static int QUARTERVALUE = 25;

    /** Dime: 10 cents in U.S. */
    private static int DIMEVALUE = 10;

    /** Nickel: 5 cents in U.S. */
    private static int  NICKELVALUE = 5;

    /**
     * enum class of three possible coin types used on gumball machine.
     */
    enum COINTYPE {
        QUARTER("quarter"), DIME("dime"), NICKEL("nickel");

        private String coinName;

        COINTYPE(String coinName){
            this.coinName = coinName;
        }

        @Override
        public String toString() {
            return coinName;
        }
    }

    /** Accepted types of coins on a particular gumball machine */
    private Set<COINTYPE> acceptedCoinType;

    /** remaining gumball count in machine */
    private int gumballStock;

    /** Received amount in cents from buyer */
    private int receivedAmount;

    /** Minimum of cents needed */
    private int minimumOperatingAmount;

    /** number of inserted quarter coins */
    private int quartersCounter;

    /** number of inserted dime coins */
    private int dimesCounter;

    /** number of inserted nickel coins */
    private int nickelsCounter;


    public GumballMachine( int gumballStock, int minimumOperatingAmount, COINTYPE[] goodCoins) {
        this.gumballStock = gumballStock;
        this.minimumOperatingAmount = minimumOperatingAmount;
        acceptedCoinType = new HashSet<>(Arrays.asList(goodCoins));
    }

    /**
     *
     * @param coin: buyer inserted coin type
     */
    public void insertCoin(COINTYPE coin){
        if(!acceptedCoinType.contains(coin)){
            System.out.println("Sorry, " + coin.toString() + " is not accepted on this machine");
            return;
        }

        String message = "Thank you! You inserted a " + coin.toString() + ".";
        System.out.println(message);
        switch (coin){
            case QUARTER:
                receivedAmount += QUARTERVALUE;
                quartersCounter++;
                break;
            case DIME:
                receivedAmount += DIMEVALUE;
                dimesCounter++;
                break;
            case NICKEL:
                receivedAmount += NICKELVALUE;
                nickelsCounter++;
                break;
        }
    }

    public int getGumballStock(){
        return gumballStock;
    }

    public boolean hasGumBallLeft(){
        return getGumballStock() > 0;
    }

    public void turnCrank()
    {
        if ( this.receivedAmount >= this.minimumOperatingAmount )
        {
            if ( hasGumBallLeft() ) {
                this.gumballStock-- ;
                this.receivedAmount = 0;
                System.out.println( "Thanks for your purchase!  Gumball Ejected!" ) ;
            }
            else{
                System.out.println( "No More Gumballs!  Sorry, can't return your coins." ) ;
            }
        }
        else
        {
            StringBuilder message = new StringBuilder("You still need to insert "
                    + (minimumOperatingAmount - receivedAmount) + " more cents.\nThis machine accepts: ");
            for(COINTYPE c : acceptedCoinType){
                message.append(c.toString()).append("s, ");
            }

            System.out.println(message.substring(0, message.length() - 2) + ".");
        }
    }

    public static void main(String[] args) {
        /** Sample execution of the program */

        /** Type One: Cost: 25 cents, Accepts only quarters */
        GumballMachine machineTypeOne = new GumballMachine(10, 25, new COINTYPE[]{COINTYPE.QUARTER});

        /** Type Twp: Cost: 50 cents, Accepts only quarters */
        GumballMachine machineTypeTwo = new GumballMachine(10, 50, new COINTYPE[]{COINTYPE.QUARTER});

        /** Type Three: Cost: 50 cents, Accepts quarters, dimes and nickels */
        GumballMachine machineTypeThree = new GumballMachine(10, 50, new COINTYPE[]{COINTYPE.QUARTER, COINTYPE.DIME, COINTYPE.NICKEL});



        /** Type one operation */
        System.out.println("Type 1 running:");
        machineTypeOne.insertCoin(COINTYPE.QUARTER);
        machineTypeOne.turnCrank();
        System.out.println("-----------------\n\n");

        /** Type one operation */
        System.out.println("Type 2 running:");
        machineTypeTwo.insertCoin(COINTYPE.QUARTER);
        machineTypeTwo.turnCrank();
        machineTypeTwo.insertCoin(COINTYPE.DIME);
        machineTypeTwo.insertCoin(COINTYPE.QUARTER);
        machineTypeTwo.turnCrank();
        System.out.println("-----------------\n\n");

        /** Type one operation */
        System.out.println("Type 3 running:");
        machineTypeThree.insertCoin(COINTYPE.QUARTER);
        machineTypeThree.insertCoin(COINTYPE.DIME);
        machineTypeThree.turnCrank();
        machineTypeThree.insertCoin(COINTYPE.NICKEL);
        machineTypeThree.turnCrank();
        machineTypeThree.insertCoin(COINTYPE.DIME);
        machineTypeThree.turnCrank();
        System.out.println("-----------------\n\n");
    }
}

