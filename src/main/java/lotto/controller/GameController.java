package lotto.controller;

import lotto.NumbersGenerator;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<List<Integer>> lottoNumbers = Stream.iterate(BigInteger.ZERO, idx -> idx.compareTo(numberOfLotto) < 0, idx -> idx.add(BigInteger.ONE))
                .map(idx -> numbersGenerator.generateNumbers(NUMBER_COUNT))
                .collect(Collectors.toList());
        outputView.printNumbersCollections(lottoNumbers);
        WinningNumber winningNumber = new WinningNumber(getWinningNumbers(), getBonusNumber());
        List<Rank> results = new ArrayList<>();
        for (List<Integer> numbers : lottoNumbers) {
            Lotto lotto = new Lotto(numbers);
            results.add(lotto.countRank(winningNumber.getNumbers(), winningNumber.getBonusNumber()));
        }
        Result result = new Result(results);
        outputView.printResult(result.returnCounts(), result.returnRate(budget.value()));
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
