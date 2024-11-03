package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {
    public void printPurchaseLotto(List<Lotto> purchaseLottoList) {
        System.out.println("구매한 로또");
        for (Lotto lotto : purchaseLottoList) {
            System.out.println(lotto);
        }

    }
}
