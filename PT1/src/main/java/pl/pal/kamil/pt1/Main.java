// KAMIL PALUSZEWSKI 180194
// PLATFORMY TECHNOLOGICZNE - LABORATORIUM NR 1

package pl.pal.kamil.pt1;

import java.io.File;

public class Main {

    public static void main(String[] args) throws InterruptedException {

       // args[0] to tryb pracy. Ponizej mozliwe parametry wywolania.
        // 0 lub nosort = brak sortowania
        // 1 lub name = sort. po nazwie
        // 2 lub size = sort.
        // brak podanego parametru - brak sortowania
        // sciezka jest drugim argumentem.

        DirReader reader = new DirReader();

        if (args.length > 0) {
            String modes = args[0];

            int mode = 0;
            boolean mode_selected = false; // czy argument zostal jawnie podany w wywolaniu

            switch (modes) {
                case "nosort": case "0":
                 mode = 0;
                 mode_selected = true;
                    break;
                case "name": case "1":
                    mode = 1;
                    mode_selected = true;
                    break;
                case "size": case "2":
                    mode = 2;
                    mode_selected = true;
                    break;
                default:
                    mode = 0;
                    break;
            }

            // zabezpieczenie na wypadek, gdyby w sciezce do pliku wystapowaly spacje.
            int starting_from = mode_selected ? 1 : 0;

            int input_length = args.length;

            String path = args[starting_from];

            for (int i = starting_from+1; i < input_length; i++) {
                path += " " + args[i];
            }


            try {
                File file = new File(path);
                if (!file.exists()) {
                    throw new Exception("Invalid path specified.");
                }


                DiskElement source = reader.Reading(file.toPath(), mode);

                source.print(1);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
