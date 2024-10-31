package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {
    private final static String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String QUANTITY_MESSAGE = "개를 구매했습니다.";

    public String getPrice() {
        System.out.println(PRICE_MESSAGE);
        String input = Console.readLine();
        return input.replaceAll(" ", "");
    }

    public void printPrice(int price) {
        System.out.println(price);
    }

    public void printLottoQuantity(int quantity) {
        System.out.println(quantity + QUANTITY_MESSAGE);
    }

    public void printLottos(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
