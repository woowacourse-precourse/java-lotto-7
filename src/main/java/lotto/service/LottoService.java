package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.util.InputFormatter;

public class LottoService {

    private int money;
    private final List<Lotto> purchasedLotto;
    private Lotto winningLottoNumbers;
    private WinningLotto winningLotto;
    private final InputFormatter inputFormatter;

    public LottoService() {
        this.purchasedLotto = new ArrayList<>();
        this.inputFormatter = new InputFormatter();
    }

    public void purchaseLotto(String moneyInput) {
        this.money = inputFormatter.formatMoneyInput(moneyInput);
        for (int i = 0; i < money / LottoConstant.MONEY_UNIT.getNumber(); i++) {
            purchasedLotto.add(purchaseOneLotto());
        }
    }

    public List<String> purchasedLottoNumbersMessage() {
        return purchasedLotto.stream()
                .map(Lotto::toString)
                .toList();
    }

    public void setWinningLotto(String winningNumbersInput) {
        List<Integer> winningNumbers = inputFormatter.formatWinningNumbersInput(winningNumbersInput);
        this.winningLottoNumbers = new Lotto(winningNumbers);
    }

    public void setBonusNumber(String bonusNumberInput) {
        int bonusNumber = inputFormatter.formatBonusNumberInput(bonusNumberInput);
        this.winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    public void checkLottoResult() {
        for (Lotto lotto : purchasedLotto) {
            int matchNumbers = findMatchNumbers(lotto);
            LottoRank.checkLottoPrize(matchNumbers, matchBonusNumber(lotto));
        }
    }

    public double getRateOfReturn() {
        return LottoRank.getTotalPrize() * 100.0 / money;
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
