package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.LotteryBuyer;
import lotto.domain.PrizeTier;
import lotto.service.LottoService;
import lotto.util.CommonUtil;
import lotto.validation.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final Validator validator;

    public LottoController(LottoService lottoService, Validator validator) {
        this.lottoService = lottoService;
        this.validator = validator;
    }

    public void run() {
        Integer purchaseAmount = getValidatedPurchaseAmount();
        LotteryBuyer lotteryBuyer = lottoService.buyLotto(purchaseAmount);
        OutputView.printLottery(lotteryBuyer);

        List<Integer> winningNumbers = getValidatedWinningNumbers();
        Integer bonusNumber = getValidatedBonusNumber(winningNumbers);

        processLottoResults(purchaseAmount, lotteryBuyer, winningNumbers, bonusNumber);
    }

    private Integer getValidatedPurchaseAmount() {
        while (true) {
            try {
                String inputPurchaseAmount = InputView.getPurchaseAmount();
                Integer purchaseAmount = CommonUtil.stringToInteger(inputPurchaseAmount);
                validator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> getValidatedWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = InputView.getWinningNumbers();
                List<Integer> winningNumbers = CommonUtil.splitToList(inputWinningNumbers);
                validator.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Integer getValidatedBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String inputBonusNumber = InputView.getBonusNumber();
                Integer bonusNumber = CommonUtil.stringToInteger(inputBonusNumber);
                validator.validateBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void processLottoResults(Integer purchaseAmount, LotteryBuyer lotteryBuyer,
                                     List<Integer> winningNumbers, Integer bonusNumber) {
        Map<PrizeTier, Long> prizeCounts = lottoService.compareLottoToWinningNumbers(lotteryBuyer, winningNumbers,
                bonusNumber);
        double profitRate = lottoService.calculateProfitRate(prizeCounts, purchaseAmount);

        OutputView.printWinningStatistics(prizeCounts);
        OutputView.printProfitRate(profitRate);
    }
}
