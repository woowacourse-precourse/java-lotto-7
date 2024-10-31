package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class LottoTicketPurchaseView {
    public static final int ONE_LOTTO_PRICE = 1000;

    public void printPurchaseCount(int purchasePrice) {
        System.out.println((purchasePrice / ONE_LOTTO_PRICE) + "개를 구입하였습니다.");
    }

    public void printLottoPurchase(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

}
