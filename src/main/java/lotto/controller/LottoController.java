package lotto.controller;

import lotto.io.Input;
import lotto.io.Output;
import lotto.service.LottoService;
import lotto.util.Validator;

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
}
