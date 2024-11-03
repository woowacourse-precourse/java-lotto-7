package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final int NUMBER_CHECK = 1000;
    private static final String NUMBER_REGEX = ",";

    public int getInputPurchasePrice() {
        String inputPurchasePrice = "";
        while (true) {
            try {
                System.out.println(Message.PURCHASE_PRICE.getMessage());
                inputPurchasePrice = Console.readLine();
                validateNumberModulo(inputPurchasePrice);
                return Integer.parseInt(inputPurchasePrice);
            } catch (NumberFormatException e) {
                System.out.println(Message.INPUT_TYPE_NUMBER_ERROR.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(Message.INPUT_NUMBER_PRICE_PER_LOTTO_ERROR.getMessage());
            }
        }
    }


}
