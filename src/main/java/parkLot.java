import java.util.HashMap;
import java.util.UUID;

/**
 * Created by victoryw on 9/20/16.
 */
public class ParkLot {

    protected final int maxAvailableCarNam;

    public ParkLot(int i) {
        maxAvailableCarNam = i;
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
        return getAvailableCount() > 0;
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

    public int getAvailableCount() {
        return maxAvailableCarNam -cars.size();
    }

    public double GetPlotRatio() {
        return (double) getAvailableCount() / (double) maxAvailableCarNam;
    }

    public void Report(int level, StringBuilder builder) {
        builder.append(new String(new char[level]).replace("\0", " "));
        builder.append(String.format("%1 %2", maxAvailableCarNam,cars.size()));
    }
}


