package lotto.view;

import lotto.domain.Lotto;
import lotto.service.LottoResult;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;

public class OutputView {

    private static final String LOTTO_CNT_MSG = "%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBERS = "[%s]\n";

    public void showHowManyLotto(PurchasedLottos purchasedLottos) {
        System.out.println();
        System.out.printf(LOTTO_CNT_MSG, purchasedLottos.size());
    }

    public void showAllLottoNums(PurchasedLottos purchasedLottos) {
        for (Lotto lotto : purchasedLottos.getLottos()) {
            showLottoNums(lotto);
        }
        System.out.println();
    }

    public void showWinStatus(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getMsg() + lottoResult.getResult().get(rank) + "개");
        }
    }

    public void showProfit(Rank rank, int money) {
        long sum = rank.getPrize();
        System.out.printf("총 수익률은 %.1f%%입니다.", (((double)sum/money) * 100.0));
    }

    private void showLottoNums(Lotto lotto) {
        String numbers = String.join(", ", lotto.lottoNums()
                .stream()
                .map(String::valueOf)
                .toList());
        System.out.printf(LOTTO_NUMBERS, numbers);
    }
}
