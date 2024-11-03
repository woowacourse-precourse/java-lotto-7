package lotto.view;

import lotto.data.Lotto;

import java.util.List;

public class OutputView {
    public void printPurchaseLotto(List<Lotto> purchaseLottoList) {
        System.out.println(purchaseLottoList.size() + "개를 구매했습니다.");
        purchaseLottoList.stream().forEach(System.out::println);
    }
}
