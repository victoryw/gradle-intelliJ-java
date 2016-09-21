import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by victoryw on 9/20/16.
 */
public class SuperBoy extends ParkAgent {
    public SuperBoy(ParkLot parkLot) {
        super(parkLot);
    }

    public SuperBoy(ArrayList<ParkLot> parkLots){
        super(parkLots);
    }


    @Override
    protected ParkLot selectLot() {
        return parkLots.stream()
                    .max(Comparator.comparing(lot -> lot.GetPlotRatio()))
                    .get();
    }

}
