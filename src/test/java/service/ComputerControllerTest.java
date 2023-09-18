package service;

import interfaces.RoofController;
import interfaces.SpeedSensor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ComputerControllerTest {

    private ComputerController computerController;
    @Mock
    private SpeedSensor speedSensorMock;
    @Mock
    private RoofController roofControllerMock;


    @Before
    public void init() {

        // tworzymy sobie mocki
        MockitoAnnotations.openMocks(this);
        computerController = new ComputerController(roofControllerMock, speedSensorMock);


    }


    @Test
    public void shouldOpenRoofWhenSpeedIs30() {

        // "uczymy" program gdy na obiekcie speedSensorMock zostanie wywolana metoda getSpeed
        // to ma zwrocic wartosc 30.0
        Mockito.when(speedSensorMock.getSpeed()).thenReturn(30.0);

        // wywolujemy ta metode w ktorej jest zawarta metoda getSpeed
        computerController.openRoof();

        // tutaj weryfikujemy czy na obiekcie roofControlMock zostanie wywolana metoda open
        Mockito.verify(roofControllerMock).open();
    }

    @Test
    public void shouldCloseRoofWhenSpeedIs30() {
        Mockito.when(speedSensorMock.getSpeed()).thenReturn(30.0);
        computerController.closeRoof();
        Mockito.verify(roofControllerMock).close();
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalExceptionWhenCloseRoofWithSpeed31() {
        Mockito.when(speedSensorMock.getSpeed()).thenReturn(31.0);
        computerController.closeRoof();

        // tutaj nie trzeba juz dodawac zadnego veryfiy itd. bo w metodzie closeRoof jest ustawione
        // jezeli wartosc bedzie wieksza niz 30 to rzuci wyjatkiem
    }


}