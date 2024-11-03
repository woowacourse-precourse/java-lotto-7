package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLotto {
    private static final PurchasedLotto instance = new PurchasedLotto(); // 유일한 인스턴스 생성

    private final List<Integer> purchasedLotto = new ArrayList<>();

    private PurchasedLotto() {
        // private 생성자로 외부에서 인스턴스 생성 차단
    }

    public static PurchasedLotto getInstance() {
        return instance;
    }

    public void addPurchasedLotto(List<Integer> numbers) { // 전달받은 로또 번호 리스트를 멤버 변수에 누적
        this.purchasedLotto.addAll(numbers);
    }

    public List<Integer> getPurchasedLotto() {
        return this.purchasedLotto;
    }
}

