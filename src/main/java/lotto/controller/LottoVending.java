package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoStatistics;
import lotto.model.PurchaseAmount;
import lotto.parser.NumberParser;
import lotto.validator.BonusNumberValidator;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoVending {
    public static final String WINNING_NUMBERS_DELIMITER = ",";
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
                String winningNumbersInput = inputView.getWinningNumbers();

                List<String> separatedWinningNumbersInput = List.of(
                    winningNumbersInput.split(WINNING_NUMBERS_DELIMITER));

                List<Integer> winningNumbers = separatedWinningNumbersInput.stream()
                    .map(NumberParser::parseInteger)
                    .collect(Collectors.toList());

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
        outputView.printPurchaseAmountMessage();
        PurchaseAmount amount = getPurchaseAmountUntilValid();
        outputView.printWinningNumbersMessage();
        Lotto winningNumbers = getWinningNumbersUntilValid();
        outputView.printBonusNumberMessage();
        Integer bonusNumber = getBonusNumbersUntilValid(winningNumbers);

        LottoGenerator lottoGenerator = LottoGenerator.generate(amount.getAmount());
        List<Lotto> lottos = lottoGenerator.getLottos();
        outputView.printLottos(lottos);
        LottoStatistics stats = LottoStatistics.create(lottos, winningNumbers, bonusNumber);
        outputView.printLottoResult(stats.getMatchResult());
        float totalEarningsRate = (float) stats.getTotalEarnings() / amount.getBudget() * 100;
        outputView.printTotalEarningsRate(totalEarningsRate);
    }
}
