package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.InvalidPurchaseAmountException;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    // 구입 금액을 기준으로 로또 개수를 계산하고 발행
    public void purchaseLottos(int amount) {
        int count = calculateLottoCount(amount);
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(generateLotto());
        }
    }

    private int calculateLottoCount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new InvalidPurchaseAmountException("구입 금액이 부족하여 로또를 구매할 수 없습니다.");
        }
        return amount / LOTTO_PRICE;
    }

    private Lotto generateLotto() {
        // List<Integer>로 받기
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }
}