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

class BookingSystem {
    private ticket[] tickets=new ticket[10];
    private boolean[] seats=new boolean[10];
    private int numTickets=0;

    public boolean bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (numTickets >= 10) {
            System.out.println("All seats are booked.");
            return false;
        }
        
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number.");
            return false;
        }
        
        if (seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return false;
        }
        
        tickets[numTickets] = new ticket(ticketNumber, customerName, seatNumber);
        seats[seatNumber - 1] = true;
        numTickets++;
        return true;
    }

    public boolean cancelTicket(int ticketNumber) {
        for (int i = 0; i < numTickets; i++) {
            if (tickets[i].getticketNumber() == ticketNumber) {
                int seatNum = tickets[i].getseatNumber();
                seats[seatNum - 1] = false;
                
                for (int j = i; j < numTickets - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                tickets[numTickets - 1] = null;
                numTickets--;
                return true;
            }
        }
        System.out.println("Ticket with number " + ticketNumber + " not found.");
        return false;
    }

    public void displayAllBookings() {
        System.out.println("Ticket \tCustomer\tSeat");
        for (int i = 0; i < numTickets; i++) {
            System.out.println(tickets[i].getticketNumber() + "\t" + tickets[i].getcustomerName() + "\t" +  tickets[i].getseatNumber());
        }
    }
}

class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        
        bookingSystem.bookTicket(1, "Customer 1", 1);
        bookingSystem.bookTicket(2, "Customer 2", 2);
        bookingSystem.bookTicket(3, "Customer 3", 3);
        
        bookingSystem.cancelTicket(2);
        
        bookingSystem.bookTicket(4, "Customer 4", 2);
        
        bookingSystem.displayAllBookings();
    }
}