package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.domain.LottoConstants.LOTTO_PRICE;

public class LottoController {

    private final LottoService lottoService = new LottoService();

    public void run() {
        try {

            PurchasedPrice purchasedPrice = new PurchasedPrice(InputView.readPurchasedPrice());

            Lottos purchasedLottos = generate(purchasedPrice);
            OutputView.printPurchasedLottos(purchasedLottos);

            Lotto winningNumbers = new Lotto(InputView.readWinningNumbers());
            BonusNumber bonusNumber = new BonusNumber(InputView.readBonusNumber(), winningNumbers.getNumbers());

            printWinningResult(purchasedLottos, winningNumbers, bonusNumber);


        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    private Lottos generate(PurchasedPrice purchasedPrice) {
        int lottoCount = purchasedPrice.getPurchasedPrice() / LOTTO_PRICE;
        return lottoService.generateLottos(lottoCount);
    }

    private void printWinningResult(Lottos purchasedLottos, Lotto winningNumbers, BonusNumber bonusNumber) {
        LottoRanks lottoRanks = lottoService.getResult(purchasedLottos, winningNumbers, bonusNumber);
        OutputView.printResult(lottoRanks);
    }

}
