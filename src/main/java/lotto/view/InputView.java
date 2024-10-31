package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import lotto.common.ErrorMessage;
import lotto.dto.InputMoneyDTO;

public class InputView {

    public static final InputView INSTANCE = new InputView();
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String REGEXP_NUMBER = "^[1-9][0-9]*$";
    private InputView(){}
    public InputMoneyDTO readMoney(){
        print(INPUT_MONEY_MESSAGE);
        String input = Console.readLine();
        validateNumberFormat(input);
        return InputMoneyDTO.from(Integer.valueOf(input));
    }

    private static void validateNumberFormat(String input) {
        if(!Pattern.matches(REGEXP_NUMBER, input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_IS_DIGIT.getMessage());
        }
    }

    private void print(String message){
        System.out.println(message);
    }
}
