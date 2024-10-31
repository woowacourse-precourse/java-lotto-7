package lotto.utils;

public class Converter {

    private Converter(){
    }

    public static int convertToNumber(String input) {
        return Integer.parseInt(input.trim());
    }
}
