package lotto;

import static lotto.LottoRule.NUMBER_LENGTH;
import static lotto.LottoRule.WINNING_PRIZE_TABLE;

import java.io.PrintStream;

/**
 * Printer
 */
public class Printer {

    private PrintStream out;
    private final String[] winningPlaceDescriptionFormats = {
        "",
        "6개 일치 (%,d원) - %d개\n",
        "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n",
        "5개 일치 (%,d원) - %d개\n",
        "4개 일치 (%,d원) - %d개\n",
        "3개 일치 (%,d원) - %d개\n",
    };

    public Printer(PrintStream out) {
        this.out = out;
    }

    public void purchaseAmountPrompt() {
        out.println("구입급액을 입력해 주세요.");
    }

    public void winningNumberPrompt() {
        out.println("당첨 번호를 입력해 주세요.");
    }

    public void bonusNumberPrompt() {
        out.println("보너스 번호를 입력해 주세요.");
    }

    public void purchased(Player player) {
        out.printf("%d개를 구매했습니다.\n", player.getLottoAmount());
        for (Lotto lotto : player.getLottos()) {
            out.println(lotto.getSortedNumbers());
        }
    }

    public void summary(Player player) {
        out.println("당첨 통계");
        out.println("---");
        for (int i = NUMBER_LENGTH - 1; i > 0; i--) {
            out.println(String.format(
                winningPlaceDescriptionFormats[i],
                WINNING_PRIZE_TABLE[i],
                player.getWinningCounts()[i]
            ));
        }
        out.printf("총 수익률은 %.1f%%입니다.", player.getRateOfReturn());
    }

    public void linebreak() {
        out.println();
    }

}
