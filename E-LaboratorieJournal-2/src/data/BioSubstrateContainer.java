package data;

import java.util.ArrayList;
import java.util.List;

import logic.BioSubstrateForm;

public class BioSubstrateContainer {
	// Bio Substrate Form container
	List<BioSubstrateForm> list = new ArrayList<BioSubstrateForm>();

	// Add a Bio Substrate Form to the list
	public void addElement(BioSubstrateForm bioSubstrateForm) {
		list.add(bioSubstrateForm);
	}

	// Delete a Bio Substrate Form from the list
	public void deleteElement(BioSubstrateForm bioSubstrateFormToDelete) {
		list.remove(bioSubstrateFormToDelete);
	}

	// Get a specific Bio Substrate Form from the list
	public BioSubstrateForm getElement(int index) {
		return list.get(index);
	}

	// Get the size of the list
	public int getSize() {
		return list.size();
	}
}
