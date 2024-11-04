package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ValueValidator {
    public static int ValidatePurchaseAmount(String lotteryPurchaseAmount) {
        try {
            int purchaseAmount = Integer.parseInt(lotteryPurchaseAmount.trim());
            if(purchaseAmount <= 0 || purchaseAmount % LottoMachine.LOTTO_PRICE != 0){
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위의 양의 정수여야 합니다.");
            }

            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위의 양의 정수여야 합니다.");
        }
    }

    public static List<Integer> ValidateWinningLotteryNumbers(String[] lotteryNumbers) {
        try {
            List<Integer> winningLotteryNumbers = new ArrayList<>();
            HashSet<Integer> duplicateChecker = new HashSet<>();

            for (String lotteryNumber : lotteryNumbers) {
                int winningLotteryNumber = Integer.parseInt(lotteryNumber.trim());
                if (winningLotteryNumber <= 0 || winningLotteryNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45까지의 정수여야 합니다.");
                }
                winningLotteryNumbers.add(winningLotteryNumber);
                duplicateChecker.add(winningLotteryNumber);
            }
            if (duplicateChecker.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없고 6개여야 합니다.");
            }

            return winningLotteryNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45까지의 정수여야 합니다.");
        }
    }

    public static int ValidateBonusLotteryNumber(String bonusLotteryNumber, List<Integer> winningLotteryNumbers) {
        try {
            int bonusNumber = Integer.parseInt(bonusLotteryNumber);
            if (bonusNumber <= 0 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45까지의 정수여야 합니다.");
            }
            if (winningLotteryNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 중복될 수 없습니다.");
            }

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45까지의 정수여야 합니다.");
        }
    }
}
