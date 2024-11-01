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
     * 로또 구매 금액에 대한 사용자 입력값을 long 타입 정수로 변환합니다. 
     * @param rawInput 사용자 입력 문자열입니다.
     * @return 변환된 로또 구매 금액값입니다.
     * @throws IllegalArgumentException 사용자 입력이 적절하지 않을 경우 발생합니다.
     */
    public static long getPurchaseCost(String rawInput) {
        long value;
        try {
            value = checkAvailPurchaseCost(Long.parseLong(rawInput));
        }
        catch (NumberFormatException e) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.PURCHASE_COST_NOT_NUMBER);
        }
        catch (IllegalArgumentException e) {
            throw e;
        }
        
        return value;
    }
    
    private static long checkAvailPurchaseCost(long cost) {
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
    public static List<Integer> getWinningNumbers(String rawInput) {
        Set<Integer> numbers = new TreeSet<Integer>();
        
        String[] rawNumbers = rawInput.split(",", -1);
        if (rawNumbers.length != LOTTO_NUMBER_COUNT) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.LOTTO_NUMBER_SIZE_INCORRECT);
        }
        for (int i = 0; i < rawNumbers.length; i++) {
            numbers.add(checkAvailNumber(rawNumbers[i]));
        }
        if (rawNumbers.length != numbers.size()) {
            throw InputErrorFactory.getErrorWithMessage(InvalidInputType.LOTTO_NUMBER_DUPLICATED);
        }
        
        return new ArrayList<Integer>(numbers);
    }
    
    private static int checkAvailNumber(String numberStr) {
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

    /**
     * 보너스 번호에 대한 사용자 입력값을 변환합니다. 
     * @param rawInput 사용자 입력 문자열입니다.
     * @return 변환된 보너스 번호입니다.
     * @throws IllegalArgumentException 사용자 입력이 적절하지 않을 경우 발생합니다.
     */
    public static int getBonusNumber(String rawInput) {
        return checkAvailNumber(rawInput);
    }
}
