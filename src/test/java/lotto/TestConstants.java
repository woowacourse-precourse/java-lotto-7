package lotto;

import lotto.constants.ErrorMessageConstants;

import java.util.List;

public class TestConstants {
    public static final List<Integer> DUPLICATE_NUMBERS = List.of(1, 2, 3, 4, 5, 5);
    public static final List<Integer> VALID_WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    public static final List<Integer> EXPECTED_WINNING_NUMBERS = List.of(1, 2, 3, 4, 5, 6);
    public static final int VALID_BONUS_NUMBER = 7;
    public static final int VALID_PURCHASE_AMOUNT = 8_000;
    public static final int EXPECTED_BONUS_NUMBER = 7;
    public static final int EXPECTED_FIRST_COUNT = 1;
    public static final int EXPECTED_SECOND_COUNT = 0;
    public static final int EXPECTED_THIRD_COUNT = 0;
    public static final int EXPECTED_FOURTH_COUNT = 0;
    public static final int EXPECTED_FIFTH_COUNT = 0;
    public static final int EXPECTED_NONE_COUNT = 0;

    private TestConstants() {
        throw new IllegalStateException(ErrorMessageConstants.INSTANCE_CREATION_ERROR);
    }
}
