package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoManager {
    private PurchasedLottos purchasedLottos;
    private Set<Integer> winningNumbers;
    private int bonusNumber;

    public void run() {
        purchaseLotto();
        progressLottoGame();
        announceLottoResult();
    }

    private void purchaseLotto() {
        issueLotto(getLottoPurchaseAmount());
        OutputView.showPurchasedLottos(purchasedLottos.getPurchasedLottos());
    }

    private int getLottoPurchaseAmount() {
        while (true) {
            try {
                return PurchaseAmountParser.parse(InputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void issueLotto(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        int count = purchaseAmount / LottoConstants.LOTTO_PRICE;

        OutputView.showPurchasedLottosQuantity(count);

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_LOTTO_NUMBER,
                    LottoConstants.MAX_LOTTO_NUMBER,
                    LottoConstants.LOTTO_PICK_SIZE
            ));
            lottos.add(lotto);
        }

        purchasedLottos = new PurchasedLottos(lottos);
    }


    private void progressLottoGame() {
        winningNumbers = getWinningNumbers();
        bonusNumber = getBonusNumber();

    }

    private Set<Integer> getWinningNumbers() {
        while (true) {
            try {
                return WinningNumbersParser.parse(InputView.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                return BonusNumberParser.parse(InputView.readBonusNumber(), winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void announceLottoResult() {


    }

}
