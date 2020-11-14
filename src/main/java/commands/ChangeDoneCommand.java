package commands;

import exceptions.DukeException;
import storage.Storage;
import ui.Ui;
import tasks.*;


/**
 * This represents the done command. It is used to change the task from the task list to its
 * done "state".
 */

public class ChangeDoneCommand extends Command{
    private int option = 0;
    private boolean isDone;

    /**
     * This is the constructor of the DoneCommand.
     * @param option indicates the Task option that the user wants to change
     *
     */
    public ChangeDoneCommand(int option, boolean isDone){
        this.option = option;
        this.isDone = isDone;
    }

    /**
     * This executes the DoneCommand.
     * @param tasks This is the Task List that contains the list of tasks.
     * @param ui This is the ui, to be used for scanning and printing
     * @param storage This is the storage, used to read and write over the file.
     * @throws DukeException when option is not within the range of 1 and TaskList Size
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if(option <= tasks.getSize() && option >= 1){
            tasks.get(option - 1).changeDoneTo(isDone);
            System.out.println(System.lineSeparator() + "Nice! I've marked this task as done:" + System.lineSeparator() + tasks.get(option - 1).toString());

        }else{
            throw new DukeException("Option for Done Command invalid");
        }
        return;
    }

    public static void printHelp(){
        System.out.println("Changing a task to done: done [option number]");
        System.out.println("Changing a task to undone: undone [option number]");
    }
}