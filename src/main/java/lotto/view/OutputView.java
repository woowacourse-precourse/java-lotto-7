package lotto.view;

import lotto.domain.Lotto;
import lotto.service.LottoResult;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;

public class OutputView {

    private static final String LOTTO_CNT_MSG = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBERS = "[%s]";
    public static final String WIN_INSTRUCTIONS = "당첨 통계";
    public static final String DIVIDING_LINE = "---";
    public static final String NEW_LINE = System.lineSeparator();

    public void showHowManyLotto(PurchasedLottos purchasedLottos) {
        newLine();
        System.out.printf(LOTTO_CNT_MSG, purchasedLottos.size());
        newLine();
    }

    public void showAllLottoNums(PurchasedLottos purchasedLottos) {
        for (Lotto lotto : purchasedLottos.lottos()) {
            showLottoNums(lotto);
        }
        System.out.println();
    }

    public void showWinStatus(LottoResult lottoResult) {
        StringBuilder output = new StringBuilder();
        showWinInstructions();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                output.append(rank.toString())
                        .append(" - ")
                        .append(lottoResult.countOf(rank))
                        .append("개")
                        .append(System.lineSeparator());
            }
        }
        System.out.printf(output.toString());
    }

    private void showWinInstructions() {
        newLine();
        System.out.println(WIN_INSTRUCTIONS);
        System.out.println(DIVIDING_LINE);
    }

    public void showProfit(LottoResult lottoResult, int money) {
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoResult.calculateProfit(money));
    }

    private void showLottoNums(Lotto lotto) {
        String numbers = String.join(", ", lotto.numbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .toList());
        System.out.printf(LOTTO_NUMBERS, numbers);
        newLine();
    }

    private void newLine() {
        System.out.print(NEW_LINE);
    }
}
