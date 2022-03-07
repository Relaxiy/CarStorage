package Factory;

import DataBase.CarsDataBase;
import Enums.CommandsNames;
import Controllers.CommandController;
import Exceptions.CloseException;
import java.util.Scanner;

public class CarsDealer {

    CarsDataBase carsDataBase;
    private final CommandController commandController;

    public void pushCommand() throws IllegalArgumentException, CloseException {
        CommandsNames commandsNames = setCommand();
        this.commandController.getCommand(commandsNames, setCarValues(commandsNames));
    }

    public CarsDealer() {
        this.carsDataBase = new CarsDataBase();
        this.commandController = new CommandController(carsDataBase);
    }

    public static CommandsNames setCommand()throws IllegalArgumentException{
        System.out.println("print command");
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        return CommandsNames.valueOf(command.toUpperCase());
    }

    public static String setCarValues(CommandsNames commandsNames){
        if(commandsNames.equals(CommandsNames.LIST)
                || commandsNames.equals(CommandsNames.CLOSE)){
            return null;
        }

        Scanner inputValues = new Scanner(System.in);
        System.out.println("Input car values");
        return inputValues.nextLine();
    }
}
