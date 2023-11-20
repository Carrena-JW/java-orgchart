package carrena.orgchart.enums;

public enum UserValidationType {
    user(0),
    title(1),
    role(2),
    position(3),
    unknown(4);

    private final int value;

    UserValidationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
