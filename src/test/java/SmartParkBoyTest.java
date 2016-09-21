import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SmartParkBoyTest{
    @Test
    public void should_pick_park_smart_pakr_boy() throws NoSpaceException {
        ParkAgent boy = new SmartParkBoy(new ParkLot(1));
        Car car = new Car();
        String token = boy.Park(car);
        Car pickedCar = boy.Pick(token);
        assertEquals(car,pickedCar);

    }


    @Test
    public void should_park_firstly_in_to_most_avaiable_position() throws NoSpaceException {
        ArrayList<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(new ParkLot(1));
        ParkLot parkLot = new ParkLot(2);
        parkLots.add(parkLot);
        ParkAgent boy = new SmartParkBoy(parkLots);
        Car car = new Car();
        String token = boy.Park(car);
        assertEquals(parkLot.Pick(token),car);
    }
}
