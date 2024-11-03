package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;
import lotto.validator.IntegerInputValidator;
import lotto.validator.ListInputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {


    private static final String INPUT_PURCHASE = "구입 금액을 입력해 주세요";
    private static final String INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static InputValidator<Integer> numberValidator = new IntegerInputValidator();
    private static InputValidator<List<Integer>> lottoValidator = new ListInputValidator();;
    public static int getPurchasePrice(){
        System.out.println(INPUT_PURCHASE);
        return numberValidator.validate();
    }

    public static int getBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return numberValidator.validate();
    }
    public static List<Integer> getLotto(){
        System.out.println(INPUT_WIN_NUMBERS);
        return lottoValidator.validate();
    }


}
