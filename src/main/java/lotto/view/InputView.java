package lotto.view;

import static lotto.constant.LottoPrintConstant.ERROR;
import static lotto.constant.LottoPrintConstant.ERROR_WINNINGNUMBER_EMPTY;
import static lotto.constant.LottoPrintConstant.INPUT_BONUS;
import static lotto.constant.LottoPrintConstant.INPUT_PRICE;
import static lotto.constant.LottoPrintConstant.INPUT_WINNING;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Consumer;
import lotto.controller.LottoController;
import lotto.valuate.BonusNumberValidate;
import lotto.valuate.PriceValidate;

public class InputView {

    public LottoController controller;

    public InputView() {
        controller = new LottoController();
    }

    private void inputWithRetry(String message, Consumer<String> consumer) {
        while (true) {
            System.out.println(message);
            try {
                String input = Console.readLine().trim();
                consumer.accept(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
                System.out.println("");
            }
        }
        System.out.println("");
    }

    public void inputPrice() {
        inputWithRetry(INPUT_PRICE, input -> {
            PriceValidate.isValidNumber(input);
            int price = Integer.parseInt(input);
            controller.createLottoNumber(price);
        });
    }

    public void inputNumber() {
        inputWithRetry(INPUT_WINNING, input -> {
            if(input.split(" ").length > 1){
                throw new IllegalArgumentException(ERROR_WINNINGNUMBER_EMPTY);
            }
            controller.createWinningNumber(input.split(","));
        });
    }

    public void inputBonusNumber() {
        inputWithRetry(INPUT_BONUS, input -> {
            BonusNumberValidate.isValidNumber(input);
            int price = Integer.parseInt(input);
            controller.createBonusNumber(price);
        });
    }
}
