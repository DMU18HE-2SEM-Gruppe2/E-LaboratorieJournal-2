package dataFormDB;

import java.util.List;

import logic.BioReagentForm;
import logic.BioSubstrateForm;
import logic.ChemReagentForm;
import logic.Course;
import logic.FormPresentation;
import logic.Journal;
import logic.JournalPresentation;
import logic.Student;

public interface DBInterface {

	// All forms

	int getFormIDByID(int id);

	List<FormPresentation> getAllFormsWhereToPresentation(String whereClause);

	List<FormPresentation> getAllFormsToPresentation();

	public List<FormPresentation> getAllFormsWhere(String whereClause);

	public List<FormPresentation> getAllForms();

	// Chem Reagent

	public boolean createChemReagent(ChemReagentForm chemRegentForm, Student student);

	List<ChemReagentForm> getAllChemReagent();

	List<ChemReagentForm> getAllChemReagentWhere(String whereClause);

	boolean deleteChemReagentForm(String whereClause, ChemReagentForm chemReagentForm);

	// Bio Reagent

	public boolean createBioReagent(BioReagentForm bioReagentForm, Student student);

	List<BioReagentForm> getAllBioReagentWhere(String whereClause);

	List<BioReagentForm> getAllBioReagent();

	// Bio Substrate

	public boolean createBioSubstrate(BioSubstrateForm bioSubstrateForm, Student student);

	List<BioSubstrateForm> getAllBioSubstrateWhere(String whereClause);

	List<BioSubstrateForm> getAllBioSubstrate();

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

	boolean addAnalyzeInfo(Journal journal);

	int getAnalyzeIDByID(int id);

	boolean addStudentForm(Student student, Journal journal);

	boolean addJournalForm(int whereClause);

	List<JournalPresentation> getAllJournalsWhereToPresentation(String whereClause);

	List<JournalPresentation> getAllJournalsToPresentation();

}
