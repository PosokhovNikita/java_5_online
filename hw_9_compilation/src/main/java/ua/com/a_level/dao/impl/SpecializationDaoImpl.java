package ua.com.a_level.dao.impl;

import ua.com.a_level.dao.SpecializationDao;
import ua.com.a_level.dto.SpecializationDto;
import ua.com.a_level.entity.Specialization;
import ua.com.a_level.jdbc.Jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpecializationDaoImpl implements SpecializationDao {

    private final Connection connection = Jdbc.getCopy().getConnection();
    private final Statement statement = Jdbc.getCopy().getStatement();

    private static final String CREATE_SPECIALIZATION = "insert into specialization values (default, ?)";
    private static final String UPDATE_SPECIALIZATION = "update specialization set name = ? where id = ?";
    private static final String DELETE_SPECIALIZATION = "delete from specialization where id = ?";
    private static final String FIND_SPECIALIZATION_BY_ID = "select * from specialization where id = ?";
    private static final String FIND_ALL_SPECIALIZATION = "select * from specialization";
    private static final String ATTACH_EMPLOYEE_TO_SPECIALIZATION = "insert into specialization_employee values (?, ?)";
    private static final String DETACH_EMPLOYEE_TO_SPECIALIZATION = "delete from specialization_employee where specialization_id = ? and employee_id = ?";
    private static final String FIND_ALL_SPECIALIZATION_STATISTICS = "SELECT e.id, e.name, COUNT(se.employee_id) AS employee_count " +
            "FROM specialization AS e " +
            "JOIN specialization_employee AS se ON e.id = se.specialization_id " +
            "GROUP BY e.id, e.name " +
            "ORDER BY employee_count DESC";

    @Override
    public void create(Specialization specialization) {
        try (PreparedStatement ps = connection.prepareStatement(CREATE_SPECIALIZATION)) {
            ps.setString(1, specialization.getTitle());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
    }

    @Override
    public void update(Specialization specialization) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_SPECIALIZATION)) {
            ps.setString(1, specialization.getTitle());
            ps.setLong(2, specialization.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_SPECIALIZATION)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
    }

    @Override
    public Specialization findById(Long id) {
        try (PreparedStatement ps = connection.prepareStatement(FIND_SPECIALIZATION_BY_ID)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return convertResultSetToSpecialization(rs);
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Specialization> findAll() {
        List<Specialization> specializations = new ArrayList<>();
        try (ResultSet rs = statement.executeQuery(FIND_ALL_SPECIALIZATION)) {
            while (rs.next()) {
                specializations.add(convertResultSetToSpecialization(rs));
            }
            return specializations;
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
        return specializations;
    }

    @Override
    public void attachEmployeeToSpecialization(Long specializationId, Long employeId) {
        try (PreparedStatement ps = connection.prepareStatement(ATTACH_EMPLOYEE_TO_SPECIALIZATION)) {
            ps.setLong(1, specializationId);
            ps.setLong(2, employeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
    }

    @Override
    public void detachEmployeeFromSpecialization(Long specializationId, Long employeId) {
        try (PreparedStatement ps = connection.prepareStatement(DETACH_EMPLOYEE_TO_SPECIALIZATION)) {
            ps.setLong(1, specializationId);
            ps.setLong(2, employeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
    }

    @Override
    public Collection<SpecializationDto> findSpecializationStatistics() {
        List<SpecializationDto> specializationDto = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery(FIND_ALL_SPECIALIZATION_STATISTICS)) {
            while (resultSet.next()) {
                specializationDto.add(convertResultSetToElectivesDto(resultSet));
            }
            return specializationDto;
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
        return specializationDto;
    }

    private Specialization convertResultSetToSpecialization(ResultSet rs) throws SQLException {
        Specialization specializations = new Specialization();
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        specializations.setId(id);
        specializations.setTitle(name);
        return specializations;
    }

    private SpecializationDto convertResultSetToElectivesDto(ResultSet rs) throws SQLException {
        SpecializationDto specializationDto = new SpecializationDto();
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        Long count = rs.getLong("employee_count");
        specializationDto.setId(id);
        specializationDto.setName(name);
        specializationDto.setCountEmployee(count);
        return specializationDto;
    }
}
