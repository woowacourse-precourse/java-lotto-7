package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class IOPrompt {
    public static String inputPurchaseAmount() {
        System.out.println(IOMessage.PURCHASE_AMOUNT.getMessage());
        return readLine();
    }

    public static void showUserLottos(UserLottos userLottos) {
        System.out.println();
        System.out.println(userLottos.getQuantity() + IOMessage.PURCHASE_QUANTITY.getMessage());
        System.out.println(userLottos.getUserLottoNumbers());
    }

    public static String inputWinningNumbers() {
        System.out.println(IOMessage.WINNING_NUMBERS.getMessage());
        return readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(IOMessage.BONUS_NUMBER.getMessage());
        return readLine();
    }

    public static void showResult(Result result, UserLottos userLottos) {
        System.out.printf("\n%s\n%s\n", IOMessage.STATISTICS.getMessage(), IOMessage.DIVIDER.getMessage());
        System.out.println(result.getResult());
        System.out.println("총 수익률은 " + result.calculateStatistic(userLottos.getPurchaseAmount()) + "%입니다.");
    }
}
