package com.example.service.arguments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.example.observer1.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherTest {

    //Captors
    @Captor
    ArgumentCaptor<WeatherType> weatherTypeCaptor;

    //dependencias
    @Mock
    WeatherObserver observer;

    //SUT
    @InjectMocks
    Weather weather;


    @Test
    @DisplayName("Check type weather")
    public void changeWeather() {

        weather.addObserver(observer);
        weather.changeWeather(WeatherType.SUNNY);

        //Para configurar el captor:
        ArgumentCaptor<WeatherType> argumentCaptor = ArgumentCaptor.forClass(WeatherType.class);

        verify(observer).update(argumentCaptor.capture()); //Para capturar lo que le llega al observer

        assertEquals(WeatherType.SUNNY, argumentCaptor.getValue());

    }


    @Test
    @DisplayName("Check type weather")
    public void changeWeather2() {

        //TIMES 2
        weather.addObserver(observer);
        weather.changeWeather(WeatherType.SUNNY);
        weather.changeWeather(WeatherType.SUNNY);

        //Para configurar el captor:
        ArgumentCaptor<WeatherType> argumentCaptor = ArgumentCaptor.forClass(WeatherType.class);

        verify(observer,times(2)).update(argumentCaptor.capture()); //Para capturar lo que le llega al observer

        assertEquals(WeatherType.SUNNY, argumentCaptor.getValue());

    }



    @Test
    @DisplayName("Check type weather")
    public void changeWeather3() {

        //TIMES 2
        weather.addObserver(observer);
        weather.changeWeather(WeatherType.RAINY);
        weather.changeWeather(WeatherType.SUNNY);

        //Para configurar el captor:
        ArgumentCaptor<WeatherType> argumentCaptor = ArgumentCaptor.forClass(WeatherType.class);

        verify(observer,times(2)).update(argumentCaptor.capture()); //Para capturar lo que le llega al observer

        List<WeatherType> arguments = argumentCaptor.getAllValues(); //Para obtener todos los valores que captura

        assertEquals(WeatherType.RAINY, arguments.get(0));
        assertEquals(WeatherType.SUNNY, arguments.get(1));

    }


    @Test
    @DisplayName("Check type weather")
    public void changeWeather4() {

        weather.addObserver(observer);
        weather.changeWeather(WeatherType.RAINY);

        verify(observer).update(weatherTypeCaptor.capture()); //Para capturar lo que le llega al observer
        assertEquals(WeatherType.RAINY, weatherTypeCaptor.getValue());
    }

    @Test
    @DisplayName("Change Weather 5")
    public void changeWeather5() {

        weather.addObserver(observer);
        weather.changeWeather(WeatherType.RAINY);

        verify(observer).update(argThat(weatherType -> weatherType == WeatherType.RAINY));

    }











}

