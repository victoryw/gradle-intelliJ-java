import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by victoryw on 9/20/16.
 */
public class ParkLot {

    private final int maxAvaiableCarNum;

    public ParkLot(int i) {
        maxAvaiableCarNum = i;
    }

    HashMap<String,Car> cars = new HashMap<>();

    public String Park(Car car) throws NoSpaceException {
        if(!CanParkNewCar()){
            throw new NoSpaceException();
        }
        String token = String.valueOf(UUID.randomUUID());
        cars.put(token,car);
        return token;
    }

    public boolean CanParkNewCar() {
        return getAvaiableCount() > 0;
    }

    public Car Pick(String token) {
        if(cars.containsKey(token))
        {
            Car car = cars.get(token);
            cars.remove(token);
            return car;
        }
        return  null;
    }

    public int getAvaiableCount() {
        return maxAvaiableCarNum-cars.size();
    }

    public double GetPlotRatio() {
        return (double)getAvaiableCount() / (double)maxAvaiableCarNum;
    }
}
