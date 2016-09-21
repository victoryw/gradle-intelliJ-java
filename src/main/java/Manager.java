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

        AppendParkLotToReport(1, builder, lot);

        AppendBoyToReport(builder, superBoy);
        AppendBoyToReport(builder,smartParkBoy);
        AppendBoyToReport(builder,parkBoy);


        return builder.toString();

    }

    protected void AppendBoyToReport(StringBuilder builder, ParkAgent boy) {
        builder.append("/r/n");
        boy.Report(1, builder);
    }

    protected void AppendParkLotToReport(int level, StringBuilder builder, ParkLot lot) {
        builder.append("/r/n");
        lot.Report(level+1, builder);
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
