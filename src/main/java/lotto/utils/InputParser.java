package lotto.utils;

import static lotto.utils.ExceptionConstants.INPUT_IS_NOT_INTEGER;
import static lotto.utils.LottoConfig.LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import lotto.view.InputView;

public class InputParser {
    static InputView inputView = new InputView();

    public static int purchaseNumParse(){
        String input;
        while(true){
            try{
                input=inputView.getCashInput();
                return Integer.parseInt(input) / LOTTO_PRICE.getValue();
            } catch (NumberFormatException e) {
                System.out.println(INPUT_IS_NOT_INTEGER.getExceptionMessage());
            }
        }

    }

    public static List<Integer> lottoNumParse() {
        String input;
        List<Integer> numbers;

        while(true){
            try{
                input=inputView.getWinningNumInput();
                numbers = Arrays.stream(input.replace(" ", "").split(","))
                        .map(Integer::parseInt)
                        .toList();
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println(INPUT_IS_NOT_INTEGER.getExceptionMessage());
            }
        }

    }

    public static Integer bonusNumParse(String input) {
        while(true){
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(INPUT_IS_NOT_INTEGER.getExceptionMessage());
            }
        }
    }
}
