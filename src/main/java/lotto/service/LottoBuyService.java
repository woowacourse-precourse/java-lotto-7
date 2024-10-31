package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyService {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;
    private static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    public List<Lotto> buyLotto(final long purchaseAmount) {
        validate(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseAmount / LOTTO_PRICE; i++)
            selectLottoNumbers(lottos);

        return lottos.stream()
                .map(lotto -> new Lotto(lotto.getNumbers()))
                .toList();
    }

    public void selectLottoNumbers(final List<Lotto> lottos) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        lottos.add(new Lotto(numbers));
    }

    private void validate(final long purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }
}
