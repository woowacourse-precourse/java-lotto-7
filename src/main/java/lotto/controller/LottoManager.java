package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.BonusNumberView;
import lotto.view.InputView;
import lotto.view.PurchaseView;
import lotto.view.WinningNumbersView;

import java.util.Arrays;
import java.util.List;

public class LottoManager {

    private static final InputView purchaseView = new PurchaseView();
    private static final InputView winningNumberView = new WinningNumbersView();

    public void run() {
        LottoService lottoService;
        int purchaseAmount = 0;
        List<Integer> inputNumbers;
        Lotto winningNumbers;
        InputView bonusNumberView;
        int bonusNumber;

        while (true) {
            try {
                purchaseAmount = Integer.parseInt(purchaseView.read("구입금액을 입력해 주세요."));
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoService = new LottoService(purchaseAmount);
        lottoService.printLottoNumbers();

        while (true) {
            try {
                inputNumbers = Arrays.stream(winningNumberView.read("당첨 번호를 입력해 주세요.").split(","))
                        .map(Integer::parseInt)
                        .toList();
                winningNumbers = new Lotto(inputNumbers);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                bonusNumberView = new BonusNumberView(inputNumbers);
                bonusNumber = Integer.parseInt(bonusNumberView.read("보너스 번호를 입력해 주세요."));
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        lottoService.setWinningNumbers(winningNumbers);
        lottoService.setBonusNumber(bonusNumber);

        lottoService.runLottoSimulation();
        lottoService.printLottoResults();
    }
}
