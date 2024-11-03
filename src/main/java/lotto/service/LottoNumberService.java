package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningLotto;
import lotto.utils.LottoNumberGenerator;

public class LottoNumberService {

    private PurchasedLotto purchasedLotto;
    private WinningLotto winningLotto;
    private Lotto winningNumbers;

    public void purchaseLotto(int purchaseAmount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> number = LottoNumberGenerator.generateNumber();
            purchasedLottos.add(new Lotto(number));
        }
        purchasedLotto = new PurchasedLotto(purchasedLottos);
    }

    public void setWinningNumbers(List<Integer> winningNumbers) throws IllegalArgumentException {
        this.winningNumbers = new Lotto(winningNumbers);
    }

    public void createWinningLotto(int bonusNumber) {
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    public void validateBonusNumber(int bonusNumber) throws IllegalArgumentException {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public PurchasedLotto getPurchasedLotto() {
        return purchasedLotto;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
