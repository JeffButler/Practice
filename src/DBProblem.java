import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * @author Jeff
 * 
 *         DBProblem has a persistent db called persistentDB and a
 *         transactionLog to control nested transactions.
 * 
 *         To help with memory, there's only one persistent state of the db
 *         while each transaction state will be a shallow copy of either the
 *         persistent db or the top of the transactionLog.
 * 
 *         Since there was a requirement that the DB have a value lookup of
 *         O(logn) there was a separate hashMap indexed off of values kept for
 *         fast lookup.
 */
public class DBProblem {
	public static void main(String[] args) throws IOException {
		DBProblem m = new DBProblem();
		m.start();
	}

	private transactionLogState persistentDB;
	private LinkedList<transactionLogState> transactionLog;

	/**
	 * Reads the input from the user and delegates the proper 
	 * response based off of the command
	 */
	public void start() throws IOException {
		Scanner in = new Scanner(System.in);
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		persistentDB = new transactionLogState(new HashMap<Object, Object>(),
				new HashMap<String, Integer>());
		transactionLog = new LinkedList<transactionLogState>();
		String line;
		while (!(line = (br.readLine())).equals("END")) {
			String[] arguments = line.split(" ");
			switch (arguments[0]) {
			case "SET":
				set(arguments[1], arguments[2]);
				break;
			case "GET":
				get(arguments[1]);
				break;
			case "UNSET":
				unset(arguments[1]);
				break;
			case "NUMEQUALTO":
				numequalto(arguments[1]);
				break;
			case "ROLLBACK":
				rollback();
				break;
			case "BEGIN":
				begin();
				break;
			case "COMMIT":
				commit();
				break;
			}
		}
	}

	public void set(String key, String value) {
		transactionLogState db;
		if (transactionLog.peek() != null)
			db = transactionLog.peek();
		else
			db = persistentDB;
		if (db.getDB().get(key) != null)
			decrementFastValueLookUp(db.getLookUp(), db.getDB().get(key) + "");

		db.getDB().put(key, value);

		incrementFastValueLookUp(db.getLookUp(), value);

		System.out.println("");
	}

	public void decrementFastValueLookUp(HashMap<String, Integer> lookup,
			String value) {
		lookup.put(value, lookup.get(value) - 1);
	}

	public void incrementFastValueLookUp(HashMap<String, Integer> lookup,
			String value) {
		if (lookup.get(value) != null)
			lookup.put(value, lookup.get(value) + 1);
		else
			lookup.put(value, 1);
	}

	public void get(String key) {
		transactionLogState db;
		if (transactionLog.peek() != null)
			db = transactionLog.peek();
		else
			db = persistentDB;
		if (db.getDB().get(key) == null)
			System.out.println("NULL");
		else
			System.out.println(db.getDB().get(key));
	}

	public void unset(String key) {
		transactionLogState db;
		if (transactionLog.peek() != null)
			db = transactionLog.peek();
		else
			db = persistentDB;
		decrementFastValueLookUp(db.getLookUp(), "" + db.getDB().get(key));
		db.getDB().put(key, null);
		System.out.println("");
	}

	public void numequalto(String key) {
		transactionLogState it;
		if (transactionLog.peek() != null)
			it = transactionLog.peek();
		else
			it = persistentDB;

		int returnValue = 0;
		if (it.getLookUp().get(key) != null)
			returnValue = it.getLookUp().get(key);
		System.out.println(returnValue);

	}

	/**
	 * Adds a new state to the transactionLog that is either the most current
	 * state of the persistent db or the previous top of the transactionLog.
	 */
	public void begin() {
		transactionLogState db;
		if (transactionLog.peek() != null)
			db = transactionLog.peek();
		else
			db = persistentDB;
		transactionLogState instance = new transactionLogState(
				(HashMap<Object, Object>) db.getDB().clone(),
				(HashMap<String, Integer>) db.getLookUp().clone());
		transactionLog.push(instance);
		System.out.println("");
	}

	public void rollback() {
		if (transactionLog.peek() == null)
			System.out.println("NO TRANSACTION");
		else {
			System.out.println("");
			transactionLog.pop();
		}
	}

	/**
	 * Clears the transactionLog and sets persistent db to the latest snapshot
	 * of the db.
	 */
	public void commit() {
		if (transactionLog.peek() != null) {
			persistentDB = transactionLog.pop();
		}
		transactionLog.clear();
		System.out.println("");
	}

	/**
	 * 
	 * Created to maintain a fastLookup for values and the current state of the
	 * DB for each transaction
	 */
	private class transactionLogState {
		private HashMap<Object, Object> db;
		private HashMap<String, Integer> lookUp;

		public transactionLogState(HashMap<Object, Object> d,
				HashMap<String, Integer> l) {
			db = d;
			lookUp = l;
		}

		public HashMap<Object, Object> getDB() {
			return db;
		}

		public HashMap<String, Integer> getLookUp() {
			return lookUp;
		}

	}
}