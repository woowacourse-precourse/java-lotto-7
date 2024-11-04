package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.parser.NumberParser;
import lotto.validator.BonusNumberValidator;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoVending {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoVending(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private PurchaseAmount getPurchaseAmountUntilValid() {
        while (true) {
            try {
                String moneyInput = inputView.getMoney();

                Long money = NumberParser.parseLong(moneyInput);
                return PurchaseAmount.of(money);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private Lotto getWinningNumbersUntilValid() {
        while (true) {
            try {
                List<Integer> winningNumbers = new ArrayList<>();

                String winningNumbersInput = inputView.getWinningNumbers();

                for (String winningNumberInput : winningNumbersInput.split(",")) {
                    Integer winningNumber = NumberParser.parseInteger(winningNumberInput);
                    winningNumbers.add(winningNumber);
                }
                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private Integer getBonusNumbersUntilValid(Lotto winningNumbers) {
        while (true) {
            try {
                String bonusNumberInput = inputView.getBonusNumber();
                Integer bonusNumber = NumberParser.parseInteger(bonusNumberInput);
                Validator validator = new BonusNumberValidator(winningNumbers, bonusNumber);
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
        PurchaseAmount amount = getPurchaseAmountUntilValid();

        // 당첨 번호 입력, 검증 및 파싱
        outputView.printWinningNumbersMessage();
        Lotto winningNumbers = getWinningNumbersUntilValid();

        //보너스 번호 입력
        outputView.printBonusNumberMessage();
        Integer bonusNumber = getBonusNumbersUntilValid(winningNumbers);

        // 로또 발행
        Lottos lottos = Lottos.create(amount.get());
        outputView.printLottos(lottos.getLottos());

        // 당첨 통계
        int matchedThree = 0;
        int matchedFour = 0;
        int matchedFive = 0;
        int matchedFiveAndBonus = 0;
        int matchedSix = 0;
        for (Lotto lotto : lottos.getLottos()) {
            long matchedCount = lotto.getMatchNumbersCount(winningNumbers);
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
        float totalEarningsRate = (float) totalEarnings / (amount.get() * 1000) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", totalEarningsRate) + "%입니다.");
    }
}
