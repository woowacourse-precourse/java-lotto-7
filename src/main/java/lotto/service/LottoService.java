package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import lotto.view.OutputView;

public class LottoService {

    private final static int MONEY_UNIT = 1000;
    private final static int LOTTO_NUMBER_UPPER_BOUND = 45;
    private final static int LOTTO_NUMBER_LOWER_BOUND = 1;
    private final static int NUMBER_OF_LOTTO_NUMBERS = 6;

    private List<Lotto> purchasedLotto = new ArrayList<>();
    private Lotto winnerLotto;
    private int bonusNumber;

    public void purchaseLotto(int money) {
        for (int i = 0; i < money / MONEY_UNIT; i++) {
            purchasedLotto.add(purchaseOneLotto());
        }
    }

    public void printPurchasedLottoNumbers() {
        OutputView.printPurchasedLotto(purchasedLotto);
    }

    public void setWinnerLotto(List<Integer> winnerNumbers) {
        this.winnerLotto = new Lotto(winnerNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void checkLottoResult() {
        purchasedLotto.forEach(this::checkOneLottoResult);
    }

    private void checkOneLottoResult(Lotto lotto) {
        int matchNumbers = findMatchNumbers(lotto);

        if (matchNumbers == 3) {
            LottoRank.FIFTH.win();
        } else if (matchNumbers == 4) {
            LottoRank.FORTH.win();
        } else if (matchNumbers == 5 && !matchBonusNumber(lotto)) {
            LottoRank.THIRD.win();
        } else if (matchNumbers == 5) {
            LottoRank.SECOND.win();
        } else if (matchNumbers == 6) {
            LottoRank.FIRST.win();
        }
    }

    private int findMatchNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(number -> winnerLotto.getNumbers().contains(number))
                .toList().size();
    }

    private Lotto purchaseOneLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_LOWER_BOUND, LOTTO_NUMBER_UPPER_BOUND,
                NUMBER_OF_LOTTO_NUMBERS));
    }

    private boolean matchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
