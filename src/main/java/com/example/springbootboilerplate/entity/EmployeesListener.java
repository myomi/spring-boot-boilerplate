package com.example.springbootboilerplate.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class EmployeesListener implements EntityListener<Employees> {

    @Override
    public void preInsert(Employees entity, PreInsertContext<Employees> context) {
    }

    @Override
    public void preUpdate(Employees entity, PreUpdateContext<Employees> context) {
    }

    @Override
    public void preDelete(Employees entity, PreDeleteContext<Employees> context) {
    }

    @Override
    public void postInsert(Employees entity, PostInsertContext<Employees> context) {
    }

    @Override
    public void postUpdate(Employees entity, PostUpdateContext<Employees> context) {
    }

    @Override
    public void postDelete(Employees entity, PostDeleteContext<Employees> context) {
    }
}