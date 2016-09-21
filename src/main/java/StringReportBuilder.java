/**
 * Created by victoryw on 9/21/16.
 */
public class StringReportBuilder {


    private StringBuilder stringBuilder;

    public StringReportBuilder(){
        this.stringBuilder = new StringBuilder();
    }

    public void AppendDialogue(Manager manager) {
        stringBuilder.append(manager.GetContent());
    }

    public void AppendDialogue(int level, ParkLot lot) {
        stringBuilder.append(new String(new char[level]).replace("\0", " "));
        stringBuilder.append(lot.GetContent());
    }


    public void AppendReportToReport(int level, ParkLot lot) {
        stringBuilder.append("/r/n");
        lot.Report(level+1, this);
    }

    public void AppendReportToReport(int level, ParkAgent boy) {
        stringBuilder.append("/r/n");
        boy.Report(level+1, this);
    }


    public void AppendDialogue(int level, ParkAgent parkAgent) {
        stringBuilder.append(new String(new char[level]).replace("\0", " "));
        stringBuilder.append(parkAgent.GetContent());
    }

    public String Build(){
        return stringBuilder.toString();
    }
}
