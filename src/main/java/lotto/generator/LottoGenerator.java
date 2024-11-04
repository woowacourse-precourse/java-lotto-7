package lotto.generator;

import static lotto.config.constant.LottoNumberConstant.MAX_NUMBER;
import static lotto.config.constant.LottoNumberConstant.MIN_NUMBER;
import static lotto.config.constant.LottoNumberConstant.REQUIRED_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.data.Lotto;
import lotto.data.WinningLotto;

public class LottoGenerator {

    public Lotto generateLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, REQUIRED_COUNT);
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> generateLottoes(long numberOfPurchases) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < numberOfPurchases; i++) {
            lottoes.add(generateLotto());
        }

        return lottoes;
    }

    public WinningLotto generateWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }

}
