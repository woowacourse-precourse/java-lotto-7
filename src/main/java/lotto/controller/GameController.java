package lotto.controller;

import lotto.NumbersGenerator;
import lotto.domain.Budget;
import lotto.domain.LotteryVendor;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;
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

    public void run() {
        BigInteger numberOfLotto = new Budget(readValidBudget()).numberOfLotto();
        outputView.printNumberOfLotto(numberOfLotto);
        List<List<Integer>> lottoNumbers = generateNumbers(numberOfLotto);
        outputView.printNumbersCollections(lottoNumbers);
        List<Integer> winningNumbers = readWinningNumbers();
        Integer bonusNumber = readBonusNumber();
        LotteryVendor vendor = new LotteryVendor(lottoNumbers, winningNumbers, bonusNumber);
        Result result = vendor.calculateResult();
        outputView.printResult(result.returnCounts(), result.returnRate());
    }

    private List<List<Integer>> generateNumbers(BigInteger numberOfNumbers) {
        return Stream.iterate(BigInteger.ZERO, idx -> idx.compareTo(numberOfNumbers) < 0, idx -> idx.add(BigInteger.ONE))
                .map(idx -> numbersGenerator.generateNumbers(NUMBER_COUNT))
                .collect(Collectors.toList());
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

    private List<Integer> readWinningNumbers() {
        String numbersInput = inputView.readWinningNumbers();
        try {
            InputValidator.validateWinningNumbers(numbersInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return readWinningNumbers();
        }
        return Arrays.stream(numbersInput.split(SPLITTER)).map(Integer::parseInt).toList();
    }

    private Integer readBonusNumber() {
        String bonusInput = inputView.readBonusNumber();
        try {
            InputValidator.validateNumberInput(bonusInput);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return readBonusNumber();
        }
        return Integer.parseInt(bonusInput);
    }

}
