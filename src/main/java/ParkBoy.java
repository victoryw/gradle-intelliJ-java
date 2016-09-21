import java.util.ArrayList;

/**
 * Created by victoryw on 9/20/16.
 */
public class ParkBoy extends ParkAgent {


    public ParkBoy(ParkLot parkLot) {
        super(parkLot);
    }

    public ParkBoy(ArrayList<ParkLot> parkLots) {
        super(parkLots);
    }

    @Override
    protected ParkLot selectLot() {
        return parkLots.stream().
                    filter(lot -> lot.CanParkNewCar()).
                    findFirst().
                    get();
    }
}
