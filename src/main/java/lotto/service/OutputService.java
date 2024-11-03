package lotto.service;

import java.util.List;

public class OutputService {
    public void requestPay() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showPurchasedLottoAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void showLottoNumbers(List<Integer> lotto) {
        System.out.println(lotto);
    }
}
