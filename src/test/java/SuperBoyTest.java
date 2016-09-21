import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SuperBoyTest{
    @Test
    public void should_park_pick_car_by_super_boy() throws NoSpaceException {
        ParkAgent boy = new SuperBoy(new ParkLot(1));
        Car car = new Car();
        String token = boy.Park(car);
        assertEquals(car,boy.Pick(token));

    }

    @Test
    public void should_firstly_park_car_into_min_plot_ratio() throws NoSpaceException {
        ArrayList<ParkLot> lots = new ArrayList<>();
        ParkLot lot1 = new ParkLot(2);
        lot1.Park(new Car());
        lots.add(lot1);
        ParkLot lot2 = new ParkLot(3);
        lot2.Park(new Car());
        lots.add(lot2);

        ParkAgent boy = new SuperBoy(lots);
        Car car = new Car();
        String token = boy.Park(car);
        assertEquals(car,lot2.Pick(token));

    }

}


