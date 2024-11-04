package domain;

import message.ErrorMessage;

import java.util.List;

public class Validate {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int LOTTO_AMOUNT = 1000;

    public void validateIsCountSix(List<Integer> numbers) {

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NUM_OF_NUMBERS.getErrorMessage());
        }
    }

    public void validateIsInRange(List<Integer> numbers) {

        if (numbers.stream().anyMatch(num -> num < MIN_NUM || num > MAX_NUM)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getErrorMessage());
        }
    }

    public void validateIsDuplicate(List<Integer> numbers) {

        if(numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    public void validateContainsLetters(String number) {

        int amount;

        try {

            amount = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.CONTAINS_LETTER.getErrorMessage());
        }
    }

    public void validatePurchaseAmount(String number) {

        int amount = Integer.parseInt(number);
        if(amount % LOTTO_AMOUNT != 0){

            throw new IllegalArgumentException(ErrorMessage.CANNOT_BUY_LOTTO.getErrorMessage());
        }
    }

    public void validateIsBonusNumberInRange(int number) {

        if(number < MIN_NUM || number > MAX_NUM) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getErrorMessage());
        }
    }

    public void validateBonusNumAndWinningNum(List<Integer> numbers, int num) {

        if (numbers.contains(num)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_BONUS.getErrorMessage());
        }
    }

    public void validateMoney(int money) {
        if(money <= 0){
            throw new IllegalArgumentException(ErrorMessage.LOWER_THAN_ZERO.getErrorMessage());
        }
    }
}
