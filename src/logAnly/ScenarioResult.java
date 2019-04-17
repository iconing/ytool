package logAnly;

import java.util.Map;

public class ScenarioResult {
    private int count;
    private double maxTime;
    private double minTime;
    private String svrName;
    private double averageTime;
    private Map<Double, Integer> timeMap;

    public String getSvrName() {
        return svrName;
    }

    public void setSvrName(String svrName) {
        this.svrName = svrName;
    }

    public double getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(double averageTime) {
        this.averageTime = averageTime;
    }

    public double getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(double maxTime) {
        this.maxTime = maxTime;
    }

    public double getMinTime() {
        return minTime;
    }

    public void setMinTime(double minTime) {
        this.minTime = minTime;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ScenarioResult{" +
                "count=" + count +
                ", maxTime=" + maxTime + "ms" +
                ", minTime=" + minTime + "ms" +
                ", svrName='" + svrName + '\'' +
                ", averageTime=" + averageTime + "ms" +
                '}';
    }

    public Map<Double, Integer> getTimeMap() {
        return timeMap;
    }

    public void setTimeMap(Map<Double, Integer> timeMap) {
        this.timeMap = timeMap;
    }
}
