package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    public int purchaseAmountParser(String inputPurchaseAmount) {
        return Integer.parseInt(inputPurchaseAmount);
    }

    public List<Integer> winningNumsParser(String inputWinningNums) {
        List<Integer> winningNums = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(inputWinningNums, ",");
        while (stringTokenizer.hasMoreTokens()) {
            int winningNum = Integer.parseInt(stringTokenizer.nextToken());
            winningNums.add(winningNum);
        }
        return winningNums;
    }
}
