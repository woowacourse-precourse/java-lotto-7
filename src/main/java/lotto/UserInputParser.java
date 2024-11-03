package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 각종 사용자 입력값을 적절한 형식의 데이터로 변환하는 기능을 담은 클래스입니다.
 * <br/>만약 적절하지 않은 입력값이면 IllegalArgumentException를 반환합니다.
 */
public class UserInputParser {
    private static final int LOTTO_NUMBER_COUNT = 6;
    
    /**
     * 주어진 문자열을 UserInputType에 따라 변환한 결과를 반환합니다.
     * @param rawInput 변환할 문자열
     * @param inputType 입력 데이터의 종류
     * @return 변환된 결과 :
     * <br/> {@link UserInputType#PURCHASE_COST} - int
     * <br/> {@link UserInputType#WINNING_NUMBERS} - List{@literal <Integer>}
     * <br/> {@link UserInputType#BONUS_NUMBER} - int
     */
    public static Object getParsedInput(String rawInput, UserInputType inputType) {
        if (inputType == UserInputType.PURCHASE_COST) {
            return getPurchaseCost(rawInput);
        }
        if (inputType == UserInputType.WINNING_NUMBERS) {
            return getWinningNumbers(rawInput);
        }
        if (inputType == UserInputType.BONUS_NUMBER) {
            return getLottoNumber(rawInput);
        }
        throw new UnsupportedOperationException("알 수 없는 입력 형식입니다! : " + inputType.toString());
    }
    
    /**
     * 로또 구매 금액에 대한 사용자 입력값을 long 타입 정수로 변환합니다. 
     * @param rawInput 사용자 입력 문자열입니다.
     * @return 변환된 로또 구매 금액값입니다.
     * @throws IllegalArgumentException 사용자 입력이 적절하지 않을 경우 발생합니다.
     */
    private static int getPurchaseCost(String rawInput) {
        int value;
        try {
            value = checkAvailPurchaseCost(Integer.parseInt(rawInput));
        }
        catch (NumberFormatException e) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.PURCHASE_COST_NOT_NUMBER);
        }
        catch (IllegalArgumentException e) {
            throw e;
        }
        
        return value;
    }
    
    private static int checkAvailPurchaseCost(int cost) {
        if (cost < 1000) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.PURCHASE_COST_TOO_LOW);
        }
        
        if (cost%1000 != 0) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.PURCHASE_COST_NOT_THOUSANDS);
        }
        
        return cost;
    }
    
    /**
     * 당첨번호에 대한 사용자 입력값을 정렬하여 정수 List로 반환합니다. 
     * @param rawInput 사용자 입력 문자열입니다.
     * @return 변환된 당첨번호 List입니다. (정렬됨)
     * @throws IllegalArgumentException 사용자 입력이 적절하지 않을 경우 발생합니다.
     */
    private static List<Integer> getWinningNumbers(String rawInput) {
        Set<Integer> numbers = new TreeSet<Integer>();
        
        String[] rawNumbers = rawInput.split(",", -1);
        if (rawNumbers.length != LOTTO_NUMBER_COUNT) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.LOTTO_NUMBER_SIZE_INCORRECT);
        }
        for (int i = 0; i < rawNumbers.length; i++) {
            numbers.add(getLottoNumber(rawNumbers[i]));
        }
        if (rawNumbers.length != numbers.size()) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.LOTTO_NUMBER_DUPLICATED);
        }
        
        return new ArrayList<Integer>(numbers);
    }

    /**
     * 한 로또 번호에 대한 문자열을 변환합니다. 
     * @param numberStr 로또 번호 문자열입니다.
     * @return 변환된 로또 번호입니다.
     * @throws IllegalArgumentException 사용자 입력이 적절하지 않을 경우 발생합니다.
     */
    private static int getLottoNumber(String numberStr) {
        int number;
        try {
            number = Integer.parseInt(numberStr);
        }
        catch (NumberFormatException e) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.LOTTO_NUMBER_NOT_NUMBER);
        }
        
        if (number < 1 || number > 45) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.LOTTO_NUMBER_INVALID);
        }
        
        return number;
    }
}
