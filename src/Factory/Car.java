package Factory;

import Enums.Color;

public class Car {
    private long id;
    private String carName;
    private int releaseYear;
    private Color color;
    private int priceBYR;

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPriceBYR(int priceBYR) {
        this.priceBYR = priceBYR;
    }

    public Car(String carValues) {
        String[] strings = carValues.split(" ");
        this.id = Long.parseLong(strings[0]);
        this.carName = strings[1] + " " + strings[2];
        this.releaseYear = Integer.parseInt(strings[3]);
        this.color = Color.valueOf(StringValidation.colorValidation(strings[4]));
        this.priceBYR = Integer.parseInt(strings[5]);
    }

    public long getId() {
        return id;
    }

    public String getCarName() {
        return carName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Color getColor() {
        return color;
    }

    public int getPriceBYR() {
        return priceBYR;
    }

    public Car() {

    }

    @Override
    public String toString() {
        return id + " " + carName + " " + releaseYear
                + " " + color.getColor() + " " + priceBYR;
    }
}
