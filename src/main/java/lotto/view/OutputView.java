package lotto.view;

import java.util.List;

public class OutputView {
    public static void printInsertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printLottoTicketMessage(int ticket) {
        System.out.println("\n" + ticket + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printLottoNumbersGuide() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printResultMessage() {
        System.out.println("\n당첨 통계\n---");
    }

    public static void printResult(String description, int prize, int count) {
        String formattedPrize = String.format("%,d", prize);
        System.out.println(description + " (" + formattedPrize + "원) - " + count + "개");
    }

    public static void printProfitRate(double profitRate) {
        String formattedProfitRate = String.format("%,.1f", profitRate);
        System.out.println("총 수익률은 " + formattedProfitRate + "%입니다.");
    }
}
