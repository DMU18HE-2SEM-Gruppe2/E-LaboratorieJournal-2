package data;

import java.util.ArrayList;
import java.util.List;

import logic.BioReagentForm;

public class BioReagentContainer {

	// Bio Reagent Form container
	List<BioReagentForm> list = new ArrayList<BioReagentForm>();

	// Add a Bio Reagent Form to the list
	public void addElement(BioReagentForm bioReagentForm) {
		list.add(bioReagentForm);
	}
	
	// Delete a Bio Reagent Form from the list
	public void deleteElement(BioReagentForm bioReagentFormToDelete) {
		list.remove(bioReagentFormToDelete);
	}
	
	// Get a specific Bio Reagent Form from the list
	public BioReagentForm getElement(int index) {
		return list.get(index);
	}
	
	// Get the size of the list
	public int getSize() {
		return list.size();
	}

}
