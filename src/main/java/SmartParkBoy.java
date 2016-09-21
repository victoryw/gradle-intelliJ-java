import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by victoryw on 9/20/16.
 */
public class SmartParkBoy extends ParkAgent {
    public SmartParkBoy(ArrayList<ParkLot> parkLots)  {
        super(parkLots);
    }

    public SmartParkBoy(ParkLot parkLot) {
        super(parkLot);
    }

    @Override
    public String Park(Car car) throws NoSpaceException {
        return parkLots.
                stream().
                max(Comparator.comparing(lot -> lot.getAvailableCount())).
                get().
                Park(car);
    }
}
