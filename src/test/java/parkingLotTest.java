import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by victoryw on 9/20/16.
 */
public class parkingLotTest {
    @Test
    public void should_part_pick_car_into_parking_lot() throws NoSpaceException {
        ParkLot lot  = new ParkLot(1);
        Car car = new Car();
        String token = lot.Park(car);
        Car pickCar = lot.Pick(token);
        assertEquals(pickCar,car);
    }


    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void should_reply_no_space_when_park_car_in_to_full_park() throws NoSpaceException {
        ParkLot lot  = new ParkLot(1);
        Car car = new Car();
        String token = lot.Park(car);

        Car car2 = new Car();
        exception.expect(NoSpaceException.class);
        lot.Park(car2);

    }
}

