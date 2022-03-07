package Factory;

import Enums.Color;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidation {

    public static String validation(String carValues) throws IllegalArgumentException {
        try {
            LocalDate localDate = LocalDate.now();

            String[] stringValidation = carValues.split(" ");

            Pattern pattern = Pattern.compile("\\d*\s\\w{1,50}\s\\w{1,50}\s\\d*\s" + Color.valueOf(colorValidation(stringValidation[4])).getColor() + "\s\\d");
            Matcher matcher = pattern.matcher(carValues.toLowerCase());

            if (matcher.find() && trueYearCheck(localDate.getYear(), stringValidation[3])) {
                return carValues;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("This command is not valid");
        }
        throw new IllegalArgumentException();
    }

    public static String colorValidation(String color) {
        String[] colors = color.split("-");
        String colorValid = colors.length < 2 ? color : colors[0] + "_" + colors[1];
        return colorValid.toUpperCase();
    }

    public static boolean trueId(List<Car> cars, long id) {
        boolean idVValidation = true;
        for (Car car : cars) {
            if (car.getId() == id) {
                idVValidation = false;
                System.out.println("This id is already exists");
            }
        }
        return idVValidation;
    }

    private static boolean trueYearCheck(int carYear, String carYearValid) {
        int validYearValue = Integer.parseInt(carYearValid);
        return validYearValue >= carYear - 5 && validYearValue <= carYear;
    }

    public static long validationLong(String carId) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile("\\d*");
        Matcher matcher = pattern.matcher(carId);
        if (matcher.find()) return Long.parseLong(carId);
        throw new IllegalArgumentException();
    }
}
