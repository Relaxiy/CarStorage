package Commands;

import Exceptions.CloseException;
import DataBase.CarsDataBase;
import Enums.CommandsNames;

public class CloseCommand implements Command {
    private CarsDataBase carsDataBase;
    private final CommandsNames commandsNames = CommandsNames.CLOSE;

    @Override
    public CommandsNames getCommandsNames() {
        return this.commandsNames;
    }

    public CloseCommand(CarsDataBase carsDataBase) {
        this.carsDataBase = carsDataBase;
    }

    @Override
    public void execute(String carValues) throws CloseException {
        carsDataBase.close();
    }
}
