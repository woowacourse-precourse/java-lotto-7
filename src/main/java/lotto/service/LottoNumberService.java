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
    private Lotto winningLottoNumbers;

    public void purchaseLotto(int purchaseAmount) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> number = LottoNumberGenerator.generateNumber();
            purchasedLottos.add(new Lotto(number));
        }
        purchasedLotto = new PurchasedLotto(purchasedLottos);
    }

    public void setWinningLottoNumbers(List<Integer> winningLottoNumbers) throws IllegalArgumentException {
        this.winningLottoNumbers = new Lotto(winningLottoNumbers);
    }

    public void createWinningLotto(int bonusNumber) throws IllegalArgumentException {
        winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    public PurchasedLotto getPurchasedLotto() {
        return purchasedLotto;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }
}
