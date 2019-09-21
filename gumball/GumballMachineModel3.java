public class GumballMachineModel3 implements VendingMachine {

    private int num_gumballs;
    private int value_coin;

    public GumballMachineModel3(int size) {
        // initialise instance variables
        this.num_gumballs = size;
        this.value_coin = 0;
    }

    @Override
    public void insertCoin(int coin) {
        switch(coin){
            case 5:
                value_coin += 5;
                break;
            case 10:
                value_coin += 10;
                break;
            case 25:
                value_coin += 25;
                break;
            default:
                value_coin += 0;
        }

    }

    @Override
    public void turnCrank() {
        if ( this.value_coin >= 50 )
        {
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs--;
                this.value_coin -= 50;
                System.out.println( "Thanks for your coins.  Gumball Ejected!" ) ;
            }
            else
            {
                System.out.println( "No More Gumballs!  Sorry, can't return your coins." ) ;
            }
        }
        else
        {
            System.out.println( "Please insert enough coins. Current coins value is " +value_coin );
        }
    }
}
