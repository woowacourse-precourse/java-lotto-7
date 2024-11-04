package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;

public class InputView {
    private static InputView instance;
    private static final String PRICE_INPUT_INFO = "구입금액을 입력해 주세요.";

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }

        return instance;
    }

    public int readPurchasePrice() {
        while (true) {
            try {
                System.out.println(PRICE_INPUT_INFO);
                String inputPrice = Console.readLine();
                int price = parsePrice(inputPrice);
                validatePrice(price);

                return price;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

    }

    private int parsePrice(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.PARSING_ERROR.getMessage());
        }
    }

    private void validatePrice(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException(ErrorMessage.UNDER_UNIT_ERROR.getMessage());
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.UNITS_ERROR.getMessage());
        }
    }
}
