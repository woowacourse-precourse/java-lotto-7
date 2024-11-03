package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenerateLotto {
    private final OutputService outputService = new OutputService();
    public List<Lotto> generateLottoNumbers(int amount) {
        outputService.showPurchasedLottoAmount(amount);
        List<Lotto> purchaseLotto = new ArrayList<>();
        for(int i=0; i<amount; i++) {
            Lotto lotto = new Lotto(drawRandomNumbers());
            outputService.showLottoNumbers(lotto.getNumbers());
            purchaseLotto.add(lotto);
        }

        return purchaseLotto;
    }

    private List<Integer> drawRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
