package Commands;

import DataBase.CarsDataBase;
import Enums.CommandsNames;


public class ListCommand implements Command {
    private CarsDataBase carsDataBase;
    private final CommandsNames commandsNames = CommandsNames.LIST;

    @Override
    public CommandsNames getCommandsNames() {
        return this.commandsNames;
    }

    public ListCommand(CarsDataBase carsDataBase) {
        this.carsDataBase = carsDataBase;
    }

    @Override
    public void execute(String carValues) {
        carsDataBase.list();
    }

}
