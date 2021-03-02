package com.example.service;

import com.example.dao.UserDAO;
import com.example.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserDAO userDAO; //dependencia

    @InjectMocks
    UserService userService; //SUT System under test(Dependiente) Clase que necesita una/s dependencias para funcionar


    @Test
    void findAll(){

        //1-Configurar mocks
       when(userDAO.findAll()).thenReturn(
               Arrays.asList(
                       new User(1L,"Alan"),
                       new User(2L,"Pepe"),
                       new User(3L,"Inma")
               )
       );

       //2-Probar el SUT
       List<User> users=  userService.recuperateUsers(); //Esto devuelve lo que hemos puesto en el paso 1, y no lo que haya en userDAO

       // 3-Verificar datos y mock
        assertEquals(3 , users.size()); //Se compara lo que se quiera
        assertEquals("Inma" , users.get(2).getName()); //Se compara lo que se quiera
        verify(userDAO, times(1)).findAll(); //Verificar que se hacen las veces que quiero
        
    }

    @Test
    @DisplayName("findOne Test")
    public void findOneTest() {

        //Configurar mock
        when(userDAO.findOne(anyLong())).thenReturn(            //anylong: para aceptar cualqier long
          new User(1L, "Mike")
        );

        //Probar el SUT
        User user = userService.findOne(1L);

        //Verifica datos y mock
        verify(userDAO, times(1)).findOne(user.getId());

    }



}