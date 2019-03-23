package com.example.springbootboilerplate.entity;

import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.Version;

/**
 * 従業員
 */
@Entity(listener = EmployeesListener.class)
@Table(name = "employees")
public class Employees {

    /** 従業員ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    Long employeeId;

    /** 従業員名 */
    @Column(name = "employee_name")
    String employeeName;

    /** バージョン */
    @Version
    @Column(name = "version")
    Long version;

    /** データ作成日時 */
    @Column(name = "created_at")
    LocalDateTime createdAt;

    /** データ作成者 */
    @Column(name = "created_user")
    Long createdUser;

    /** データ更新日時 */
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    /** データ更新者 */
    @Column(name = "updated_user")
    Long updatedUser;

    /** 
     * Returns the employeeId.
     * 
     * @return the employeeId
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /** 
     * Sets the employeeId.
     * 
     * @param employeeId the employeeId
     */
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    /** 
     * Returns the employeeName.
     * 
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /** 
     * Sets the employeeName.
     * 
     * @param employeeName the employeeName
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /** 
     * Returns the version.
     * 
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /** 
     * Sets the version.
     * 
     * @param version the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /** 
     * Returns the createdAt.
     * 
     * @return the createdAt
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /** 
     * Sets the createdAt.
     * 
     * @param createdAt the createdAt
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /** 
     * Returns the createdUser.
     * 
     * @return the createdUser
     */
    public Long getCreatedUser() {
        return createdUser;
    }

    /** 
     * Sets the createdUser.
     * 
     * @param createdUser the createdUser
     */
    public void setCreatedUser(Long createdUser) {
        this.createdUser = createdUser;
    }

    /** 
     * Returns the updatedAt.
     * 
     * @return the updatedAt
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /** 
     * Sets the updatedAt.
     * 
     * @param updatedAt the updatedAt
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /** 
     * Returns the updatedUser.
     * 
     * @return the updatedUser
     */
    public Long getUpdatedUser() {
        return updatedUser;
    }

    /** 
     * Sets the updatedUser.
     * 
     * @param updatedUser the updatedUser
     */
    public void setUpdatedUser(Long updatedUser) {
        this.updatedUser = updatedUser;
    }
}