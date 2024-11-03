package lotto.controller;

import lotto.io.Input;
import lotto.io.Output;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.RankCount;
import lotto.service.LottoService;
import lotto.util.Constants;
import lotto.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LottoController {
    private final Output output;
    private final Input input;
    private final Validator validator;
    private final LottoService lottoService;

    private Lotto lottoWinningNumbers;
    private Integer lottoBonusNumber;

    public LottoController(Output output, Input input, Validator validator, LottoService lottoService) {
        this.output = output;
        this.input = input;
        this.validator = validator;
        this.lottoService = lottoService;
    }

    public void playLotto() {
        int purchasePrice = handlePurchasePrice();
        int count = handleLottoCount(purchasePrice);
        Lottos lottos = handleCreatedLottos(count);
        lottoWinningNumbers = handleWinningNumbers();
        lottoBonusNumber = handleBonusNumber();
        List<RankCount> winningStatistics = handleWinningStatistics(lottos);
    }

    private int handlePurchasePrice() {
        output.printPurchasePriceInputPrompt();
        String purchasePrice = input.inputString();

        validatePurchasePriceInput(purchasePrice);

        return Integer.parseInt(purchasePrice);
    }

    private void validatePurchasePriceInput(String input) {
        try {
            validator.validateEmptyInput(input);
            validator.validateNonNumber(input);
            validator.validatePositiveNumber(input);
            validator.validateDivisibleByThousand(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            handlePurchasePrice();
        }
    }

    private int handleLottoCount(int purchasePrice) {
        int count = lottoService.calculateLottoCount(purchasePrice);
        output.printLottoCount(count);
        return count;
    }

    private Lottos handleCreatedLottos(int count) {
        Lottos lottos = createLottosWithCount(count);
        output.printLottoNumbers(lottos);
        return lottos;
    }

    private Lottos createLottosWithCount(int count) {
        Lottos lottos = new Lottos();
        List<Lotto> lottoList = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(lottoService.pickLottoNumbers()))
                .toList();
        lottoList.forEach(lottos::addLotto);
        return lottos;
    }

    private Lotto handleWinningNumbers() {
        output.printWinningNumbersInputPrompt();
        String winningNumbersInput = input.inputString();

        List<String> winningNumbersSplit = validateWinningNumbersInput(winningNumbersInput);
        List<Integer> validWinningNumbers = winningNumbersSplit.stream()
                .map(Integer::parseInt)
                .toList();

        return new Lotto(validWinningNumbers);
    }

    private List<String> validateWinningNumbersInput(String input) {
        List<String> splitInputByComma = new ArrayList<>();
        try {
            validator.validateEmptyInput(input);

            splitInputByComma = Arrays.asList(input.split(Constants.COMMA.getMessage()));
            validateWinningNumbers(splitInputByComma);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            handleWinningNumbers();
        }
        return splitInputByComma;
    }

    private void validateWinningNumbers(List<String> winningNumbers) {
        for (String number : winningNumbers) {
            validator.validateNonNumber(number);
            validator.validatePositiveNumber(number);
            validator.validateNumberRange(number);
        }
    }

    private Integer handleBonusNumber() {
        output.printBonusNumberInputPrompt();
        String bonusNumber = input.inputString();

        validateBonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String input) {
        try {
            validator.validateEmptyInput(input);
            validator.validateNonNumber(input);
            validator.validatePositiveNumber(input);
            validator.validateNumberRange(input);
            validator.validateWinningNumbersContainBonus(input, lottoWinningNumbers.getNumbers());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            handleBonusNumber();
        }
    }

    private List<RankCount> handleWinningStatistics(Lottos lottos) {
        List<RankCount> winningStatistics = lottoService.calculateWinningStatistics(lottos, lottoWinningNumbers, lottoBonusNumber);
        return winningStatistics;
    }
}
