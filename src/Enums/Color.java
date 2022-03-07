package Enums;

public enum Color {
    ORANGE("orange"),
    DARK_RED("dark-red"),
    BLACK("black"),
    LIGHT_BLUE("light-blue"),
    WHITE("white");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}
