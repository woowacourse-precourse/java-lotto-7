package lotto.service;

import lotto.constants.LottoConstants;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoCounter;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoGenerator lottoGenerator;
    private final LottoNumberChecker lottoNumberChecker;
    private final LottoCounter rankCounter;

    public LottoMachine(LottoGenerator lottoGenerator, LottoNumberChecker lottoNumberChecker) {
        this.lottoGenerator = lottoGenerator;
        this.lottoNumberChecker = lottoNumberChecker;
        this.rankCounter = new LottoCounter();
    }

    public List<Lotto> purchaseLottos(Money money) {
        int totalAmount = money.getAmount();
        int numberOfLottos = totalAmount / LottoConstants.LOTTO_PRICE;
        List<Lotto> purchasedLottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            purchasedLottos.add(lottoGenerator.generateLotto());
        }

        return purchasedLottos;
    }

    public LottoCounter getRankCounter() {
        return rankCounter;
    }

    public void checkWinningNumbers(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            LottoRank rank = lottoNumberChecker.check(lotto.getNumbers(), winningNumbers, bonusNumber);
            rankCounter.addResult(rank);
        }
    }
}