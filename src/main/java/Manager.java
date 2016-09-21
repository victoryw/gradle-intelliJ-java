public class Manager {


    private ParkLot lot;
    private SuperBoy superBoy;
    private ParkBoy parkBoy;
    private SmartParkBoy smartParkBoy;

    public Manager(ParkLot lot,
                   SuperBoy superBoy,
                   ParkBoy parkBoy,
                   SmartParkBoy smartParkBoy) {
        this.lot = lot;


        this.superBoy = superBoy;
        this.parkBoy = parkBoy;
        this.smartParkBoy = smartParkBoy;
    }


    public String ParkBySuperBoy(Car car) throws NoSpaceException {
        return superBoy.Park(car);
    }

    public String PartByBoy(Car car) throws NoSpaceException{
        return parkBoy.Park(car);
    }

    public String ParkBySmartBoy(Car car) throws NoSpaceException{
        return smartParkBoy.Park(car);
    }

    public String Park(Car car) throws NoSpaceException{
        return lot.Park(car);
    }


    public String TotalReport(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("M %1 %2", GetParkedCount(), GetMaxAvailableCarNum()));
        builder.append("/r/n");
        lot.Report(1, builder);
        builder.append("/r/n");
        superBoy.Report(1, builder);
        builder.append("/r/n");
        smartParkBoy.Report(1, builder);
        builder.append("/r/n");
        parkBoy.Report(1, builder);
        return builder.toString();

    }





    protected int GetMaxAvailableCarNum() {
        return lot.maxAvailableCarNam
                    + superBoy.GetMaxAvailableCarNum()
                    + parkBoy.GetMaxAvailableCarNum()
                    + smartParkBoy.GetMaxAvailableCarNum();
    }

    protected int GetParkedCount() {

        return lot.GetParkedCars()
                + superBoy.GetParkedCount()
                + parkBoy.GetParkedCount()
                + smartParkBoy.GetParkedCount();
    }




}
