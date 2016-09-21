/**
 * Created by victoryw on 9/21/16.
 */
public class StringReportBuilder {
    public static void AppendDialogue(int level, StringBuilder builder, ParkAgent parkAgent) {
        builder.append(new String(new char[level]).replace("\0", " "));
        builder.append(parkAgent.GetContent());
    }

    public static void AppendDialogue(int level, StringBuilder builder, ParkLot lot) {
        builder.append(new String(new char[level]).replace("\0", " "));
        builder.append(lot.GetContent());
    }

    public void AppendReportToReport(int level, StringBuilder builder, ParkLot lot) {
        builder.append("/r/n");
        lot.Report(level+1, builder);
    }


    public void AppendReportToReport(int level, StringBuilder builder, ParkAgent boy) {
        builder.append("/r/n");
        boy.Report(level+1, builder);
    }
}
