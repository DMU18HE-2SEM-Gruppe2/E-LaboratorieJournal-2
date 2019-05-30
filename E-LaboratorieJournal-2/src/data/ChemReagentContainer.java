package data;

import java.util.ArrayList;
import java.util.List;

import logic.ChemReagentForm;

public class ChemReagentContainer {
	// Bio Reagent Form container
	List<ChemReagentForm> list = new ArrayList<ChemReagentForm>();

	// Add a Chem Reagent Form to the list
	public void addElement(ChemReagentForm chemReagentForm) {
		list.add(chemReagentForm);
	}

	// Delete a Chem Reagent Form from the list
	public void deleteElement(ChemReagentForm chemReagentFormToDelete) {
		list.remove(chemReagentFormToDelete);
	}

	// Get a specific Chem Reagent Form from the list
	public ChemReagentForm getElement(int index) {
		return list.get(index);
	}

	// Get the size of the list
	public int getSize() {
		return list.size();
	}
}
