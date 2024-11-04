package lotto.controller;

import java.util.List;
import lotto.model.Rank;
import lotto.service.LottoService;
import lotto.util.Validator;
import lotto.view.Inputview;
import lotto.view.Outputview;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void run() {
        int money = getPurchaseAmount();
        lottoService.issueLottoTickets(money / 1000);
        Outputview.printLottoTickets(lottoService.getLottoTickets());

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        lottoService.setWinningNumbers(winningNumbers, bonusNumber);

        List<Rank> results = lottoService.calculateResults();
        Outputview.printResults(results);

        double yield = lottoService.calculateYield(money);
        Outputview.printYield(yield);
    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                int money = Inputview.inputMoney();
                Validator.validatePurchaseAmount(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String winningNumbers = Inputview.inputWinningNumbers();
                return lottoService.parseWinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = Inputview.inputBonusNumber();
                Validator.validateBonusNumberDuplication(winningNumbers, bonusNumber);
                Validator.validateLottoNumberRange(List.of(bonusNumber)); // 보너스 번호 범위 확인
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
