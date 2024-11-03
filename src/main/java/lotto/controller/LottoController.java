package lotto.controller;

import lotto.io.Input;
import lotto.io.Output;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.service.LottoService;
import lotto.util.Validator;

import java.util.List;
import java.util.stream.IntStream;

public class LottoController {
    private final Output output;
    private final Input input;
    private final Validator validator;
    private final LottoService lottoService;

    public LottoController(Output output, Input input, Validator validator, LottoService lottoService) {
        this.output = output;
        this.input = input;
        this.validator = validator;
        this.lottoService = lottoService;
    }

    public void playLotto() {
        int purchasePrice = handlePurchasePrice();
        int count = handleLottoCount(purchasePrice);
        handleCreatedLottos(count);
        handleWinningNumbers();
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

    private void handleCreatedLottos(int count) {
        Lottos lottos = createLottosWithCount(count);
        output.printLottoNumbers(lottos);
    }

    private Lottos createLottosWithCount(int count) {
        Lottos lottos = new Lottos();
        List<Lotto> lottoList = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(lottoService.pickLottoNumbers()))
                .toList();
        lottoList.forEach(lottos::addLotto);
        return lottos;
    }

    private void handleWinningNumbers() {
        output.printWinningNumbersInputPrompt();
        String winningNumbersInput = input.inputString();

        validateWinningNumbersInput(winningNumbersInput);
    }

    private void validateWinningNumbersInput(String input) {
        try {
            validator.validateEmptyInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            handleWinningNumbers();
        }
    }
}
