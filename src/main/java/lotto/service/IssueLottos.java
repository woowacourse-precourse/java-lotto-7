package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoConstants;
import lotto.domain.PurchasedLottos;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
public class IssueLottos {
    public static PurchasedLottos issueLottos(int purchaseAmount) {
        int issueQuantity = getIssueQuantity(purchaseAmount);
        OutputView.showPurchasedLottosQuantity(issueQuantity);

        return new PurchasedLottos(issue(issueQuantity), purchaseAmount);
    }

    private static int getIssueQuantity(int purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_PRICE;
    }

    private static List<Lotto> issue(int issueQuantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < issueQuantity; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_LOTTO_NUMBER,
                    LottoConstants.MAX_LOTTO_NUMBER,
                    LottoConstants.LOTTO_PICK_SIZE
            ));
            lottos.add(lotto);
        }
        return lottos;
    }
}
