package Commands;

import DataBase.CarsDataBase;
import Enums.CommandsNames;
import Factory.StringValidation;

public class DeleteCommand implements Command {
    private CarsDataBase carsDataBase;
    private final CommandsNames commandsNames = CommandsNames.DELETE;

    @Override
    public CommandsNames getCommandsNames() {
        return this.commandsNames;
    }

    public DeleteCommand(CarsDataBase carsDataBase) {
        this.carsDataBase = carsDataBase;
    }

    @Override
    public void execute(String carValues) {
        carsDataBase.delete(StringValidation.validationLong(carValues));
    }
}
