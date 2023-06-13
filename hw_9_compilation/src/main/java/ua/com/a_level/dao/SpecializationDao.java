package ua.com.a_level.dao;

import ua.com.a_level.dto.SpecializationDto;
import ua.com.a_level.entity.Specialization;

import java.util.Collection;

public interface SpecializationDao extends BaseDao<Specialization> {

    void attachEmployeeToSpecialization(Long specializationId, Long employeId);

    void detachEmployeeFromSpecialization(Long specializationId, Long employeId);

    Collection<SpecializationDto> findSpecializationStatistics();
}
