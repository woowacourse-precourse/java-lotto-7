package lotto.handler;

import java.util.List;
import java.util.Map;

public class PrintHandler {
    private static final String PRINT_BUY_MONEY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PRINT_WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public void printBuyMoneyAmount() {
        System.out.println(PRINT_BUY_MONEY_AMOUNT);
    }

    public void printBuyLottoNumbersOfPurchases(int numberOfPurchases) {
        System.out.println(numberOfPurchases + "개를 구매했습니다.");
    }

    public void printWinningNumbersPrompt() {
        System.out.println(PRINT_WINNING_NUMBERS_PROMPT);
    }

    public void printBonusNumberPrompt() {
        System.out.println(PRINT_BONUS_NUMBER_PROMPT);
    }

    public void printLottoNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void printResults(Map<String, Integer> results, double yield) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", results.getOrDefault("3개 일치", 0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", results.getOrDefault("4개 일치", 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", results.getOrDefault("5개 일치", 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", results.getOrDefault("5개 보너스 일치", 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", results.getOrDefault("6개 일치", 0));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}