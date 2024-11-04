package lotto.application.support;

import static lotto.common.Consts.CLASS_CAST_NOT_ACCEPTABLE_ERROR;
import static lotto.common.Consts.LOTTO_NUMBER_MUST_BE_BETWEEN_ONE_FORTY_FIVE_ERROR;
import static lotto.common.Consts.WINNING_NUMBER_NOT_DUPLICATED_ERROR;
import static lotto.common.Consts.INPUT_MUST_BE_NUMBER_ERROR;
import static lotto.common.Consts.INPUT_MUST_BE_POSITIVE_NUMBER_ERROR;
import static lotto.common.Consts.LOTTO_PRICE;
import static lotto.common.Consts.PURCHASE_AMOUNT_1000_UNIT_ERROR;
import static lotto.common.Consts.WINNING_NUMBER_SIZE_MUST_BE_6_ERROR;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.common.Errors;

public class LottoInputParser {

    private Map<String, Object> cache = new HashMap<>();

    public int parseAmount(String amount){
        try{
            int parsed = Integer.parseInt(amount);
            validateAmount(parsed);

            registerInCache("amount", parsed);

            return parsed;
        } catch (NumberFormatException e) {
            Errors.IllegalArgumentException(INPUT_MUST_BE_NUMBER_ERROR);
        }
        return -1;
    }

    private void validateAmount(int amount){
        if((amount % LOTTO_PRICE) != 0){
            Errors.IllegalArgumentException(PURCHASE_AMOUNT_1000_UNIT_ERROR);
        }

        if(amount < 0){
            Errors.IllegalArgumentException(INPUT_MUST_BE_POSITIVE_NUMBER_ERROR);
        }
    }

    public List<Integer> parseWinningNumber(String winningNumber){
        try {
            List<Integer> winningNumbers = winningNumbertoList(winningNumber);
            validateWinningNumber(winningNumbers);

            registerInCache("winningNumber", winningNumbers);

            return winningNumbers;
        } catch (IllegalArgumentException e){
            return Collections.emptyList();
        }
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

        if(winningNumbers.size()!=6){
            Errors.IllegalArgumentException(WINNING_NUMBER_SIZE_MUST_BE_6_ERROR);
        }
    }

    public int parseBonusNumber(String bonusNumber){
        int parsed;
        try{
            parsed = Integer.parseInt(bonusNumber);
            validateBonusNumber(parsed);

            registerInCache("bonusNumber", parsed);

            return parsed;
        } catch (NumberFormatException e) {
            Errors.IllegalArgumentException(INPUT_MUST_BE_NUMBER_ERROR);
        }
        return -1;
    }

    private void validateBonusNumber(int bonusNumber){
        if(bonusNumber < 0 || bonusNumber > 45){
            Errors.IllegalArgumentException(LOTTO_NUMBER_MUST_BE_BETWEEN_ONE_FORTY_FIVE_ERROR);
        }

        if(!isListInstance("winningNumber")){
            Errors.ClassCastException(CLASS_CAST_NOT_ACCEPTABLE_ERROR);
        }

        if(((List<Integer>)cache.get("winningNumber")).contains(bonusNumber)){
            Errors.IllegalArgumentException(WINNING_NUMBER_NOT_DUPLICATED_ERROR);
        }
    }

    private void registerInCache(String key, Object value){
        this.cache.put(key, value);
    }

    private boolean isListInstance(String key){
        return cache.get(key) instanceof List<?>;
    }

}
