package lotto.constants;

import static lotto.constants.WinnerConstants.FIFTH_WINNER;
import static lotto.constants.WinnerConstants.FIRST_WINNER;
import static lotto.constants.WinnerConstants.FOURTH_WINNER;
import static lotto.constants.WinnerConstants.SECOND_WINNER;
import static lotto.constants.WinnerConstants.THIRD_WINNER;

import java.util.Arrays;
import java.util.List;

public class LottoConstants {
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_RANGE_MIN = 1;
    public static final int LOTTO_RANGE_MAX = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final List<WinnerConstants> WINNERS
            = Arrays.asList(FIFTH_WINNER, FOURTH_WINNER, THIRD_WINNER, SECOND_WINNER, FIRST_WINNER);
}
