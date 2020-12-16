package com.nora.employee.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DataBaseTest {
    DataBase db = new DataBase();

    @Test
    void constructorShouldWork(){
        assertEquals(30, db.getDb().size());
    }
    @Test
    void getDbShouldWork(){
        assertEquals(30, db.getDb().size());
    }


}
