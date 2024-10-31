package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class LottoTicketPurchaseView {
    public void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구입하였습니다.");
    }

    public void printLottoPurchase(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

}
