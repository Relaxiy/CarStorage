package DataBase;

import Exceptions.CloseException;
import Factory.Car;
import Factory.StringValidation;

import java.util.ArrayList;
import java.util.List;

public class CarsDataBase {

    private FileCarStorage fileCarStorage;
    private List<Car> cars = new ArrayList<>();

    public CarsDataBase() {
        this.fileCarStorage = FileCarStorage.getInstance();
        cars.addAll(fileCarStorage.loadCars());
    }

    public void add(Car car) {
        if (StringValidation.trueId(cars, car.getId())) {
            cars.add(car);
            System.out.println("Add successful!");
        }
    }

    public void update(Car carUpdate){
        for(Car car: cars){
            if (car.getId() == carUpdate.getId()){
                car.setCarName(carUpdate.getCarName());
                car.setReleaseYear(carUpdate.getReleaseYear());
                car.setColor(carUpdate.getColor());
                car.setPriceBYR(carUpdate.getPriceBYR());
                System.out.println("Info update!");
            }
        }
    }

    public void delete(long id){
        cars.removeIf(car -> car.getId() == id);
    }

    public void get(long id){
        for(Car car: cars){
            if (car.getId() == id){
                System.out.println(car.getCarName() + " " + car.getReleaseYear()
                        + " " + car.getColor().getColor() + " " + car.getPriceBYR());
            }
        }
    }

    public void list(){
        for (Car car: cars){
            System.out.println(car);
        }
    }

    public void report(long id){
        for(Car car: cars){
            if (car.getId() == id){
                String report = "Отчет об автомобиле " + car.getCarName()
                        + " " + car.getColor().getColor() + "\n"
                        + "Год выпуска: " + car.getReleaseYear() +
                        "\n" + "Цена: " + car.getPriceBYR();

                String fileName = car.getCarName() + "_" + car.getId() + ".txt";
                fileCarStorage.reportCar(report, fileName);
            }
        }
    }

    public void close() throws CloseException {
        List<String> saveCarList = new ArrayList<>();
        cars.forEach(car -> saveCarList.add(car.toString()));
        fileCarStorage.saveCars(saveCarList);
        throw new CloseException();
    }
}
