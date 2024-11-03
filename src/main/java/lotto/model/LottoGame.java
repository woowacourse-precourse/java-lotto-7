package lotto.model;

import lotto.exception.ErrorCode;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private final OutputView outputView;
    private final InputView inputView;

    public LottoGame(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void start() {
        int price = getValidatedPrice();

    }

    public int getValidatedPrice() {
        while (true) {
            String priceInput = inputView.getStrInput();

            try{
                return validatePrice(priceInput);
            }catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int validatePrice(String priceInput) {
        try {
            int price = Integer.parseInt(priceInput);
            if (price < 0) {
                throw new IllegalArgumentException(ErrorCode.INVALID_NEGATIVE_NUMBER.getMessage());
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_AMOUNT_FORMAT.getMessage());
        }
    }
}
