package lotto.dto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGroup;

public class LottoPurchaseDetails {
    private static final String PURCHASED_NUM_LOTTO_MESSAGE = "%d개를 구매했습니다.";
    private static final String NEW_LINE = "\n";

    private final List<Lotto> lottos;
    private final int numLotto;

    public LottoPurchaseDetails(LottoGroup lottoGroup) {
        lottos = lottoGroup.getLottos();
        numLotto = lottoGroup.getLottos().size();
    }

    public String getPurchaseDetailsMessage() {
        StringBuilder purchaseDetailsMessage = new StringBuilder();

        purchaseDetailsMessage.append(formatPurchasedNumLottoMessage()).append(NEW_LINE);
        for (Lotto lotto : lottos) {
            purchaseDetailsMessage.append(lotto.getNumbers()).append(NEW_LINE);
        }

        return purchaseDetailsMessage.toString();
    }

    private String formatPurchasedNumLottoMessage() {
        return String.format(PURCHASED_NUM_LOTTO_MESSAGE, numLotto);
    }
}
