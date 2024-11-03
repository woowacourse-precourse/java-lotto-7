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
        String[] unverifiedWinningNumbers = input.split(policy.getDelimiter());
        //구분자로 나눈 값이 숫자인지 검증
        checkNumberOrThrow(unverifiedWinningNumbers);
        //숫자가 1-45 사이의 숫자인지 검증
        List<Integer> verifiedWinningNumbers = validateWinningNumberRange(unverifiedWinningNumbers);
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

    private void checkNumberOrThrow(String[] unverifiedWinningNumbers) {
        for (String input:unverifiedWinningNumbers) {
            validateNumber(input);
        }
    }

    private List<Integer> validateWinningNumberRange(String[] unverifiedWinningNumbers) {
        List<Integer> validatedWinningNumbers = new ArrayList<>();
        for (String input:unverifiedWinningNumbers) {
            int winningNumber = Integer.parseInt(input);
            checkNumberRangeOrThrow(winningNumber);
            validatedWinningNumbers.add(winningNumber);
        }
        return validatedWinningNumbers;
    }

    private void checkNumberRangeOrThrow(int winningNumber) {
        if(!(winningNumber >= policy.getMinNumberLimit() && winningNumber <= policy.getMaxNumberLimit())){
            throw new IllegalArgumentException(ExceptionMessage.ERROR.getMessage()+
                    policy.getMinNumberLimit()+ExceptionMessage.RANGE_SYMBOL.getMessage()
                    +policy.getMaxNumberLimit()
                    +ExceptionMessage.INPUT_WINNING_NUMBER_RANGE.getMessage());
        }
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

    public int validateBonusNumberInput(List<Integer> winningNumbers,String bonusNumberInput) {
        //숫자인지 확인
        validateNumber(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        //숫자가 범위 안에 있는지 확인
        checkNumberRangeOrThrow(bonusNumber);
        // 당첨번호와 겹치지 않는지 확인
        checkContainWinningNumberOrThrow(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private void checkContainWinningNumberOrThrow(List<Integer> winningNumbers, int bonusNumber) {
        if(winningNumbers.contains(bonusNumber)){
            throw new IllegalArgumentException(
                    ExceptionMessage.ERROR.getMessage() + ExceptionMessage.INPUT_BONUS_NOT_IN_WINNING_NUMBER.getMessage());
        }
    }

}
