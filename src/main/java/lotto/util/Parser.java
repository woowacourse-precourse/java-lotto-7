package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    public static int purchaseAmountParser(String inputPurchaseAmount) {
        try {
            return Integer.parseInt(inputPurchaseAmount);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 정수로 입력해야 합니다.");
        }
    }

    public static List<Integer> winningNumsParser(String inputWinningNums) {
        try {
            List<Integer> winningNums = new ArrayList<>();
            StringTokenizer stringTokenizer = new StringTokenizer(inputWinningNums, ",");
            while (stringTokenizer.hasMoreTokens()) {
                int winningNum = Integer.parseInt(stringTokenizer.nextToken());
                winningNums.add(winningNum);
            }
            return winningNums;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 정수로 입력해야 합니다.");
        }
    }

    public static int bonusNumParser(String inputBonusNum) {
        try {
            return Integer.parseInt(inputBonusNum);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수로 입력해야 합니다.");
        }
    }
}
