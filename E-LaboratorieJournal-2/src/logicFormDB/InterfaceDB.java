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
import logic.Student;

public interface InterfaceDB {

	public boolean addStudent(Student student, Course course);

	public List<Student> getAllStudents();

	public List<Student> getStudentsWhere(String whereClause);

	public boolean addCourse(Course course);

	public boolean createChemReagent(ChemReagentForm chemRegentForm, Student student);

	List<ChemReagentForm> getAllChemReagent();

	List<ChemReagentForm> getAllChemReagentWhere(String whereClause);

	public boolean createBioReagent(BioReagentForm bioReagentForm, Student student);

	List<BioReagentForm> getAllBioReagentWhere(String whereClause);

	List<BioReagentForm> getAllBioReagent();

	public boolean createBioSubstrate(BioSubstrateForm bioSubstrateForm, Student student);

	List<BioSubstrateForm> getAllBioSubstrateWhere(String whereClause);

	List<BioSubstrateForm> getAllBioSubstrate();

	public List<FormPresentation> getAllFormsWhere(String whereClause);

	public List<FormPresentation> getAllForms();

	int getStudentById(int id);

	List<Course> getCoursesWhere(String whereClause);

	List<Course> getAllCourses();

}
