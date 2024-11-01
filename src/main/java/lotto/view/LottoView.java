package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class LottoView {

    // TODO: 의존성 주입
    private final RankMessageGenerator rankMessageGenerator = new RankMessageGenerator();
    private final LottoMessageGenerator lottoMessageGenerator = new LottoMessageGenerator();

    public void showWinningResult(Map<LottoRank, Integer> ranks) {
        List<LottoRank> lottoRanks = LottoRank.getRanksOrderByReward();
        for (LottoRank lottoRank : lottoRanks) {
            String message = rankMessageGenerator.getMessage(lottoRank, ranks);
            System.out.println(message);
        }
    }

    public void showPurchasedLottos(List<Lotto> purchasedLottos) {
        String purchaseQuantityMessage = lottoMessageGenerator.getPurchaseQuantityMessage(purchasedLottos.size());
        System.out.println(purchaseQuantityMessage);

        for (Lotto lotto : purchasedLottos) {
            String sortedNumbersMessage = lottoMessageGenerator.getSortedNumbersMessage(lotto);
            System.out.println(sortedNumbersMessage);
        }

        System.out.println();
    }

}
