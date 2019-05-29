package logicFormDB;

import java.util.List;

import data.DBConnection;
import data.DBOthers;
import logic.BioReagentForm;
import logic.BioSubstrateForm;
import logic.ChemReagentForm;
import logic.Course;
import logic.FormPresentation;
import logic.Journal;
import logic.JournalPresentation;
import logic.Student;

public class ImplDB implements DBInterface {

	DBConnection connection = new DBConnection();

	MutualDB mDB = new MutualDB();
	DBOthers oDB = new DBOthers();
	ChemReagentDB crDB = new ChemReagentDB();
	BioReagentDB brDB = new BioReagentDB();
	BioSubstrateDB bsDB = new BioSubstrateDB();
	JournalDB jDB = new JournalDB();

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

	@Override
	public int getStudentById(int id) {
		return oDB.getStudentById(id);
	}

	// Course
	@Override
	public boolean addCourse(Course course) {
		return oDB.addCourse(course);
	}

	@Override
	public List<Course> getCoursesWhere(String whereClause) {

		return oDB.getCoursesWhere(whereClause);
	}

	@Override
	public List<Course> getAllCourses() {
		return oDB.getAllCourses();
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
	
	@Override
	public boolean deleteChemReagentForm(String whereClause, ChemReagentForm chemReagentForm) {
		return crDB.deleteChemReagentForm(whereClause, chemReagentForm);
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

	// Journal

	@Override
	public boolean addAnalyzeInfo(Journal journal) {
		return jDB.addAnalyzeInfo(journal);
	}

	@Override
	public boolean addJournal(Journal journal) {
		return jDB.addJournal(journal);
	}

	@Override
	public boolean addStudentForm(Student student, Journal journal) {
		return jDB.addStudentForm(student, journal);
	}

	@Override
	public boolean addJournalForm(int whereClause) {
		return jDB.addJournalForm(whereClause);
	}

	@Override
	public List<JournalPresentation> getAllJournalsWhereToPresentation(String whereClause) {
		return jDB.getAllJournalsWhereToPresentation(whereClause);
	}

	@Override
	public List<JournalPresentation> getAllJournalsToPresentation() {
		return jDB.getAllJournalsToPresentation();
	}

	// Read all forms and add to list
	@Override
	public List<FormPresentation> getAllFormsWhere(String whereClause) {
		return mDB.getAllProductsWhereToPresentation(whereClause);
	}

	@Override
	public List<FormPresentation> getAllForms() {
		return mDB.getAllProductsToPresentation();
	}

	@Override
	public int getFormIDByID(int id) {
		return mDB.getFormIDByID(id);
	}

	@Override
	public int getAnalyzeIDByID(int id) {
		return mDB.getAnalyzeIDByID(id);
	}

	@Override
	public List<FormPresentation> getAllFormsWhereToPresentation(String whereClause) {
		return mDB.getAllProductsWhereToPresentation(whereClause);
	}

	@Override
	public List<FormPresentation> getAllFormsToPresentation() {
		return mDB.getAllProductsToPresentation();
	}

}
