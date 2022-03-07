package Commands;

import Factory.Car;
import DataBase.CarsDataBase;
import Enums.CommandsNames;
import Factory.StringValidation;

public class AddCommand implements Command {
    private CarsDataBase carsDataBase;
    private final CommandsNames commandsNames = CommandsNames.ADD;

    @Override
    public CommandsNames getCommandsNames() {
        return this.commandsNames;
    }

    public AddCommand(CarsDataBase carsDataBase) {
        this.carsDataBase = carsDataBase;
    }

    @Override
    public void execute(String carValues) {
        carsDataBase.add(new Car(StringValidation.validation(carValues)));
    }
}
