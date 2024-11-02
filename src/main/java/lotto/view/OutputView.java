package lotto.view;

import java.util.List;
import lotto.enums.OutputViewEnum;
import lotto.model.Lotto;

public class OutputView {
    private static final String ERROR = "[ERROR] ";

    public static void errorPrint(String errorMessage) {
        System.out.println(ERROR + errorMessage);
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
}
