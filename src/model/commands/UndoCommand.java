package model.commands;

import java.io.IOException;

public class UndoCommand implements ICommand {
    @Override
    public void run() throws IOException {
        CommandHistory.undo();
    }
}
