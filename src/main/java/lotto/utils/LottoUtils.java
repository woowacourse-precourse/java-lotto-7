package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constant.ErrorMessage.WINNING_NUMBER_FORMAT_ERROR_MESSAGE;
import static lotto.constant.NumberConstant.*;

public class LottoUtils {
    public static final String SPLIT_REGEX = ",";

    public static List<Lotto> lottoGenerator(int lottoAmount) {
        return Stream.generate(() -> new Lotto(lottoNumberGenerator()))
                .limit(lottoAmount)
                .collect(Collectors.toList());
    }

    private static List<Integer> lottoNumberGenerator() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN_RANGE, LOTTO_NUMBER_MAX_RANGE, LOTTO_NUMBER_SIZE);
    }

    public static List<Integer> generateWinningNumber(String inputWinningNumber) {
        try {
            return Arrays.stream(inputWinningNumber.split(SPLIT_REGEX))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
