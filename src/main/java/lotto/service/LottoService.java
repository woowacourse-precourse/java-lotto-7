package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

public class LottoService {

    private List<Lotto> purchasedLotto = new ArrayList<>();
    private WinningLotto winningLotto;

    public void purchaseLotto(int money) {
        for (int i = 0; i < money / LottoConstant.MONEY_UNIT.getNumber(); i++) {
            purchasedLotto.add(purchaseOneLotto());
        }
    }

    public List<String> purchasedLottoNumbersMessage() {
        return purchasedLotto.stream()
                .map(Lotto::toString)
                .toList();
    }

    public void setWinningLotto(List<Integer> winningNumbers) {
        this.winningLotto = new WinningLotto(new Lotto(winningNumbers));
    }

    public void setBonusNumber(int bonusNumber) {
        winningLotto.setBonusNumber(bonusNumber);
    }

    public void checkLottoResult() {
        for (Lotto lotto : purchasedLotto) {
            int matchNumbers = findMatchNumbers(lotto);
            LottoRank.checkLottoPrize(matchNumbers, matchBonusNumber(lotto));
        }
    }

    private int findMatchNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(number -> winningLotto.getWinningLottoNumbers().contains(number))
                .toList().size();
    }

    private Lotto purchaseOneLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_NUMBER_LOWER_BOUND.getNumber(),
                LottoConstant.LOTTO_NUMBER_UPPER_BOUND.getNumber(),
                LottoConstant.NUMBER_OF_LOTTO_NUMBERS.getNumber()));
    }

    private boolean matchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }
}
