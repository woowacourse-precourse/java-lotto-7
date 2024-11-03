package util;

public class Validator {
    public static boolean isNumber(char number) {
        if ('0' <= number && number <= '9') {
            return true;
        }
        return false;
    }
}
