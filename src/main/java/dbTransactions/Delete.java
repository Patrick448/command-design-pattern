package dbTransactions;

import java.util.List;

public class Delete extends Command{


    public Delete(Database db, String... params) {
        super(db, params);
    }

    @Override
    public void execute() {
        database.delete(params.get(0));
    }

    @Override
    public void undo() {

    }
}
