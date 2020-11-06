package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * This represents a Deadline Task. It has a LocalDateTime by object.
 * The "by" object will represent the time which the Deadline is supposed to finish.
 */

public class Deadline extends Task {
    private LocalDateTime by;

    /**
     * This is a constructor for the Deadline class
     * @param description This describe the task for the deadline
     * @param by This represents the date and time of the deadline
     */
    public Deadline(String description, String by) {
        super(description);
        try{
            this.by = LocalDateTime.parse(by);
        }catch(DateTimeParseException e){
            this.by = LocalDateTime.now();
            System.out.println("Invalid Date Time set for /by. It will be set to the current time");
        }

    }

    /**
     * This is an accessor of the "by" object which represents the date and time of the dateline
     * @return the dateline of the task
     */
    public String getBy(){
        return this.by.format(DateTimeFormatter.ofPattern("d MMM yyyy H:m:s"));
    }


    /**
     * This converts the Deadline to a String object for printing.
     * @return the deadline written as a String
     */
    public String toString(){
        return "[D]" + super.toString() + " (by: " + this.getBy() + ")";
    }
}