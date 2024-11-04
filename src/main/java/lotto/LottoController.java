package lotto;

import java.util.List;
import java.util.stream.Stream;

public class LottoController {

    public static void validatePurchaseNumber(int amount) {
        if (amount < 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위로 입력가능합니다.");
        }
    }

    public int parsePurchaseNumber(String input) {
        try {
            int purchaseNumber = Integer.parseInt(input.trim());
            validatePurchaseNumber(purchaseNumber);
            return purchaseNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 구입금액 입니다.");
        }
    }

    public List<Integer> parseWinNumber(String input) {
        try {
            List<Integer> numbers = Stream.of(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
            Lotto.validate(numbers);
            return numbers;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 로또 번호입니다.");
        }
    }

    public int parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("올바른 로또 번호 형식이 아닙니다.");
        }
    }

    public WinNumbers mapWimNumbers(List<Integer> winNumber, int bonusNumber) {
        return new WinNumbers(winNumber, bonusNumber);
    }

    public int calculateWinnings(List<Lotto> lottos, WinNumbers winNumbers) {
        int totalWinnings = 0;
        int[] rankCount = new int[Rank.values().length];
        for (Lotto lotto : lottos) {
            Rank rank = lotto.matchWinNumbers(winNumbers.getWinNumbers(), winNumbers.getBonusNumber());
            rankCount[rank.ordinal()]++;
            totalWinnings += rank.getPrizeMoney();
        }
        return totalWinnings;
    }

    public double calculateRateOfReturn(int totalWinnings, int purchaseNumber) {
        double rateOfReturn = ((double) totalWinnings / purchaseNumber) * 100;
        return Math.round(rateOfReturn) / 10.0;
    }
}
