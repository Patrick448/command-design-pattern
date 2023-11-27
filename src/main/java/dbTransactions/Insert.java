package dbTransactions;

import java.util.List;

public class Insert extends Command{

    public Insert(Database db,  String... params) {
        super(db, params);
    }

    @Override
    public void execute() {
        database.insert(params.get(0), params.get(1));
    }

    @Override
    public void undo() {

    }
}
