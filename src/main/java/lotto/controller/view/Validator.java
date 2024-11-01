package lotto.controller.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.controller.Policy;
import lotto.exception.ExceptionMessage;

public class Validator {
    private final Policy policy;

    private Validator(Policy policy) {
        this.policy = policy;
    }

    public static Validator newInstance(Policy policy){
        return new Validator(policy);
    }

    public void validateAmountInput(String input){
        this.validateNumber(input);
        int purchasedAmount = Integer.parseInt(input);
        this.validateZeroAmount(purchasedAmount);
        this.validatePositive(purchasedAmount);
        this.validatePurchasedAmount(purchasedAmount);

    }
    private void validateNumber(String input){
        String integerRegex = policy.getIntegerRegex();
        if(!input.matches(integerRegex)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() +
                    ExceptionMessage.INPUT_NUMBER_EXCEPTION.getMessage());
        }
    }
    private void validateZeroAmount(int input){
        if(input==policy.getZero()){
            throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() +
                    ExceptionMessage.INPUT_AMOUNT_MIN.getMessage());
        }
    }

    private void validatePositive(int input){
        if(!policy.isAmountPositive(input)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() +
                    ExceptionMessage.INPUT_NUMBER_POSITIVE.getMessage());
        }
    }
    private void validatePurchasedAmount(int amount){
        if(!((amount % policy.getAmountPolicy()) == 0)){
            throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() +
                    ExceptionMessage.AMOUNT.getMessage() + policy.getAmountPolicy()
                    + ExceptionMessage.AMOUNT_UNIT.getMessage());
        }
    }

    public List<Integer> validateWinningNumberInput(String input){
        //구분자가 있는지 검증
        checkDelimiterOrThrow(input);
        String[] unverifiedWinnerNumbers = input.split(policy.getDelimiter());
        //구분자로 나눈 값이 숫자인지 검증
        checkNumberOrThrow(unverifiedWinnerNumbers);
        //숫자가 1-45 사이의 숫자인지 검증
        List<Integer> verifiedWinningNumbers = validateNumberRange(unverifiedWinnerNumbers);
        //중복된 숫자가 있는지 검증
        validateDuplicateNumbers(verifiedWinningNumbers);
        //당첨번호 개수 검증
        validateWinningNumberSize(verifiedWinningNumbers);


        return verifiedWinningNumbers;
    }
    private void checkDelimiterOrThrow(String input) {
        if(!input.contains(policy.getDelimiter())){
            throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage()+policy.getDelimiter()+ExceptionMessage.INPUT_CHECK_DELIMITER.getMessage());
        }

    }

    private void checkNumberOrThrow(String[] unverifiedWinnerNumbers) {
        for (String input:unverifiedWinnerNumbers) {
            validateNumber(input);
        }
    }

    private List<Integer> validateNumberRange(String[] unverifiedWinnerNumbers) {
        List<Integer> validatedWinningNumbers = new ArrayList<>();
        for (String input:unverifiedWinnerNumbers) {
            int winningNumber = Integer.parseInt(input);
            if(!(winningNumber>= policy.getMinNumberLimit() && winningNumber<= policy.getMaxNumberLimit())){
                throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage()+
                        policy.getMinNumberLimit()+ExceptionMessage.RANGE_SYMBOL.getMessage()
                        +policy.getMaxNumberLimit()
                        +ExceptionMessage.INPUT_WINNING_NUMBER_RANGE.getMessage());
            }
            validatedWinningNumbers.add(winningNumber);
        }
        return validatedWinningNumbers;
    }

    private void validateDuplicateNumbers(List<Integer> validatedWinningNumbers) {
        Set<Integer> winningNumberSet = new HashSet<>(validatedWinningNumbers);
        if(winningNumberSet.size()!=validatedWinningNumbers.size()){
            throw new IllegalArgumentException(
                    ExceptionMessage.ERROR.getMessage() + ExceptionMessage.INPUT_DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateWinningNumberSize(List<Integer> verifiedWinningNumbers) {
        if (verifiedWinningNumbers.size() != policy.getWinningNumberCount()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage() +
                    policy.getWinningNumberCount() + ExceptionMessage.INPUT_WINNING_COUNT.getMessage());
        }
    }

    public int validateBonusNumberInput(String bonusNumber) {

        return 0;
    }

}
