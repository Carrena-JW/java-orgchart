package carrena.orgchart.enums;

public enum UserCommandType {
    createUserCommand(1),
    createUserTitleCommand(2),
    createUserRoleCommand(3),
    createUserPositionCommand(4),

    unknownCommand(0);


    private final int value;

    UserCommandType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
