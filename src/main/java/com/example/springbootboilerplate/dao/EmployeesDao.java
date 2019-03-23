package com.example.springbootboilerplate.dao;

import com.example.springbootboilerplate.entity.Employees;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao
public interface EmployeesDao {

    /**
     * @param employeeId
     * @return the Employees entity
     */
    @Select
    Employees selectById(Long employeeId);

    /**
     * @param employeeId
     * @param version
     * @return the Employees entity
     */
    @Select(ensureResult = true)
    Employees selectByIdAndVersion(Long employeeId, Long version);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Employees entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Employees entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Employees entity);
}