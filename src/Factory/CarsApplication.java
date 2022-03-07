package Factory;

import Exceptions.CloseException;

public class CarsApplication {

    public static void main(String[] args) {

        CarsDealer carsDealer = new CarsDealer();
        boolean workProgram = true;
        while (workProgram) {
            try {
                carsDealer.pushCommand();
            } catch (IllegalArgumentException e) {
                System.out.println("Not valid!");
            } catch (CloseException e) {
                System.out.println(e.getMessage());
                workProgram = false;
            }
        }
    }
}
