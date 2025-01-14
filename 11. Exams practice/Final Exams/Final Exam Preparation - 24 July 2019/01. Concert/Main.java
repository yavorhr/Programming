import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Band> bands = new HashMap<>();

        String input = scanner.nextLine();

        while (!"start of concert".equals(input)) {
            String[] tokens = input.split("; ");
            String command = tokens[0];
            String name = tokens[1];

            bands.putIfAbsent(name, new Band(name));
            Band band = bands.get(name);

            switch (command) {
                case "Add" -> {
                    String[] members = tokens[2].split(", ");
                    Arrays.stream(members).forEach(band::add);
                }
                case "Play" -> {
                    int minutes = Integer.parseInt(tokens[1]);
                    band.play(minutes);
                }
            }
            bands.put(name, band);
            input = scanner.nextLine();
        }

    }
}




