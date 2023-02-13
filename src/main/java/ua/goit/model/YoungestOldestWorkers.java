package ua.goit.model;

public class YoungestOldestWorkers {
    private String name;
    private String birthday;
    private String type;

    public YoungestOldestWorkers(String name, String birthday, String type) {
        this.name = name;
        this.birthday = birthday;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "YoungestOldestWorkers{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
