package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class IOController {
    private static String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private static String OUTPUT_PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static String OUTPUT_WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";

    public String inputPurchaseAmount() {
        String purchaseAmountInput;
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        purchaseAmountInput = Console.readLine();
        return purchaseAmountInput;
    }

    public String inputWinningNumbers() {
        String winningNumbersInput;
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        winningNumbersInput = Console.readLine();
        return winningNumbersInput;
    }

    public String inputBonusNumber() {
        String bonusNumberInput;
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        bonusNumberInput = Console.readLine();
        return bonusNumberInput;
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + OUTPUT_PURCHASE_COUNT_MESSAGE);
        for (Lotto lotto : lottos) {
            printLotto(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printLotto(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void printWinningStatistics(double statistic) {
        System.out.println("총 수익률은 " + statistic + "%입니다.");
    }

    public void printWinningResults(Map<Rank, Integer> winningStatistics) {
        System.out.println(OUTPUT_WINNING_STATISTICS_MESSAGE);
        winningStatistics.entrySet().stream()
            .filter(entry -> entry.getKey() != Rank.ETC)
            .sorted(Comparator.comparingInt(entry -> entry.getKey().ordinal()))
            .forEach(entry -> {
                System.out.println(entry.getKey().getPrintMessage() + " - " + entry.getValue() + "개");
        });
    }
}

