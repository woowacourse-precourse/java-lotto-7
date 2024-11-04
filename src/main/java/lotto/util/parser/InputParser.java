package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public int convertPurchaseAmountToInt(String input) {
        int purchaseAmount = Integer.parseInt(input);

        return purchaseAmount;
    }

    public List<Integer> getWinNumList(String input) {
        List<Integer> winNumList = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winNumList;
    }

    public int convertWinningBonusNumber(String input) {
        int winBonusNum = Integer.parseInt(input);
        return winBonusNum;
    }


}
