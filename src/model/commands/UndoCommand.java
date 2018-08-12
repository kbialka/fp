package model.commands;

class UndoCommand implements ICommand {
    @Override
    public void run() {
        CommandHistory.undo();
    }
}
