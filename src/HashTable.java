import java.util.HashMap;
import java.util.LinkedList;

public class HashTable {

    private class Entry {

        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries;

    public HashTable(int size) {
        this.entries = new LinkedList[size];
    }

    public void put(int key, String value) {
        var entry = getEntry(key);

        if (entry != null) {
            entry.value = value;
            return;
        }

        var index = hash(key);
        if (entries[index] == null) {
            entries[index] = new LinkedList<>();
        }

        entries[index].addLast(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);
        return entry != null ? entry.value : null;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null) {
            throw new IllegalArgumentException("unavailable key");
        }
        getList(key).remove(entry);
    }

    public boolean containsKey(int key) {
        return getEntry(key) != null;
    }

    public boolean containsValue(String value) {
        for (var list : entries) {
            if (list != null) {
                for (var entry : list) {
                    if (entry.value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private LinkedList<Entry> getList(int key) {
        return entries[hash(key)];
    }

    private Entry getEntry(int key) {
        var list = getList(key);
        if (list != null) {
            for (var entry : list) {
                if (entry.key == key) {
                    return entry;
                }
            }
        }
        return null;
    }


    private int hash(int key) {
        return key % entries.length;
    }

    public void print() {
        for (LinkedList<Entry> list : entries) {
            if (list != null) {
                for (Entry entry : list) {
                    System.out.println("key = " + entry.key + " value = " + entry.value);
                }
            }
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(6, "ABC");
        map.put(8, "DEF");
        map.put(11, "GHI");
        System.out.println(map);
        map.put(6, "XYZ");
        System.out.println("get 6 = " + map.get(6));
        map.remove(6);
        System.out.println(map);

        HashTable table = new HashTable(5);
        table.put(6, "ABC");
        table.put(8, "DEF");
        table.put(11, "GHI");
        table.print();
        System.out.println("Overwriting key 6");
        table.put(6, "XYZ"); //1
        table.print();
        System.out.println("get 6 = " + table.get(6));
        table.remove(6);
        System.out.println("Removing key 6");
        table.print();
        System.out.println("Contains key 6: " + table.containsKey(6));
        System.out.println("Contains value XYZ: " + table.containsValue("XYZ"));
    }

}


