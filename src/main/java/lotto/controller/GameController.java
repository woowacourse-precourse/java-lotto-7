package lotto.controller;

import lotto.NumbersGenerator;
import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.controller.InputValidator.SPLITTER;
import static lotto.domain.Lotto.NUMBER_COUNT;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumbersGenerator numbersGenerator;

    public GameController(InputView inputView, OutputView outputView, NumbersGenerator numbersGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numbersGenerator = numbersGenerator;
    }

    // todo: 관심사 분리하기
    public void run() {
        Budget budget = new Budget(readValidBudget());
        BigInteger numberOfLotto = budget.numberOfLotto();
        outputView.printNumberOfLotto(numberOfLotto);
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (BigInteger idx = BigInteger.ZERO; idx.compareTo(numberOfLotto) < 0; idx = idx.add(BigInteger.ONE)) {
            lottoNumbers.add(numbersGenerator.generate(NUMBER_COUNT));
        }
        outputView.printNumbersCollections(lottoNumbers);
        WinningNumber winningNumber = new WinningNumber(getWinningNumbers(), getBonusNumber());
        for (List<Integer> numbers : lottoNumbers) {
            Lotto lotto = new Lotto(numbers);
            Rank rank = lotto.countRank(winningNumber.getNumbers(), winningNumber.getBonusNumber());
        }
    }

    private BigInteger readValidBudget() {
        String budgetInput = inputView.readBudget();
        try {
            InputValidator.validateBudgetInput(budgetInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return readValidBudget();
        }
        return new BigInteger(budgetInput);
    }

    private List<Integer> getWinningNumbers() {
        String numbersInput = inputView.readWinningNumbers();
        try {
            InputValidator.validateWinningNumbers(numbersInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getWinningNumbers();
        }
        return Arrays.stream(numbersInput.split(SPLITTER)).map(Integer::parseInt).toList();
    }

    private Integer getBonusNumber() {
        String bonusInput = inputView.readBonusNumber();
        try {
            InputValidator.validateNumberInput(bonusInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getBonusNumber();
        }
        return Integer.parseInt(bonusInput);
    }

}
