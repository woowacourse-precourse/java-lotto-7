package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String SYSTEM_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    int parsedPrice;
    public void getPriceInput() {
        System.out.println(SYSTEM_PRICE_INPUT_MESSAGE);
        String priceInput = Console.readLine();
        makePriceInputInteger(priceInput);
        validate(parsedPrice);
    }

    private void makePriceInputInteger(String priceInput) {
        parsedPrice = Integer.parseInt(priceInput);
    }

    private void validate(int parsedPrice) {
        if (parsedPrice % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
    }
}
