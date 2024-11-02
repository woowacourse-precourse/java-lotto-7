package lotto.util;

import static lotto.Constant.MAX_NUMBER;
import static lotto.Constant.MIN_NUMBER;
import static lotto.Constant.MONEY_UNIT;
import static lotto.Constant.NUMBER_COUNT;
import static lotto.exception.ErrorMessage.BLANK_MONEY;
import static lotto.exception.ErrorMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.ErrorMessage.NOT_DIGIT_FORMAT;
import static lotto.exception.ErrorMessage.NOT_DIVIDED_MONEY;
import static lotto.exception.ErrorMessage.OUT_OF_RANGE_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    public static void validateMoney(String uncheckedMoney) {
        validateIsDigit(uncheckedMoney);
        validateIsMoneyFormat(uncheckedMoney);
    }

    public static void validateLottoNumber(String lottoNumber) {
        validateNumberCount(lottoNumber);
        validateEachIsDigit(lottoNumber);
        validateEachInRange(lottoNumber);
    }

    public static void validateBonusNumber(String bonusNumber) {
        validateIsDigit(bonusNumber);
        validateIsInRange(bonusNumber);
    }

    public static List<Integer> makeLottoNumber(String lottoNumber) {
        String[] splitNumbers = splitAndTrim(lottoNumber);
        List<Integer> result = new ArrayList<>();
        for(String number: splitNumbers) {
            result.add(Integer.valueOf(number));
        }
        return result;
    }
    
    private static void validateIsDigit(String uncheckedInput) {
        if(uncheckedInput.isBlank()){
            throw new IllegalArgumentException(BLANK_MONEY.getMessage());
        }
        for(char c: uncheckedInput.toCharArray()){
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException(NOT_DIGIT_FORMAT.getMessage());
            }
        }
    }

    private static void validateIsMoneyFormat(String uncheckedMoney) {
        int money = Integer.parseInt(uncheckedMoney);
        if(money % MONEY_UNIT != 0){
            throw new IllegalArgumentException(NOT_DIVIDED_MONEY.getMessage());
        }
    }

    private static void validateNumberCount(String lottoNumber) {
        String[] splitNumbers = splitAndTrim(lottoNumber);
        if(splitNumbers.length != NUMBER_COUNT){
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }
    private static void validateEachInRange(String lottoNumber) {
        String[] splitNumbers = splitAndTrim(lottoNumber);
        for (String splitNumber : splitNumbers) {
            validateIsInRange(splitNumber);
        }
    }

    private static void validateEachIsDigit(String lottoNumber) {
        String[] splitNumbers = splitAndTrim(lottoNumber);
        for (String splitNumber : splitNumbers) {
            validateIsDigit(splitNumber);
        }
    }

    private static void validateIsInRange(String bonusNumber) {
        int parsedBonusNumber = Integer.parseInt(bonusNumber);
        if (parsedBonusNumber < MIN_NUMBER || parsedBonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER.getMessage());
        }
    }

    private static String[] splitAndTrim(String lottoNumber) {
        return lottoNumber.split("[,\\s]+");
    }
}
