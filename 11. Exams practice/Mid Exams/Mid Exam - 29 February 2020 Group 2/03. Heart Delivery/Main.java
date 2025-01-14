import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] houses = Arrays.stream(scanner.nextLine()
                .split("@"))
                .mapToInt(Integer::parseInt).toArray();

        int currentIndex = 0;

        String input = scanner.nextLine();
        while (!"Love!".equals(input)) {
            String[] tokens = input.split(" ");
            int jump = Integer.parseInt(tokens[1]);
            currentIndex += jump;

            if (currentIndex >= houses.length) {
                currentIndex = 0;
            }

            if (doesElementEqualToZero(houses[currentIndex])) {
                System.out.printf("Place %d already had Valentine's day.\n", currentIndex);
            } else {
                houses[currentIndex] -= 2;
                if (doesElementEqualToZero(houses[currentIndex])) {
                    System.out.printf("Place %d has Valentine's day.\n", currentIndex);
                }
            }
            input = scanner.nextLine();
        }

        if (allElementsEqualToZero(houses)) {
            System.out.println("Mission was successful.");
        } else {
            printResult(houses,currentIndex);
        }
    }

    private static void printResult(int[] houses, int index) {
        long count = Arrays.stream(houses).filter(h -> h != 0).count();
        System.out.printf("Cupid's last position was %d.\n", index);
        System.out.printf("Cupid has failed %d places.\n", count);
    }

    private static boolean allElementsEqualToZero(int[] houses) {
        return Arrays.stream(houses).sum() == 0;
    }

    private static boolean doesElementEqualToZero(int house) {
        return house == 0;
    }
}




