package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.LottoSystemConstant.*;
import static lotto.constant.SystemMessage.PURCHASE_AMOUNT_INPUT;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public LottoController() {}

    public void execute() {
        int purchaseAmount = inputPurchaseAmount();
        lottoService.purchaseLottos(purchaseAmount);
    }

    private int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT);

        while (true) {
            try {
                String input = Console.readLine();
                int amount = inputTypeConverse(input);
                validateNonNegativeAmount(amount);
                validateNoChangeAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputTypeConverse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_INPUT);
        }
    }

    private void validateNonNegativeAmount(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException(NEGATIVE_PURCHASE_AMOUNT);
        }
    }

    private void validateNoChangeAmount(int amount) {
        int change = amount % LOTTO_PRICE;

        if(change != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT);
        }
    }
}
