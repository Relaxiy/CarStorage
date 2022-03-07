package Controllers;

import Commands.*;
import Enums.CommandsNames;
import Exceptions.CloseException;
import DataBase.CarsDataBase;

public class CommandController {

    private final Command[] commands;
    public void getCommand(CommandsNames commandsNames, String carValues) throws IllegalArgumentException, CloseException {
        for (Command command : commands) {
            if (command.getCommandsNames().equals(commandsNames)) {
                command.execute(carValues);
            }
        }
    }

    public CommandController(CarsDataBase carsDataBase){
        this.commands = new Command[]{
                new AddCommand(carsDataBase),
                new UpdateCommand(carsDataBase),
                new DeleteCommand(carsDataBase),
                new GetCommand(carsDataBase),
                new ListCommand(carsDataBase),
                new ReportCommand(carsDataBase),
                new CloseCommand(carsDataBase)
        };
    }
}
