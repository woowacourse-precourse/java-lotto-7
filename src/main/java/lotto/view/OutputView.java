package lotto.view;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    public void printWinningResult(Map<WinningMessage, Integer> winningResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(printResult(winningResult));
    }

    public String printResult(Map<WinningMessage, Integer> winningResult) {
        return winningResult.entrySet().stream()
                .map(entry ->
                        String.format("%s %d개",
                                entry.getKey().getMessage(),
                                /*entry.getKey().getMatchCount(),
                                entry.getKey().getWinningAmount(),*/
                                entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
