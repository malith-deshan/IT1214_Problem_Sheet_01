class Vehicle{
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    Vehicle(String licensePlate, String ownerName, int hoursParked){
        this.licensePlate=licensePlate;
        this.ownerName=ownerName;
        this.hoursParked=hoursParked;
    }

    public String getLicensePlate(){
        return licensePlate;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public int getHourseParked(){
        return hoursParked;
    }

    public void setLicensePlate(String licensePlate){
        this.licensePlate=licensePlate;
    }

    public void setOwnerName(String ownerName){
        this.ownerName=ownerName;
    }

    public void setHourseParked(int hoursParked){
        this.hoursParked=hoursParked;
    }
}

class ParkingLot{
    Vehicle[] vehicle=new Vehicle[5];
    int VehicleCount=0;

    public void addVehicle(Vehicle newVehical){
        if(VehicleCount<5){
            vehicle[VehicleCount]=newVehical;
            VehicleCount++;
        }
        else{
            System.out.println("The Vehicle Park is full !");
        }
    }

    public void removeVehicle(String licensePlate){
        for(int i=0; i<VehicleCount; i++){
            if (vehicle[i].getLicensePlate()==licensePlate){
                for(int j=i; j<VehicleCount; j++){
                    vehicle[j]=vehicle[j+1];
                }
                vehicle[VehicleCount-1]=null;
                VehicleCount--;
                System.out.println("License Plate "+licensePlate+" is Removed in park.");
                return;
            }
        }
        System.out.println("License Plate No "+licensePlate+" is not found! ");
    }

    public void displayall(){
        for(int i=0; i<VehicleCount; i++){
            System.out.println("License Plate:"+vehicle[i].getLicensePlate());
            System.out.println("Owner:"+vehicle[i].getOwnerName());
            System.out.println("Hourse:"+vehicle[i].getHourseParked());
            System.out.println();
        }
    }
}

class Main{
    public static void main(String[] args){
        ParkingLot Parked=new ParkingLot();

        Vehicle v1=new Vehicle("ABC123","John Doe",2);
        Vehicle v2=new Vehicle("XYZ789","Jane Smith",4);
        Vehicle v3=new Vehicle("LMN456","Bob Brown",1);

        Parked.addVehicle(v1);
        Parked.addVehicle(v2);
        Parked.addVehicle(v3);

        Parked.removeVehicle("XYZ789");

        Parked.displayall();

    }
}