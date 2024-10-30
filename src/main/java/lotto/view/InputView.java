package lotto.view;

import camp.nextstep.edu.missionutils.Console;
public class InputView {
    private static final int MONEY = 1000;
    private static InputView instance;
    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }
    public Integer inputPrice() {
        String price = Console.readLine();
        return dividePrice(price);
    }
    private Integer dividePrice(String price) {
        return Integer.parseInt(price)/MONEY;
    }
}
