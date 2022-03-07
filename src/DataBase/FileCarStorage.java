package DataBase;

import Factory.Car;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileCarStorage {

    private static volatile FileCarStorage instance;
    private final String fileName = "D:/sobes_Java/";

    public static FileCarStorage getInstance() {
        FileCarStorage localInstance = instance;
        if (localInstance == null) {
            synchronized (FileCarStorage.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new FileCarStorage();
                }
            }
        }
        return localInstance;
    }

    public Collection<Car> loadCars() {
        File file = new File(fileName);
        if (!file.mkdir()) {
            file.mkdirs();
        }
        try {
            List<String> carDefinitionsList = Files.readAllLines(Path.of(fileName + "cars.txt"));
            return mapToCar(carDefinitionsList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    private static List<Car> mapToCar(List<String> carDefinitionsList) {
        List<Car> cars = new ArrayList<>();
        carDefinitionsList.forEach(carValues -> cars.add(new Car(carValues)));
        return cars;
    }

    public void saveCars(List<String> saveCarList) {
        File file = new File(fileName);
        if (!file.mkdir()) {
            file.mkdirs();
        }
        try (FileWriter fileWriter = new FileWriter(fileName + "cars.txt")) {
            for (String car : saveCarList) {
                fileWriter.write(car + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void reportCar(String report, String fileName) {
        File file = new File(this.fileName + "carsReports/");
        if (!file.mkdir()) {
            file.mkdirs();
        }
        try (FileWriter fileWriter = new FileWriter(this.fileName + "carsReports/" + fileName)) {
            fileWriter.write(report);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
