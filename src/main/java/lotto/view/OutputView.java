package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMoney;
import lotto.service.LottoResult;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;

public class OutputView {

    private static final String LOTTO_CNT_MSG = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBERS = "[%s]";
    private static final String WIN_INSTRUCTIONS = "당첨 통계";
    private static final String DIVIDING_LINE = "---";
    private static final String WIN_STATUS = "%s - %d개";
    private static final String DELIMITER = ", ";
    private static final String NEW_LINE = System.lineSeparator();

    public void showHowManyLotto(PurchasedLottos purchasedLottos) {
        newLine();
        System.out.printf(LOTTO_CNT_MSG, purchasedLottos.size());
        newLine();
    }

    public void showAllLottoNums(PurchasedLottos purchasedLottos) {
        for (Lotto lotto : purchasedLottos.lottos()) {
            showLottoNums(lotto);
        }
        newLine();
    }

    public void showWinStatus(LottoResult lottoResult) {
        showWinInstructions();
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                System.out.printf(WIN_STATUS, rank.toString(), lottoResult.countOf(rank));
                newLine();
            }
        }
    }

    private void showWinInstructions() {
        newLine();
        System.out.println(WIN_INSTRUCTIONS);
        System.out.println(DIVIDING_LINE);
    }

    public void showProfit(LottoResult lottoResult, LottoMoney lottoMoney) {
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoResult.calculateProfit(lottoMoney));
    }

    private void showLottoNums(Lotto lotto) {
        String numbers = changeNumbersToString(lotto);
        System.out.printf(LOTTO_NUMBERS, numbers);
        newLine();
    }

    private String changeNumbersToString(Lotto lotto) {
        return String.join(DELIMITER, lotto.numbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .toList());
    }

    private void newLine() {
        System.out.print(NEW_LINE);
    }
}
