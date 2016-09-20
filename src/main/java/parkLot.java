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
        return cars.keySet().toArray().length+1 <= maxAvaiableCarNum;
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

}
