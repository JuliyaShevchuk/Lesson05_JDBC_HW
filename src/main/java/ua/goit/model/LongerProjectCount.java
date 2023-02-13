package ua.goit.model;

public class LongerProjectCount {
    private String name;
    private int monthCount;

    public LongerProjectCount(String name, int monthCount) {
        this.name = name;
        this.monthCount = monthCount;
    }

    public String getName() {
        return name;
    }

    public int getMonthCount() {
        return monthCount;
    }

    @Override
    public String toString() {
        return "LongerProjectCount{" +
                "name='" + name + '\'' +
                ", monthCount=" + monthCount +
                '}';
    }
}
