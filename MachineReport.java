package dragunovskiy_sergey.csv_parser;

import java.util.Date;

public class MachineReport {
    private String seriesReference;
    private Date period;
    private String dataValue;
    private boolean suppressed;
    private Status status;
    private String units;
    private String magnitude;
    private String subject;
    private String group;
    private String seriesTitle1;
    private String seriesTitle2;
    private String seriesTitle3;
    private String seriesTitle4;
    private String seriesTitle5;

    public String getSeriesReference() {
        return seriesReference;
    }

    public void setSeriesReference(String seriesReference) {
        this.seriesReference = seriesReference;
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public boolean isSuppressed() {
        return suppressed;
    }

    public void setSuppressed(boolean suppressed) {
        this.suppressed = suppressed;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSeriesTitle1() {
        return seriesTitle1;
    }

    public void setSeriesTitle1(String seriesTitle1) {
        this.seriesTitle1 = seriesTitle1;
    }

    public String getSeriesTitle2() {
        return seriesTitle2;
    }

    public void setSeriesTitle2(String seriesTitle2) {
        this.seriesTitle2 = seriesTitle2;
    }

    public String getSeriesTitle3() {
        return seriesTitle3;
    }

    public void setSeriesTitle3(String seriesTitle3) {
        this.seriesTitle3 = seriesTitle3;
    }

    public String getSeriesTitle4() {
        return seriesTitle4;
    }

    public void setSeriesTitle4(String seriesTitle4) {
        this.seriesTitle4 = seriesTitle4;
    }

    public String getSeriesTitle5() {
        return seriesTitle5;
    }

    public void setSeriesTitle5(String seriesTitle5) {
        this.seriesTitle5 = seriesTitle5;
    }
}
