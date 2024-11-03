package lotto.application.support;

import static lotto.common.Consts.WINNING_NUMBER_NOT_DUPLICATED_ERROR;
import static lotto.common.Consts.INPUT_MUST_BE_NUMBER;
import static lotto.common.Consts.INPUT_MUST_BE_POSITIVE_NUMBER;
import static lotto.common.Consts.LOTTO_PRICE;
import static lotto.common.Consts.PURCHASE_AMOUNT_1000_UNIT;

import java.util.Arrays;
import java.util.List;
import lotto.common.Errors;

public class LottoInputParser {

    public int parseAmount(String amount){
        try{
            int parsed = Integer.parseInt(amount);
            validate(parsed);

            return parsed;
        } catch (NumberFormatException e) {
            Errors.IllegalArgumentException(INPUT_MUST_BE_NUMBER);
        }
        return -1;
    }

    private void validate(int amount){
        if((amount % LOTTO_PRICE) != 0){
            Errors.IllegalArgumentException(PURCHASE_AMOUNT_1000_UNIT);
        }

        if(amount < 0){
            Errors.IllegalArgumentException(INPUT_MUST_BE_POSITIVE_NUMBER);
        }
    }

    public List<Integer> parseWinningNumber(String winningNumber){
        List<Integer> winningNumbers = winningNumbertoList(winningNumber);
        validateWinningNumber(winningNumbers);
        return winningNumbers;
    }

    private List<Integer> winningNumbertoList(String winningNumber){
        String[] winningNumbers = winningNumber.split(",");

        return Arrays.asList(
                Arrays.stream(winningNumbers)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new));
    }

    private void validateWinningNumber(List<Integer> winningNumbers){
        if(winningNumbers.stream().distinct().count() != winningNumbers.size()){
            Errors.IllegalArgumentException(WINNING_NUMBER_NOT_DUPLICATED_ERROR);
        }
    }
}
