package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.constant.LottoRank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;

public class LottoService {

    private List<Lotto> purchasedLotto = new ArrayList<>();
    private Lotto winnerLotto;
    private BonusNumber bonusNumber;

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

    public void setWinnerLotto(List<Integer> winnerNumbers) {
        this.winnerLotto = new Lotto(winnerNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumberDuplicated(bonusNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public void checkLottoResult() {
        purchasedLotto.forEach(this::checkOneLottoResult);
    }

    private void checkOneLottoResult(Lotto lotto) {
        int matchNumbers = findMatchNumbers(lotto);
        LottoRank.checkLottoPrize(matchNumbers, matchBonusNumber(lotto));
    }

    private int findMatchNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(number -> winnerLotto.getNumbers().contains(number))
                .toList().size();
    }

    private Lotto purchaseOneLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_NUMBER_LOWER_BOUND.getNumber(),
                LottoConstant.LOTTO_NUMBER_UPPER_BOUND.getNumber(),
                LottoConstant.NUMBER_OF_LOTTO_NUMBERS.getNumber()));
    }

    private void validateBonusNumberDuplicated(int bonusNumber) {
        if (winnerLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 당첨 번호와 중복됩니다.");
        }
    }

    private boolean matchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
