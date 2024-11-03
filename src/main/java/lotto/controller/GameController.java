package lotto.controller;

import lotto.NumbersGenerator;
import lotto.domain.Budget;
import lotto.domain.LotteryResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
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
        BigInteger numberOfLotto = readValidBudget().numberOfLotto();
        outputView.printNumberOfLotto(numberOfLotto);

        List<List<Integer>> lottoNumbers = generateNumbers(numberOfLotto);
        outputView.printLottoNumbers(lottoNumbers);

        List<Integer> winningNumbers = readValidWinningNumbers();
        LotteryResult result = createLotteryResult(lottoNumbers, winningNumbers, readValidBonusNumber(winningNumbers));

        outputView.printResult(result.returnCounts(), result.returnRate());
    }

    private List<List<Integer>> generateNumbers(BigInteger numberOfNumbers) {
        return Stream.iterate(BigInteger.ZERO, idx -> idx.compareTo(numberOfNumbers) < 0, idx -> idx.add(BigInteger.ONE))
                .map(idx -> numbersGenerator.generateNumbers(NUMBER_COUNT))
                .collect(Collectors.toList());
    }

    private LotteryResult createLotteryResult(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers, Integer bonusNumber) {
        try {
            return new LotteryResult(lottoNumbers, winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return new LotteryResult(lottoNumbers, winningNumbers, bonusNumber);
        }
    }

    private Budget readValidBudget() {
        return retryUntilValid(() -> {
            String budgetInput = inputView.readBudget();
            InputValidator.validateBudgetInput(budgetInput);
            return new Budget(new BigInteger(budgetInput.strip()));
        });
    }

    private List<Integer> readValidWinningNumbers() {
        return retryUntilValid(() -> {
            String numbersInput = inputView.readWinningNumbers();
            InputValidator.validateWinningNumbers(numbersInput);
            return Arrays.stream(numbersInput.split(SPLITTER)).map(String::strip).map(Integer::parseInt).toList();
        });
    }

    private Integer readValidBonusNumber(List<Integer> winningNumbers) {
        return retryUntilValid(() -> {
            String bonusInput = inputView.readBonusNumber();
            InputValidator.validateBonusNumber(bonusInput, winningNumbers);
            return Integer.parseInt(bonusInput);
        });
    }

    private <T> T retryUntilValid(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return retryUntilValid(supplier);
        }
    }

}
