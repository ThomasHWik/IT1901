package core;

public class NumberManager {
    public static int getDigits(int number) {
        int digits = 0;
        while (number > 0) {
            number = number / 10;
            digits++;
        }
        return digits;        
    }

    public static int getDigits(Integer number) {
        int digits = 0;
        while (number > 0) {
            number = number / 10;
            digits++;
        }
        return digits;
    }
}
