package com.test.db2;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.jsql.exception.PreparationException;
import com.jsql.exception.StoppableException;
import com.jsql.model.injection.InjectionModel;
import com.jsql.model.injection.MediatorModel;
import com.jsql.view.junit.SystemOutTerminal;

public class DB2BlindGetTestSuite extends ConcreteDB2TestSuite {

    @BeforeClass
    public static void initialize() throws PreparationException {
        InjectionModel model = new InjectionModel();
        MediatorModel.register(model);
        model.instanciationDone();
        new SystemOutTerminal();

        MediatorModel.model().initialUrl = "http://127.0.0.1/db2_simulate_get.php";
        MediatorModel.model().getData = "?lib=1";
        MediatorModel.model().method = "GET";

        MediatorModel.model().inputValidation();

        MediatorModel.model().injectionStrategy = MediatorModel.model().blindStrategy;
    }
    
    @Override
    @Test
    @Ignore
    public void listDatabases() throws PreparationException, StoppableException {
        // Empty on purpose
    }
    
    @Override
    @Test
    @Ignore
    public void listTables() throws PreparationException, StoppableException {
        // Empty on purpose
    }
}
