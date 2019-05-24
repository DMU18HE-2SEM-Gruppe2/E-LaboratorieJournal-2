package logicFormDB;

import java.util.List;

import data.DBConnection;
import data.DBOthers;
import logic.BioReagentForm;
import logic.BioSubstrateForm;
import logic.ChemReagentForm;
import logic.Course;
import logic.FormPresentation;
import logic.Student;

public class ImplDB implements InterfaceDB {

	DBConnection connection = new DBConnection();

	DBOthers oDB = new DBOthers();
	ChemReagentDB crDB = new ChemReagentDB();
	BioReagentDB brDB = new BioReagentDB();
	BioSubstrateDB bsDB = new BioSubstrateDB();

	// Student
	@Override
	public boolean addStudent(Student student, Course course) {
		return oDB.addStudent(student, course);
	}

	@Override
	public List<Student> getAllStudents() {
		return oDB.getAllStudents();
	}

	@Override
	public List<Student> getStudentsWhere(String whereClause) {
		return oDB.getStudentsWhere(whereClause);
	}

	// Course
	@Override
	public boolean addCourse(Course course) {
		return oDB.addCourse(course);
	}

	// Chem Reagent Form
	@Override
	public boolean createChemReagent(ChemReagentForm chemReagentForm, Student student) {
		return crDB.addChemReagent(chemReagentForm, student);
	}

	@Override
	public List<ChemReagentForm> getAllChemReagent() {
		return crDB.getAllProducts();
	}

	@Override
	public List<ChemReagentForm> getAllChemReagentWhere(String whereClause) {
		return crDB.getAllProductsWhere(whereClause);
	}

	// Bio Reagent Form

	@Override
	public boolean createBioReagent(BioReagentForm bioReagentForm, Student student) {
		return brDB.addBioReagent(bioReagentForm, student);
	}

	@Override
	public List<BioReagentForm> getAllBioReagentWhere(String whereClause) {
		return brDB.getAllProductsWhere(whereClause);
	}

	@Override
	public List<BioReagentForm> getAllBioReagent() {
		return brDB.getAllProducts();
	}

	// Bio Substrate Form
	@Override
	public boolean createBioSubstrate(BioSubstrateForm bioSubstrateForm, Student student) {
		return bsDB.addBioSubstrate(bioSubstrateForm, student);
	}
	
	@Override
	public List<BioSubstrateForm> getAllBioSubstrate() {
		return bsDB.getAllProducts();
	}

	@Override
	public List<BioSubstrateForm> getAllBioSubstrateWhere(String whereClause) {
		return bsDB.getAllProductsWhere(whereClause);
	}

	// Read all forms and add to list
	@Override
	public List<FormPresentation> getAllFormsWhere(String whereClause) {
		return crDB.getAllProductsWhereToPresentation(whereClause);
	}

	@Override
	public List<FormPresentation> getAllForms() {
		return crDB.getAllProductsToPresentation();
	}

	



}
