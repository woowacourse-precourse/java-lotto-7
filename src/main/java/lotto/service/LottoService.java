package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.common.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private final List<Integer> winningNumbers;
    private final Integer bonusWinningNumber;

    private List<Lotto> lottos;

    public LottoService(List<Integer> winningNumbers, Integer bonusWinningNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusWinningNumber = bonusWinningNumber;
        lottos = new ArrayList<>();
    }

    public void makeLottos(Integer money) {
        for (int i = 0; i < money / LottoConstant.LOTTO_PRICE; i++) {
            lottos.add(generateLotto());
        }
    }

    private Lotto generateLotto() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(
                        LottoConstant.MIN_NUMBER, LottoConstant.MAX_NUMBER, LottoConstant.NUMBERS_SIZE)
                .stream()
                .sorted()
                .toList());
        return lotto;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusWinningNumber() {
        return bonusWinningNumber;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
