package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.parser.NumberParser;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoNumbersValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoVending {
    private final InputView inputView;
    private final OutputView outputView;
    private Validator validator;

    public LottoVending(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private Long getPurchaseAmountUntilValid() {
        while (true) {
            try {
                String purchaseAmountInput = inputView.getPurchaseAmount();

                Long purchaseAmount = NumberParser.parseLong(purchaseAmountInput);
                validator = new PurchaseAmountValidator(purchaseAmount);
                validator.validate();
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private List<Integer> getWinningNumbersUntilValid() {
        while (true) {
            try {
                List<Integer> winningNumbers = new ArrayList<>();

                String winningNumbersInput = inputView.getWinningNumbers();

                for (String winningNumberInput : winningNumbersInput.split(",")) {
                    Integer winningNumber = NumberParser.parseInteger(winningNumberInput);
                    winningNumbers.add(winningNumber);
                }
                validator = new LottoNumbersValidator(winningNumbers);
                validator.validate();
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private Integer getBonusNumbersUntilValid(List<Integer> winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = inputView.getBonusNumber();
                Integer bonusNumber = NumberParser.parseInteger(bonusNumberInput);
                validator = new BonusNumberValidator(winningNumbers, bonusNumber);
                validator.validate();
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    public void take() {
        // 구입 금액 입력, 검증 및 파싱
        outputView.printPurchaseAmountMessage();
        Long purchaseAmount = getPurchaseAmountUntilValid();

        // 당첨 번호 입력, 검증 및 파싱
        outputView.printWinningNumbersMessage();
        List<Integer> winningNumbers = getWinningNumbersUntilValid();

        //보너스 번호 입력
        outputView.printBonusNumberMessage();
        Integer bonusNumber = getBonusNumbersUntilValid(winningNumbers);

        // 로또 발행
        int amount = (int) (purchaseAmount / 1000);
        Lottos lottos = Lottos.create(amount);
        outputView.printLottos(lottos.getLottos());

        // 당첨 통계
        int matchedThree = 0;
        int matchedFour = 0;
        int matchedFive = 0;
        int matchedFiveAndBonus = 0;
        int matchedSix = 0;
        for (Lotto lotto : lottos.getLottos()) {
            int matchedCount = lotto.getMatchedNumbers(winningNumbers).size();
            if (matchedCount == 3) {
                matchedThree++;
            }
            if (matchedCount == 4) {
                matchedFour++;
            }
            if (matchedCount == 5) {
                if (lotto.isNumbersContains(bonusNumber)) {
                    matchedFiveAndBonus++;
                } else {
                    matchedFive++;
                }
            }
            if (matchedCount == 6) {
                matchedSix++;
            }
        }
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + matchedThree + "개");
        System.out.println("4개 일치 (50,000원) - " + matchedFour + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchedFive + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchedFiveAndBonus + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchedSix + "개");
        int totalEarnings =
            5000 * matchedThree + 50000 * matchedFour + 1500000 * matchedFive + 30000000 * matchedFiveAndBonus
                + 2000000000 * matchedSix;
        float totalEarningsRate = (float) totalEarnings / purchaseAmount * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", totalEarningsRate) + "%입니다.");
    }
}
