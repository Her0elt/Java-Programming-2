package Øving_del_2;

import java.time.LocalDate;
import java.util.logging.Level;

public class Klient {
    public static void main(String[] args) {
        try {
            ScandinavianWildAnimal ulla = WildAnimalFactory.newFemaleWolf("Ulla",
                    LocalDate.of(2015, 2, 26), LocalDate.of(2015, 4, 29), "Innhegning 2");

            System.out.println(ulla.printInfo());

        }catch (Exception e){
            ZooLogger.getLogger().log(Level.FINE, e.getMessage());
            ZooLogger.closeHandler();
        }

    }
}
