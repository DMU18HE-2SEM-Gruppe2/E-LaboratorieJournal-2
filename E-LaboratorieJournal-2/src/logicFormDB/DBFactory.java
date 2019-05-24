package logicFormDB;

public class DBFactory {
	public InterfaceDB makeInterfaceDB() {
		return new ImplDB();
	}

}
