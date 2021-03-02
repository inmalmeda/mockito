package com.example.service.bdd.bdd;


import com.example.dao.UserDAO;
import com.example.domain.User;
import com.example.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * BDD : Behaviur Driven Development
 *
 * Cucumber Framewoek
 * Sintaxis
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    //mocks
    @Mock
    UserDAO userDAO;

    //SUT
    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("BDD Style")
    public void bddStyle() {

        Instant accessDate = Instant.now();

        //Given
        given(userDAO.findOne(anyLong())).willReturn(
                new User(1L, "Joaquin",accessDate)
        );


        //When
        User user = userService.findOne(1L);

        //Then
        then(userDAO).should().findOne(anyLong());
        assertNotEquals(accessDate,user.getAccessDate());

        
    }

}
