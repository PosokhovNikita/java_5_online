package ua.com.a_level.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ua.com.a_level.dao.BaseEntityDao;
import ua.com.a_level.dao.EmployeeDao;
import ua.com.a_level.dao.RelationDao;
import ua.com.a_level.dao.SpecializationDao;
import ua.com.a_level.entity.Employee;
import ua.com.a_level.entity.Relation;
import ua.com.a_level.entity.Specialization;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Service implements BaseEntityDao, EmployeeDao, RelationDao, SpecializationDao {

    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Specialization> specializations = new ArrayList<>();
    private ArrayList<Relation> relations = new ArrayList<>();

    @Override
    public String generateSpecializationId() {
        String id = UUID.randomUUID().toString();
        for (Specialization specialization : specializations) {
            if (specialization != null && specialization.getId().equals(id)) {
                return generateSpecializationId();
            }
        }
        return id;
    }

    @Override
    public String generateEmployeeId() {
        String id = UUID.randomUUID().toString();
        for (Employee employee : employees) {
            if (employee != null && employee.getId().equals(id)) {
                return generateEmployeeId();
            }
        }
        return id;
    }

    @Override
    public void readEmployee() throws ParseException, IOException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("Employee.json"));
        ArrayList<Employee> employees1 = new ArrayList<>();
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            String firstName = (String) jsonObject.get("first_name");
            String lastName = (String) jsonObject.get("last_name");
            String id = (String) jsonObject.get("id");
            int age = ((Long) jsonObject.get("age")).intValue();
            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setAge(age);
            employee.setId(id);
            employees1.add(employee);
        }
        employees = employees1;
    }

    @Override
    public void createEmployee(Employee employee) throws IOException {
        employee.setId(generateEmployeeId());
        employees.add(employee);
        writerEmployee(employees);

    }

    @Override
    public void updateEmployee(int index, Employee employee) {
        employee.setId(employees.get(index).getId());
        employees.set(index, employee);
    }

    @Override
    public void deleteEmployee(int index) {
        deleteRelationEmployee(employees.get(index).getId());
        employees.remove(index);
    }

    @Override
    public Employee findEmployeeById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Employee> findAllEmployee() {
        return employees;
    }

    @Override
    public void readRelation() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("Relation.json"));
        ArrayList<Relation> relations1 = new ArrayList<>();
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            String employeeId = (String) jsonObject.get("employee_id");
            String specializationId = (String) jsonObject.get("specialization_id");
            Specialization specialization = findSpecializationById(specializationId);
            Employee employee = findEmployeeById(employeeId);
            if (specialization != null && employee != null) {
                Relation relation = new Relation(employee, specialization);
                relations1.add(relation);
            }
        }
        relations = relations1;
    }

    @Override
    public ArrayList<Specialization> findAllSpecializationByEmployee(String id) {
        ArrayList<Specialization> specializations1 = new ArrayList<Specialization>();
        for (Relation relation : relations) {
            if (relation.getEmployee().getId().equals(id)) {
                specializations1.add(relation.getSpecialization());
            }
        }
        return specializations1;
    }

    @Override
    public ArrayList<Employee> findAllEmployeeBySpecialization(String id) {
        ArrayList<Employee> employees1 = new ArrayList<>();
        for (Relation relation : relations) {
            if (relation.getSpecialization().getId().equals(id)) {
                employees1.add(relation.getEmployee());
            }
        }
        return employees1;
    }

    @Override
    public ArrayList<Relation> getRelations() {
        return relations;
    }

    @Override
    public void deleteRelationEmployee(String id) {
        int count = relations.size();
        for (int i = 0; i < count; i++) {
            if (relations.get(i).getEmployee().getId().equals(id)) {
                relations.remove(i);
                i--;
                count = relations.size();
            }
        }
    }

    @Override
    public void deleteRelationSpecialization(String id) {
        int count = relations.size();
        for (int i = 0; i < count; i++) {
            if (relations.get(i).getSpecialization().getId().equals(id)) {
                relations.remove(i);
                i--;
                count = relations.size();
            }
        }
    }

    @Override
    public void addEmployeeToSpecialization(String employeeId, String specializationId) throws IOException {
        Employee employee = findEmployeeById(employeeId);
        Specialization specialization = findSpecializationById(specializationId);
        relations.add(new Relation(employee, specialization));
        writerRelation(relations);
    }

    @Override
    public void readSpecialization() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("Specialization.json"));
        ArrayList<Specialization> specializations1 = new ArrayList<>();
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            String name = (String) jsonObject.get("name");
            String id = (String) jsonObject.get("id");
            Specialization specialization = new Specialization();
            specialization.setName(name);
            specialization.setId(id);
            specializations1.add(specialization);
        }
        specializations = specializations1;
    }

    @Override
    public void createSpecialization(Specialization specialization) throws IOException {
        specialization.setId(generateSpecializationId());
        specializations.add(specialization);
        writerSpecialization(specializations);
    }

    @Override
    public void updateSpecialization(int index, Specialization specialization) {
        specialization.setId(specializations.get(index).getId());
        specializations.set(index, specialization);
    }

    @Override
    public void deleteSpecialization(int index) {
        deleteRelationSpecialization(specializations.get(index).getId());
        specializations.remove(index);
    }

    @Override
    public Specialization findSpecializationById(String id) {
        for (Specialization specialization : specializations) {
            if (specialization.getId().equals(id)) {
                return specialization;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Specialization> findAllSpecialization() {
        return specializations;
    }

    public void writerEmployee(ArrayList<Employee> employees) throws IOException {
        JSONArray jsonArray = new JSONArray();
        for (Employee employee : employees) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("first_name", employee.getFirstName());
            jsonObject.put("last_name", employee.getLastName());
            jsonObject.put("age", employee.getAge());
            jsonObject.put("id", employee.getId());
            jsonArray.add(jsonObject);
        }
        FileWriter fileWriter = new FileWriter("Employee.json");
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    public void writerSpecialization(ArrayList <Specialization> specializations) throws IOException {
        JSONArray jsonArray = new JSONArray();
        for (Specialization specialization : specializations) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", specialization.getName());
            jsonObject.put("id", specialization.getId());
            jsonArray.add(jsonObject);
        }
        FileWriter fileWriter = new FileWriter("Specialization.json");
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }

    public void writerRelation(ArrayList <Relation> relations) throws IOException {
        JSONArray jsonArray = new JSONArray();
        for (Relation relation : relations) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("employee_id", relation.getEmployee().getId());
            jsonObject.put("specialization_id", relation.getSpecialization().getId());
            jsonArray.add(jsonObject);
        }
        FileWriter fileWriter = new FileWriter("Relation.json");
        fileWriter.write(jsonArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
}
