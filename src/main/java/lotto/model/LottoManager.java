package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.utils.validator.LottoValidator;
import lotto.utils.validator.Validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoManager {
    private final Integer price;
    private final List<Lotto> purchasedLotto = new ArrayList<>();
    public Validator<List<Integer>> validator;

    public LottoManager(Integer price) {
        this.price = price;
        this.validator = new LottoValidator();
    }

    public Integer purchaseLotto() {
        int numberOfLotto = price / 1000;
        for (int i = 0; i < numberOfLotto; i++) {
            purchasedLotto.add(generateRandomLotto());
        }
        return numberOfLotto;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    private Lotto generateRandomLotto() {
        List<Integer> randomLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(randomLottoNumber);
        return new Lotto(randomLottoNumber);
    }

    public void isLottoResult(List<Integer> lottoResult, Integer bonusNumber) {
        validator.validate(lottoResult);
    }

}
