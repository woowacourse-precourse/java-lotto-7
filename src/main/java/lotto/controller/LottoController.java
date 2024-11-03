package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.domain.LottoConstants.LOTTO_PRICE;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        PurchasedPrice purchasedPrice = null;
        while (purchasedPrice == null) {
            try {
                purchasedPrice = new PurchasedPrice(InputView.readPurchasedPrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Lottos purchasedLottos = generate(purchasedPrice);
        OutputView.printPurchasedLottos(purchasedLottos);

        Lotto winningNumbers = null;
        while (winningNumbers == null) {
            try {
                winningNumbers = new Lotto(InputView.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        BonusNumber bonusNumber = null;
        while (bonusNumber == null) {
            try {
                bonusNumber = new BonusNumber(InputView.readBonusNumber(), winningNumbers.getNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        printWinningResult(purchasedLottos, winningNumbers, bonusNumber, purchasedPrice);
    }

    private Lottos generate(PurchasedPrice purchasedPrice) {
        int lottoCount = purchasedPrice.getPurchasedPrice() / LOTTO_PRICE;
        return lottoService.generateLottos(lottoCount);
    }

    private void printWinningResult(Lottos purchasedLottos, Lotto winningNumbers, BonusNumber bonusNumber, PurchasedPrice purchasedPrice) {
        LottoRanks lottoRanks = lottoService.getResult(purchasedLottos, winningNumbers, bonusNumber);
        OutputView.printResult(lottoRanks, purchasedPrice);
    }

}
