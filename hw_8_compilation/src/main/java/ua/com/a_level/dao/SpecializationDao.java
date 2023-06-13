package ua.com.a_level.dao;

import org.json.simple.parser.ParseException;
import ua.com.a_level.entity.Specialization;

import java.io.IOException;
import java.util.ArrayList;

public interface SpecializationDao {

    void readSpecialization() throws IOException, ParseException;

    void createSpecialization(Specialization specialization) throws IOException;

    void updateSpecialization(int index, Specialization specialization);

    void deleteSpecialization(int index);

    Specialization findSpecializationById(String id);

    ArrayList<Specialization> findAllSpecialization();

}
