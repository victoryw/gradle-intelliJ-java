import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

/**
 * Created by victoryw on 9/20/16.
 */
public class ParkLot {

    private final int maxAvaiableCarNum;

    public ParkLot(int i) {
        maxAvaiableCarNum = i;
    }

    ArrayList<Car> cars = new ArrayList<>();

    public String Park(Car car) throws NoSpaceException {
        if(canParkNewCar()){
            throw new NoSpaceException();
        }
        cars.add(car);
        return String.valueOf(cars.indexOf(car));
    }

    private boolean canParkNewCar() {
        return cars.toArray().length+1>maxAvaiableCarNum;
    }

    public Car Pick(String token) {
        int index = Integer.parseInt(token);
        return cars.get(index);
    }
}
