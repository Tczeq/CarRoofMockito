package service;

import interfaces.RoofController;
import interfaces.SpeedSensor;

public class ComputerController {

    // nie implementujemy interfejsow a dodajemy jako pola
    // to nazywa sie wstrzykiwanie chyba zaleznosci
    private RoofController roofController;
    private SpeedSensor speedSensor;

    public ComputerController(RoofController roofController, SpeedSensor speedSensor) {
        this.roofController = roofController;
        this.speedSensor = speedSensor;
    }


    public void openRoof() {
        double speed = speedSensor.getSpeed();
        if (speed <= 30.0) {
            roofController.open();
        } else {
            System.out.println("too fast");
        }
    }

    public void closeRoof() {
        double speed = speedSensor.getSpeed();

        if (speed <= 30.0) {
            roofController.close();
        } else {
            throw new IllegalArgumentException("tooo fast");
        }
    }

}
