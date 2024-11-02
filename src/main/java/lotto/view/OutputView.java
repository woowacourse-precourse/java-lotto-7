package lotto.view;

import java.util.List;
import lotto.enums.OutputViewEnum;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningResult;

public class OutputView {

    public static void errorPrint(String errorMessage) {
        System.out.println(OutputViewEnum.ERROR_MESSAGE_FORMAT.getMessage() + errorMessage);
    }

    public static void printPrompt(String string) {
        System.out.println(string);
    }

    public static void printLotto(Lotto lotto) {
        String lottoText = String.join(", ", lotto.getNumbers().stream().map(String::valueOf).toList());
        lottoText = "[" + lottoText + "]";
        System.out.println(lottoText);
    }

    public static void printTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + OutputViewEnum.PURCHASE_COUNT_MESSAGE.getMessage());
        for (Lotto lotto : tickets) {
            printLotto(lotto);
        }
    }

    public static void printWinningResults(WinningResult winningResult) {
        System.out.println("당첨 통계\n" + "---");
        for (Rank rank : Rank.values()) {
            int count = winningResult.getResult().getOrDefault(rank, 0);
            System.out.printf("%s (%,d원) - %d개\n", rank.getMatchMessage(), rank.getPrize(), count);
        }
    }

    public static void printProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
