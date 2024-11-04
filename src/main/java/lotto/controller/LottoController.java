package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import lotto.domain.LottoResult;
import lotto.domain.Numbers;
import lotto.domain.Number;
import lotto.domain.Price;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService;
    Price purchasePrice;
    Numbers winNumbers;
    Number bonusNumber;

    public LottoController() {
        lottoService = new LottoService(new ArrayList<>(), new LottoResult());
    }

    public void run() {
        purchase();
        winNumbersInfo();
        bonusNumberInfo();
        Console.close();
        result();
    }

    private void purchase() {
        while (true) {
            try {
                purchasePrice = lottoService.getPurchasePrice(InputView.inputPurchasePrice());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        OutputView.printPurchasedLottoAmount(purchasePrice.getLottoAmount());

        lottoService.buyLotto(purchasePrice);

        OutputView.printPurchasedLottoNumbers(lottoService.getPurchasedLottos());
    }

    private void winNumbersInfo() {
        while (true) {
            try {
                winNumbers = lottoService.getWinNumbers(InputView.inputWinNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void bonusNumberInfo() {
        while (true) {
            try {
                bonusNumber = lottoService.getBonusNumber(winNumbers, InputView.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void result() {
        lottoService.calculateLottoResult(winNumbers, bonusNumber);

        OutputView.printWinStatistics();

        lottoService.getLottoResult().forEach((result, count) -> {
            OutputView.printWinStatisticsDetail(result.getMessage(), count);
        });

        OutputView.printProfitRate(lottoService.getProfitRate(purchasePrice));
    }
}
