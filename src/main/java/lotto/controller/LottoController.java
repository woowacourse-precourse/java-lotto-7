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
            PurchasedPrice purchasedPrice = getPurchasedPrice();
            Lottos purchasedLottos = generate(purchasedPrice);
            OutputView.printPurchasedLottos(purchasedLottos);

            Lotto winningNumbers = getWinningNumbers();
            BonusNumber bonusNumber = getBonusNumber(winningNumbers);

            printWinningResult(purchasedLottos, winningNumbers, bonusNumber, purchasedPrice);
        } catch (IllegalStateException e) {
            OutputView.printIllegalStateException(e);
            throw e;
        }
        catch (Exception e) { //예상하지 못한 예외가 발생하는 경우 stack trace 를 출력하고 종료합니다.
            e.printStackTrace();
            throw e;
        }
    }

    private PurchasedPrice getPurchasedPrice() {
        while (true) {
            try {
                return new PurchasedPrice(InputView.readPurchasedPrice());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getWinningNumbers() {
        while (true) {
            try {
                return new Lotto(InputView.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                return new BonusNumber(InputView.readBonusNumber(), winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos generate(PurchasedPrice purchasedPrice) {
        PurchasedPrice.validateNotNull(purchasedPrice);
        int lottoCount = purchasedPrice.getPurchasedPrice() / LOTTO_PRICE;
        return lottoService.generateLottos(lottoCount);
    }

    private void printWinningResult(Lottos purchasedLottos, Lotto winningNumbers, BonusNumber bonusNumber, PurchasedPrice purchasedPrice) {
        LottoRanks lottoRanks = lottoService.getResult(purchasedLottos, winningNumbers, bonusNumber);
        OutputView.printResult(lottoRanks, purchasedPrice);
    }

}
