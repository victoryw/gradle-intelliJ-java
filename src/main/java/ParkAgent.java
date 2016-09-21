import java.util.ArrayList;

/**
 * Created by victoryw on 9/21/16.
 */
public class ParkAgent  {
    protected ArrayList<ParkLot> parkLots = new ArrayList<>();

    public ParkAgent(ParkLot parkLot) {
        parkLots.add(parkLot);
    }

    public ParkAgent(ArrayList<ParkLot> parkLots) {

        this.parkLots = parkLots;
    }

    public String GetContent() {
        return String.format("M %1 %2", GetParkedCount(), GetMaxAvailableCarNum());
    }

    public String Park(Car car) throws NoSpaceException {

        ParkLot parkLot = selectLot();
        return parkLot.Park(car);
    }

    protected ParkLot selectLot() {
        return null;
    }


    public Car Pick(String token) {
        return parkLots.stream().map(lot-> lot.Pick(token)).filter(car-> car != null).findFirst().get();
    }

    public void Report(int level, StringBuilder builder){

        StringReportBuilder reportBuilder = new StringReportBuilder(builder);
        reportBuilder.AppendDialogue(level,this);
        parkLots.stream().forEach(lot->{
            reportBuilder.AppendReportToReport(level +1, lot);
        });
    }

    public int GetParkedCount() {
        return parkLots.stream().mapToInt(lot->lot.GetParkedCars()).sum();
    }

    public int GetMaxAvailableCarNum() {
        return parkLots.stream().mapToInt(lot->lot.maxAvailableCarNam).sum();
    }
}
