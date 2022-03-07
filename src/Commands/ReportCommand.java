package Commands;

import DataBase.CarsDataBase;
import Enums.CommandsNames;
import Factory.StringValidation;

public class ReportCommand implements Command {
    private CarsDataBase carsDataBase;
    private final CommandsNames commandsNames = CommandsNames.REPORT;

    @Override
    public CommandsNames getCommandsNames() {
        return this.commandsNames;
    }

    public ReportCommand(CarsDataBase carsDataBase) {
        this.carsDataBase = carsDataBase;
    }

    @Override
    public void execute(String carValues) {
        carsDataBase.report(StringValidation.validationLong(carValues));
    }
}
