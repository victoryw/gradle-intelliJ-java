public class Manager extends ParkAgent{


    private SuperBoy superBoy;
    private ParkBoy parkBoy;
    private SmartParkBoy smartParkBoy;

    public Manager(ParkLot lot,
                   SuperBoy superBoy,
                   ParkBoy parkBoy,
                   SmartParkBoy smartParkBoy) {
        super(lot);

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

    @Override
    protected ParkLot selectLot() {
        return parkLots.get(0);
    }



    public String TotalReport(){
        StringBuilder builder = new StringBuilder();
        Report(0, builder);
        AppendNewElement(builder, superBoy);
        AppendNewElement(builder, smartParkBoy);
        AppendNewElement(builder, parkBoy);
        return builder.toString();

    }



}
