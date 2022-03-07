package Commands;

import Enums.CommandsNames;
import Exceptions.CloseException;

public interface Command {
    void execute(String carValues) throws CloseException;

    CommandsNames getCommandsNames();
}
