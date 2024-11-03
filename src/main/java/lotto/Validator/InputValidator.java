package lotto.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static lotto.Constant.LottoRule.*;
import static lotto.Exception.CommonErrorCode.*;
import static lotto.Exception.LottoNumber.LottoNumberInputErrorCode.INCORRECT_DELIMITER;

public class InputValidator{
    private static final String None = "";
    private static final String Delimiter = ",";
    private static final String Regexp = "^[0-9" + Delimiter + "]+$";

    public int validateCashByInput(String input) {
        isNull(input);
        int cash = validateConvertToInt(input, CASH);
        return cash;
    }

    public List<Integer> validateLottNumByUser (String input) {
        isNull(input);
        validateDelimiter(input);
        return validateFormatting(input);
    }

    public int validateBonusNumByUser(String input){
        isNull(input);
        return validateConvertToInt(input, BONUS_NUMBER);
    }

    private void validateDelimiter(String input){
        if (!input.matches(Regexp)) {
            throw new IllegalArgumentException(INCORRECT_DELIMITER.getArgsErrorMessage(Delimiter));
        }
    }

    private List<Integer> validateFormatting (String input) {
        List<Integer> lottoByUser = new ArrayList<>(LOTTO_COUNT);
        StringTokenizer st = new StringTokenizer(input, Delimiter);
        while (st.hasMoreTokens()) {
            int num = validateConvertToInt(st.nextToken(), LOTTO_NUMBER);
            lottoByUser.add(num);
        }

        return lottoByUser;
    }

    private void isNull(String input) {
        if(input==null || input.equals(None)) {
            throw new IllegalArgumentException(NOT_NULL.getErrorMessage());
        }
    }

    private int validateConvertToInt(String input, String type) {
        int number;
        try{
            number = Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new NumberFormatException(NOT_NUMBER.getArgsErrorMessage(type));
        }

        return number;
    }


}
