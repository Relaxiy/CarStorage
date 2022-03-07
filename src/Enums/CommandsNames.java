package Enums;

public enum CommandsNames {
    ADD("add"),
    UPDATE("update"),
    DELETE("delete"),
    GET("get"),
    LIST("list"),
    REPORT("report"),
    CLOSE("close");

    private String command;

    CommandsNames(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }
}
