package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.dto.Bag;
import lotto.dto.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.util.Validator.validatePositiveNumber;

public class User {
    private int purchaseAmount;
    private LottoResult lottoResult;
    private Bag bag;

    public User(int purchaseAmount) {
        validatePositiveNumber(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        lottoResult = new LottoResult();
        bag = new Bag();
    }

    public void buyLotto(Lotto lotto) {
        bag.addLotto(lotto);
    }
    public List<Integer> pickNumbersSorted() {
        List<Integer> pickNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        pickNumbers.sort(Comparator.naturalOrder());
        return pickNumbers;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public Bag getBag() {
        return bag;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
    public List<Lotto> getPurchasedLotto() {
        return bag.getPurchasedLotto();
    }
}
