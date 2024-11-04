package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.enums.WinningType;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private static final String LOTTO_NUMBER_RANGE_ERROR = "[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBER_COUNT_ERROR = "[ERROR] 로또 번호는 %d개여야 합니다.";
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다.";


    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberCount(numbers);

        validateNumberRange(numbers);

        validateNumberDuplicate(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(LOTTO_NUMBER_COUNT_ERROR, LOTTO_NUMBER_COUNT));
        }
    }

    private void validateNumberDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            validateDuplicate(number, numberSet);
        }
    }

    private void validateDuplicate(final Integer number, final Set<Integer> numberSet){
        if (!numberSet.contains(number)) {
            numberSet.add(number);
            return;
        }
        throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
    }

    private void validateNumberRange(List<Integer> numbers) {
        numbers.forEach(this::isInRange);
    }

    public WinningType checkWinningNumbers(List<Integer> winningNumbers, Integer bonusNumber){
        int matchCount = 0;
        boolean matchBonus = false;
        matchCount += matchNumbers(winningNumbers);
        matchBonus = matchBonus(bonusNumber);

        return WinningType.getWinningType(matchCount, matchBonus);
    }

    private Integer matchNumbers(List<Integer> winningNumbers){
        int matchCount = 0;
        for (Integer number : numbers) {
            if(winningNumbers.contains(number)){
                matchCount ++;
            }
        }
        return matchCount;
    }

    private boolean matchBonus(Integer bonusNumber){
        if(numbers.contains(bonusNumber)){
            return true;
        }
        return false;
    }

    private void isInRange(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(
                    String.format(LOTTO_NUMBER_RANGE_ERROR, LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }

    public String toPrintList(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if(numbers.size() > 0){
            stringBuilder.append(numbers.get(0));
        }
        for(int i = 1 ; i < numbers.size() ; i ++){
            stringBuilder.append(", " + numbers.get(i));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
