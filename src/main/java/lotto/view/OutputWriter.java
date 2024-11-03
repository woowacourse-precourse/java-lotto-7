package lotto.view;

import java.util.List;
import java.util.Map.Entry;
import lotto.constant.WinningType;
import lotto.model.LottoPurchase;
import lotto.model.LottoResult;
import lotto.model.Lottos;

public class OutputWriter {

    public void purchasedLottos(final LottoPurchase lottoPurchase, final Lottos lottos) {
        System.out.println("\n" + lottoPurchase.getLottoCount() + "개를 구매했습니다.");
        for (List<Integer> purchasedLotto : lottos.getPurchasedLottos()) {
            System.out.println(purchasedLotto);
        }
    }

    public void lottoResult(final LottoResult result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        for (Entry<WinningType, Integer> entry : result.getResult().entrySet()) {
            final WinningType type = entry.getKey();
            if (type.equals(WinningType.NONE)) {
                continue;
            }
            System.out.print(type.getDetail());
            System.out.print(" (" + String.format("%,d", type.getPrice()) + "원)" + " - ");
            System.out.println(entry.getValue() + "개");
        }
    }

    public void incomeRatio(final double incomeRatio) {
        System.out.println("총 수익률은 " + String.format("%.1f", incomeRatio * 100) + "%입니다.");
    }
}
