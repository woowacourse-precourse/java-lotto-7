package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    private final List<Integer> purchasedLotto = new ArrayList<>();

    public void addPurchasedLotto(List<Integer> numbers) { // 전달받은 로또 번호 리스트를 멤버 변수에 누적
        this.purchasedLotto.addAll(numbers);
    }

    public List<Integer> getPurchasedLotto() {
        return purchasedLotto;
    }

}
