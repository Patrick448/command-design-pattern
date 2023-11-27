package dbTransactions;

import java.util.HashMap;

public class Database {
    private static Database instance = new Database();
    private HashMap<String, String> data = new HashMap<>();

    private Database() {
    }

    public static void reset() {
        instance = new Database();
    }

    public static Database getInstance() {
        return instance;
    }

    public void insert(String key, String value) {
        data.put(key, value);
    }

    public void delete(String key) {
        data.remove(key);
    }

    public String select(String key) {
        return data.get(key);
    }

    public String getAllData() {
        return data.toString();
    }

}
