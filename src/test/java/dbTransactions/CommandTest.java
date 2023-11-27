package dbTransactions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {


    @Test
    void deveExecutarInsert() {
        Database.reset();
        Database db = Database.getInstance();
        Command insert = new Insert(db, "001", "Teste");
        TransactionManager tm = new TransactionManager();
        tm.addCommand(insert);
        tm.execute();

        assertEquals(db.select("001"), "Teste");
    }

    @Test
    void deveExecutarDelete() {
        Database.reset();
        Database db = Database.getInstance();
        TransactionManager tm = new TransactionManager();

        Command insert = new Insert(db, "001", "Teste");
        Command delete = new Delete(db, "001");

        tm.addCommand(insert);
        tm.addCommand(delete);
        tm.execute();

        assertEquals(db.select("001"), null);
    }

    @Test
    void deveExecutarComandosInsert() {
        Database.reset();
        Database db = Database.getInstance();
        TransactionManager tm = new TransactionManager();

        tm.addCommand(new Insert(db, "001", "Teste"));
        tm.addCommand(new Insert(db, "002", "Teste2"));
        tm.addCommand(new Insert(db, "003", "Teste3"));
        tm.execute();

        assertEquals(db.getAllData(), "{001=Teste, 002=Teste2, 003=Teste3}");
    }

    @Test
    void deveExecutarComandosDelete() {
        Database.reset();
        Database db = Database.getInstance();
        TransactionManager tm = new TransactionManager();

        tm.addCommand(new Insert(db, "001", "Teste"));
        tm.addCommand(new Insert(db, "002", "Teste2"));
        tm.addCommand(new Insert(db, "003", "Teste3"));
        tm.addCommand(new Delete(db, "001"));
        tm.addCommand(new Delete(db, "002"));
        tm.execute();

        assertEquals(db.getAllData(), "{003=Teste3}");
    }


}