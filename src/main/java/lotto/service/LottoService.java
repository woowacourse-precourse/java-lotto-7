package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Number;
import lotto.domain.Numbers;
import lotto.domain.Price;

public class LottoService {

    private final List<Lotto> purchasedLotteries;

    public LottoService(List<Lotto> purchasedLotteries) {
        this.purchasedLotteries = purchasedLotteries;
    }

    public Price getPurchasePrice(String input) {
        return new Price(input);
    }

    public void purchaseLotto(Price purchasePrice) {
        for (int i = 0; i < purchasePrice.getLottoAmount(); i++) {
            purchasedLotteries.add(generateLottoByNumbers(generateRandomNumbers()));
        }
    }

    private Lotto generateLottoByNumbers(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getPurchasedLotteries() {
        return Collections.unmodifiableList(purchasedLotteries);
    }

    public Numbers getWinNumbers(String input) {
        return new Numbers(input);
    }

    public Number getBonusNumber(Numbers winNumbers, String input) {
        Number bonusNumber = new Number(input);
        Number.validateBonusNumber(winNumbers, bonusNumber);
        return bonusNumber;
    }
}
