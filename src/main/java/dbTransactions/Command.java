package dbTransactions;

import java.util.Arrays;
import java.util.List;

public abstract class Command {
    protected Database database;
    List<String> params;

    public Command(Database db, String ... params){
        this.database = db;
        this.params = Arrays.asList(params);
    }

    public abstract void execute();
    public abstract void undo();

}
