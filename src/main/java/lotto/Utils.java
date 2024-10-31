package lotto;

import static lotto.ExceptionHandler.validateNumeric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Utils {
    private static final String COMMA = ",";

    public static List<String> parseByComma(String text) {
        List<String> parsedText = Arrays.asList(text.split(COMMA));
        parsedText.replaceAll(String::strip);
        return parsedText;
    }

    public static List<Integer> convertToSortedNumber(List<String> numbersText) {
        List<Integer> commaSeperatedNumber = new ArrayList<>();
        for (String numberText : numbersText) {
            validateNumeric(numberText);
            commaSeperatedNumber.add(Integer.parseInt(numberText));
        }
        commaSeperatedNumber.sort(Comparator.naturalOrder());
        return commaSeperatedNumber;
    }

    public static List<Lotto> publishLottos(int publishAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < publishAmount; i++) {
            lottos.add(Lotto.publish());
        }
        return lottos;
    }

    public static String calculateProfitRate(int purchaseAmount) {
        long profit = 0;
        for (LottoWinner winner : LottoWinner.values()) {
            profit += winner.calculateProfit();
        }
        double profitRate = (double) profit / purchaseAmount;
        return String.format("%.2f", profitRate);
    }
}
