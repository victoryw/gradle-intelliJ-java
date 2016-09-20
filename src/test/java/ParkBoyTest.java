import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ParkBoyTest{
    @Test
    public void should_pick_park_by_park_boy() throws NoSpaceException {
        ParkBoy boy = new ParkBoy(new ParkLot(1));
        Car car = new Car();
        String token = boy.Park(car);
        Car pickOutCar = boy.Pick(token);
        assertEquals(car,pickOutCar);
    }

    @Test
    public void should_park_car_into_two_park_lot_by_order() throws NoSpaceException {
        ArrayList<ParkLot> parkLots = new ArrayList<>();
        parkLots.add(new ParkLot(1));
        ParkLot parkLot2 = new ParkLot(1);
        parkLots.add(parkLot2);
        ParkBoy boy = new ParkBoy(parkLots);
        boy.Park(new Car());

        Car car = new Car();
        String token = boy.Park(car);

        assertEquals(car,boy.Pick(token));
    }

}



