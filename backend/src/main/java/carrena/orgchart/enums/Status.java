package carrena.orgchart.enums;

public enum Status {
    inactive(0),
    active(1),
    hidden(2);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
