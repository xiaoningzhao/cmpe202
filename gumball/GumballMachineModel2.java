public class GumballMachineModel2 implements VendingMachine {

    private int num_gumballs;
    private int num_quarters;

    public GumballMachineModel2(int size) {
        // initialise instance variables
        this.num_gumballs = size;
        this.num_quarters = 0;
    }

    @Override
    public void insertCoin(int coin) {
        if ( coin == 25 )
            this.num_quarters += 1;
    }

    @Override
    public void turnCrank() {
        if ( this.num_quarters >= 2 )
        {
            if ( this.num_gumballs > 0 )
            {
                this.num_gumballs--;
                this.num_quarters -= 2;
                System.out.println( "Thanks for your quarters.  Gumball Ejected!" ) ;
            }
            else
            {
                System.out.println( "No More Gumballs!  Sorry, can't return your quarter." ) ;
            }
        }
        else
        {
            System.out.println( "Please insert two quarters. Current number of quarters is "+num_quarters );
        }
    }
}
