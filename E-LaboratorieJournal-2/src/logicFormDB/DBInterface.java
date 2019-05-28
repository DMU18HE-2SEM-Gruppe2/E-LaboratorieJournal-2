package logicFormDB;

import java.util.List;

import data.BioReagentContainer;
import data.BioSubstrateContainer;
import data.ChemReagentContainer;
import logic.BioReagentForm;
import logic.BioSubstrateForm;
import logic.ChemReagentForm;
import logic.Course;
import logic.FormPresentation;
import logic.Journal;
import logic.Student;

public interface DBInterface {


	// All forms
	
	int getFormIDByID(int id);
	
	List<FormPresentation> getAllFormsWhereToPresentation(String whereClause);
	
	List<FormPresentation> getAllFormsToPresentation();


	// Chem Reagent
	
	public boolean createChemReagent(ChemReagentForm chemRegentForm, Student student);

	List<ChemReagentForm> getAllChemReagent();

	List<ChemReagentForm> getAllChemReagentWhere(String whereClause);


	// Bio Reagent
	
	public boolean createBioReagent(BioReagentForm bioReagentForm, Student student);

	List<BioReagentForm> getAllBioReagentWhere(String whereClause);

	List<BioReagentForm> getAllBioReagent();

	// Bio Substrate
	
	public boolean createBioSubstrate(BioSubstrateForm bioSubstrateForm, Student student);

	List<BioSubstrateForm> getAllBioSubstrateWhere(String whereClause);

	List<BioSubstrateForm> getAllBioSubstrate();

	// All forms to presentation
	
	public List<FormPresentation> getAllFormsWhere(String whereClause);

	public List<FormPresentation> getAllForms();

	// School (Student & Course)
	
	int getStudentById(int id);

	List<Course> getCoursesWhere(String whereClause);

	List<Course> getAllCourses();

	public boolean addStudent(Student student, Course course);
	
	public List<Student> getAllStudents();
	
	public List<Student> getStudentsWhere(String whereClause);
	
	public boolean addCourse(Course course);

	// Journal
	
	boolean addJournal(Journal journal);

	boolean addJournalForm(Journal journal, Student student);

	boolean addAnalyzeInfo(Journal journal);

	int getAnalyzeIDByID(int id);




}
