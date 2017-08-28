package justanorg.bitbroker.model;

import com.google.common.base.MoreObjects;

import java.util.List;

public class KChart {
    private int period;
    private Long startTime;
    private Integer limit;
    private List<KPoint> points;

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long timeAfter) {
        this.startTime = timeAfter;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<KPoint> getPoints() {
        return points;
    }

    public void setPoints(List<KPoint> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("period", getPeriod())
                .add("startTime", getStartTime())
                .add("limit", getLimit())
                .add("points", getPoints())
                .toString();
    }
}
