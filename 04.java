import java.util.*;

class ticket{
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    ticket(int tn, String cn, int sn){
        ticketNumber=tn;
        customerName=cn;
        seatNumber=sn;
    }

    public int getticketNumber(){
        return ticketNumber;
    }

    public String getcustomerName(){
        return customerName;
    }

    public int getseatNumber(){
        return seatNumber;
    }

    public void setTicketNumber(int ticketNumber){
        this.ticketNumber=ticketNumber;
    }

    public void setCustomerName(String customerName){
        this.customerName=customerName;
    }

    public void setSeatNumber(int seatNumber){
        this.seatNumber=seatNumber;
    }

}

class BookingSystem{
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        int[] seatNumber=new int[10];
        int ticketCout=0;

        do{
            System.out.println("Movie Theater");
            System.out.println("Available Seats");
            for(int i=0; i<10; i++){
                if(seatNumber[i]==0){
                    System.out.println(seatNumber[i]+1);
                }
            }

            
        }
        while (ticketCout=10);
    }
}