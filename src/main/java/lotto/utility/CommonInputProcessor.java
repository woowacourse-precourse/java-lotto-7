package lotto.utility;

public class CommonInputProcessor {

    public static String removeSpace(String input) {
        return input.strip().replaceAll(" ", "");
    }
}
