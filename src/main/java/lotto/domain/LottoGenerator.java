package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    private static final String ERROR_INVALID_RANGE = "[ERROR] 시작 범위는 끝 범위보다 커야 합니다.";
    private static final String ERROR_INVALID_COUNT = "[ERROR] 숫자 범위보다 뽑는 숫자의 개수가 더 많습니다.";

    public List<Integer> generateLottoNumbers(int startInclusive, int endInclusive, int count) {
        validateRange(startInclusive, endInclusive);
        validateCount(startInclusive, endInclusive, count);

        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }

    private void validateRange(int startInclusive, int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE);
        }
    }

    private void validateCount(int startInclusive, int endInclusive, int count) {
        int rangeSize = endInclusive - startInclusive + 1;
        if (count > rangeSize) {
            throw new IllegalArgumentException(ERROR_INVALID_COUNT);
        }
    }
}
