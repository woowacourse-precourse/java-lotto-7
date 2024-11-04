package lotto.view.input;

import static lotto.config.LottoConfig.PRICE;
import static lotto.model.domain.Lotto.validate;

import java.util.Arrays;
import java.util.List;
import lotto.config.ErrorMessage;

public class InputValidator {
    //구입 금액 입력 시 정해진 형식이 아니거나 1000으로 나누어 떠어지지 않을 시 에러 발생
    public static int validatePurchaseAmount(String input){
        try{
            int amount = Integer.parseInt(input);
            if(amount < PRICE || amount % PRICE != 0){
                //입력 금액이 정수로 들어왔지만 1000보다 작거나 나누어 떨어지지 않을 때 에러 발생
                throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
            }
            return amount;
        }catch (NumberFormatException e){ //입력 금액이 정수로 들어오지 않았을 때
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static int validateNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateContainBlank(String input){
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CONTAIN_BLANK.getMessage());
        }
    }
    //String을 받아 ,를 List 형식으로 반환하는 메소드
    public static List<Integer> validateWinningNumbers(String input){
        try {
            validateContainBlank(input);
            List<Integer> winningNumbers = Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .sorted()
                    .toList();
            validate(winningNumbers);
            return winningNumbers;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }
}
