package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    public String getPrice() {
        System.out.println(PRICE_MESSAGE);
        String input = Console.readLine();
        return input.replaceAll(" ", "");
    }

    public void printPrice(String price) {
        System.out.println(price);
    }
}
