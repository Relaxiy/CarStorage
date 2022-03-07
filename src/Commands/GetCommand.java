package Commands;

import DataBase.CarsDataBase;
import Enums.CommandsNames;
import Factory.StringValidation;

public class GetCommand implements Command {
    private CarsDataBase carsDataBase;
    private final CommandsNames commandsNames = CommandsNames.GET;

    @Override
    public CommandsNames getCommandsNames() {
        return this.commandsNames;
    }

    public GetCommand(CarsDataBase carsDataBase) {
        this.carsDataBase = carsDataBase;
    }

    @Override
    public void execute(String carValues) {
        carsDataBase.get(StringValidation.validationLong(carValues));
    }
}
