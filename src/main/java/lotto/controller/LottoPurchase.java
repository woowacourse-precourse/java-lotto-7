package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.validation.Validation;
import lotto.view.Input;
import lotto.view.Output;

import static lotto.domain.Constants.LOTTO_MAX;
import static lotto.domain.Constants.LOTTO_MIN;
import static lotto.domain.Constants.LOTTO_NUM_COUNT;
import static lotto.domain.Constants.LOTTO_PRICE;

public class LottoPurchase {
    Input input = new Input();
    Validation validation = new Validation();
    Lotto lotto;
    Output output = new Output();

    protected int purchaseAmount() {
        int amount = input.price();
        validation.purchase(amount);

        return amount / LOTTO_PRICE;
    }

    public List<Lotto> issueLotto(int numberOfLottos) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = generateLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
        output.purchaseAmount(lottoList);
        return lottoList;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN, LOTTO_MAX, LOTTO_NUM_COUNT);
        Collections.sort(numbers);
        lotto = new Lotto(numbers);
        return numbers;
    }
}



