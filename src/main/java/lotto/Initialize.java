package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Initialize {
    public static int InitializePurchaseAmount() {
        while (true){
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String lotteryPurchaseAmount = Console.readLine();

                return ValueValidator.ValidatePurchaseAmount(lotteryPurchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> InitializeWinningLotteryNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String[] lotteryNumbers = Console.readLine().split(",");

                return ValueValidator.ValidateWinningLotteryNumbers(lotteryNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int InitializeBonusLotteryNumber(List<Integer> winningLotteryNumbers) {
        while (true) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                String bonusLotteryNumber = Console.readLine();

                return ValueValidator.ValidateBonusLotteryNumber(bonusLotteryNumber, winningLotteryNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
