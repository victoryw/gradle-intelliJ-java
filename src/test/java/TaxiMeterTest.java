import org.junit.Test;
import static org.junit.Assert.*;

public class  TaxiMeterTest{
    @Test
    public void should_get_6_yuan_when_the_consumer_pay_given_he_take_1_km(){
        TaxiMeter meter = new TaxiMeter();
        assertEquals(meter.Computer(1),6);
    }

}
