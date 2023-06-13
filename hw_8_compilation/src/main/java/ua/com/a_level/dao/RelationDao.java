package ua.com.a_level.dao;

import org.json.simple.parser.ParseException;
import ua.com.a_level.entity.Employee;
import ua.com.a_level.entity.Relation;
import ua.com.a_level.entity.Specialization;

import java.io.IOException;
import java.util.ArrayList;

public interface RelationDao {

    void readRelation() throws IOException, ParseException;

    ArrayList<Specialization> findAllSpecializationByEmployee(String id);

    ArrayList<Employee> findAllEmployeeBySpecialization(String id);

    ArrayList<Relation> getRelations();

    void deleteRelationEmployee(String id);

    void deleteRelationSpecialization(String id);

    void addEmployeeToSpecialization(String employeeId, String specializationId) throws IOException;


}
