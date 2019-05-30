package dataFormDB;

public class DBFactory {
	public DBInterface makeInterfaceDB() {
		return new ImplDB();
	}

}
