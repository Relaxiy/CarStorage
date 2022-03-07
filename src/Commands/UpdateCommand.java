package Commands;

import Factory.Car;
import DataBase.CarsDataBase;
import Enums.CommandsNames;
import Factory.StringValidation;


public class UpdateCommand implements Command {
    private CarsDataBase carsDataBase;
    private final CommandsNames commandsNames = CommandsNames.UPDATE;

    @Override
    public CommandsNames getCommandsNames() {
        return this.commandsNames;
    }

    public UpdateCommand(CarsDataBase carsDataBase) {
        this.carsDataBase = carsDataBase;
    }

    @Override
    public void execute(String carValues) {
        carsDataBase.update(new Car(StringValidation.validation(carValues)));
    }
}
