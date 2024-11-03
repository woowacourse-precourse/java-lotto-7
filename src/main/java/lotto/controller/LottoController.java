package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final String INPUT_NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String PURCHASE_AMOUNT_ERROR_MESSAGE = "[ERROR] 구입 금액은 %d원 단위여야 합니다.";
    private static final Integer LOTTO_PURCHASE_COST = 1000;

    public void run() {
        Integer lottoCount = buyLotto();
    }

    private Integer buyLotto() {
        Integer totalCost = getUserPurchaseCost();
        return getLottoAmount(totalCost);
    }

    private Integer getLottoAmount(Integer cost) {
        if (cost % LOTTO_PURCHASE_COST != 0) {
            throw new IllegalArgumentException(String.format(PURCHASE_AMOUNT_ERROR_MESSAGE, LOTTO_PURCHASE_COST));
        }

        return cost / LOTTO_PURCHASE_COST;
    }

    private Integer getUserPurchaseCost() {
        OutputView.getInstance().printPurchaseInput();
        try{
            return Integer.parseInt(InputView.getInstance().readUserInput());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR_MESSAGE);
        }
    }


}
