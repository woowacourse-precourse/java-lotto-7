package lotto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Utils {
    public static int parseNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(" 숫자를 입력해주세요");
        }
    }

    public static List<Integer> parseNumbers(String str) {
        validString(str);
        String[] numberString = str.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String numStr : numberString) {
            numbers.add(parseNumber(numStr.trim()));
        }
        return numbers;
    }

    public static String numberFomatting(int num) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.getDefault());
        return numberFormat.format(num);
    }

    private static void validString(String str) {
        if (str.matches(".*[^0-9,\\s].*")) {
            throw new IllegalArgumentException(" 숫자와 , 를 입력해주세요");
        }
    }
}
