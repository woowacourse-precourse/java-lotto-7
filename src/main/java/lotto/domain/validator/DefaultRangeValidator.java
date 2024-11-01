package lotto.domain.validator;

public class DefaultRangeValidator implements RangeValidator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Override
    public boolean outOfRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }

}
