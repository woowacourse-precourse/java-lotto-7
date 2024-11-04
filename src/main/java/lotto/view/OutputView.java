package lotto.view;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.messages.WinningMessage;

public class OutputView {

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printPurchaseAmount(int purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount+ "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
        System.out.println();
    }

    public void printWinningResult(Map<WinningMessage, Integer> winningResult, double performance) {
        System.out.println("당첨 통계");
        System.out.println("---");

        winningResult.forEach((message, count) -> {
            System.out.printf("%s - %d개\n", message.getMessage(), count);
        });

        System.out.printf("총 수익률은 %.1f%%입니다.\n", performance);
    }
}
