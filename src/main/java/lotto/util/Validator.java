package lotto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.*;

public class Validator {

    private static int THRESHOLD_PRICE = 1000;
    private static int WINNING_NUMBER_COUNT = 6;
    private static int MIN_WINNING_NUMBER = 1;
    private static int MAX_WINNING_NUMBER = 45;

    public boolean validatePrice(String price) {
        try{
            checkNumberType(price);
            checkPriceThreshold(price);
            checkPriceDivisible(price);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void checkNumberType(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(PRICE_TYPE_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkPriceThreshold(String input) {
        int price = Integer.parseInt(input);
        if (price < THRESHOLD_PRICE) {
            System.out.println(PRICE_TOO_LOW_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkPriceDivisible(String input) {
        int price = Integer.parseInt(input);
        if (price % THRESHOLD_PRICE != 0) {
            System.out.println(PRICE_NOT_DIVISIBLE_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public boolean validateWinningNumber(String input) {
        try {
            checkWinningNumberLength(input);
            checkWinningNumbers(input);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    private void checkWinningNumberLength(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != WINNING_NUMBER_COUNT) {
            System.out.println(WINNING_NUMBER_COUNT_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void checkWinningNumbers(String input) {
        String[] numbers = input.split(",");
        Set<String> winningNumbers = new HashSet<>();
        for (String number : numbers) {
            checkNumberType(number);
            checkWinningNumberSize(number);
            if ( winningNumbers.contains(number) ) {
                System.out.println(WINNING_NUMBER_DUPLICATE_ERROR.getMessage());
                throw new IllegalArgumentException();
            }
            winningNumbers.add(number);
        }
    }

    private void checkWinningNumberSize(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_WINNING_NUMBER || number > MAX_WINNING_NUMBER) {
            System.out.println(WINNING_NUMBER_SIZE_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public boolean validateBonusNumber(String input, List<Integer> winningNumbers) {
        try{
            checkNumberType(input);
            checkBonusNumber(input, winningNumbers);
        } catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    private void checkBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(input);
        for (Integer number : winningNumbers) {
            if (bonusNumber == number) {
                System.out.println(BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }
}
