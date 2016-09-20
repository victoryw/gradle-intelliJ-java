import java.util.ArrayList;

/**
 * Created by victoryw on 9/20/16.
 */
public class ParkBoy {
    private ParkLot parkLot;
    private ArrayList<ParkLot> parkLots = new ArrayList<>();

    public ParkBoy(ParkLot parkLot) {
        parkLots.add(parkLot);
    }

    public ParkBoy(ArrayList<ParkLot> parkLots) {

        this.parkLots = parkLots;
    }

    public String Park(Car car) throws NoSpaceException {

        return parkLots.stream().
                filter(lot -> lot.CanParkNewCar()).
                findFirst().
                get().Park(car);
    }

    public Car Pick(String token) {
        return parkLots.stream().map(lot-> lot.Pick(token)).filter(car-> car != null).findFirst().get();
    }
}
