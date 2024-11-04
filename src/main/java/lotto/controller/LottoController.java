package lotto.controller;

import lotto.model.Lotto;
import lotto.model.ResultCalculator;
import lotto.model.WinningNumbers;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.Constants.LOTTO_PRICE;
import static lotto.constants.ErrorStringConstants.*;

public class LottoController {
    private static final String INPUT_DELIMITER = ",";
    private final PurchaseAmountValidator purchaseAmountValidator;
    private final WinningNumberValidator winningNumberValidator;
    private ResultCalculator resultCalculator;

    public LottoController(PurchaseAmountValidator purchaseAmountValidator,
                           WinningNumberValidator winningNumberValidator,
                           ResultCalculator resultCalculator) {
        this.purchaseAmountValidator = purchaseAmountValidator;
        this.winningNumberValidator = winningNumberValidator;
        this.resultCalculator = resultCalculator;
    }

    public void start() {
        // 구입 금액
        int purchaseAmount = receivePurchaseInput();

        // 로또 출력
        List<Lotto> lottos = new ArrayList<>();
        generateLottos(lottos, purchaseAmount / LOTTO_PRICE.getValue());
        OutputView.printLottoNumbers(lottos);

        // 당첨 번호와 보너스 번호 입력
        List<Integer> winningNumbers = receiveWinningNumbers();
        int bonusNumber = receiveBonusNumber(winningNumbers);

        // 등수 계산
        WinningNumbers winningLotto = new WinningNumbers(new Lotto(winningNumbers), bonusNumber);
        calculateResults(lottos, winningLotto);

        // 등수 출력
        OutputView.printStatistics(resultCalculator.getRankCount());
        OutputView.printProfitRate(resultCalculator.calculateProfitRate(purchaseAmount));
    }

    // 구입 금액 입력
    private int receivePurchaseInput() {
        while (true) {
            try {
                int purchaseAmount = Integer.parseInt(InputView.getPurchaseAmount());
                purchaseAmountValidator.validatePurchaseAmount(purchaseAmount);
                return purchaseAmount;
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_ERROR_MESSAGE.getValue());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 당첨 번호 입력
    private List<Integer> receiveWinningNumbers() {
        while (true) {
            try {
                String[] inputNumbers = InputView.getWinningNumbers().split(INPUT_DELIMITER);
                List<Integer> winningNumbers = new ArrayList<>();
                for (String inputNumber : inputNumbers) {
                    winningNumbers.add(Integer.parseInt(inputNumber.trim()));
                }
                winningNumberValidator.validateWinningNumber(winningNumbers);
                return winningNumbers;
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_ERROR_MESSAGE.getValue());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 보너스 번호 입력
    private int receiveBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(InputView.getBonusNumber());
                winningNumberValidator.validateBonusNumber(bonusNumber);
                winningNumberValidator.validateNotDuplication(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_ERROR_MESSAGE.getValue());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Lotto> generateLottos(List<Lotto> lottos, int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
        return lottos;
    }

    private void calculateResults(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            int rank = winningNumbers.calculateRank(lotto);
            resultCalculator.recordRank(rank);
        }
    }
}
