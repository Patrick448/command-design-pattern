package dbTransactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<Command> commands = new ArrayList<Command>();
    private String result;

    public TransactionManager() {
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
