import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by victoryw on 9/20/16.
 */
public class SuperBoy extends ParkBoy {
    public SuperBoy(ParkLot parkLot) {
        super(parkLot);
    }

    public SuperBoy(ArrayList<ParkLot> parkLots){
        super(parkLots);
    }


    @Override
    public String Park(Car car) throws NoSpaceException {
        return parkLots.stream()
                .max(Comparator.comparing(lot->lot.GetPlotRatio()))
                .get()
                .Park(car);
    }
}
