package lotto.utils;

public class Converter {

    public static int priceToLottoCount(String input) {
        int count = Integer.parseInt(input);

        return count/1000;
    }
}
