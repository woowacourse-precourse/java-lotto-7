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

    public List<Lotto> buyLotto(long purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseAmount / LOTTO_PRICE; i++)
            selectLottoNumbers(lottos);

        return lottos.stream()
                .map(lotto -> new Lotto(lotto.getNumbers()))
                .toList();
    }

    public void selectLottoNumbers(List<Lotto> lottos) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, NUMBER_COUNT);
        lottos.add(new Lotto(numbers));
    }
}
