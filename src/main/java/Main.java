import interfaces.RoofController;
import interfaces.SpeedSensor;
import service.ComputerController;

public class Main {
    public static void main(String[] args) {


        ComputerController computerController = new ComputerController(new RoofController() {
            @Override
            public void open() {

            }

            @Override
            public void close() {

            }
        }, new SpeedSensor() {
            @Override
            public double getSpeed() {
                return 0;
            }
        });
    }


    // a takie cos na gorze czyli tworzenie obiektow? bez obiektu to klasa anonimowa

}
