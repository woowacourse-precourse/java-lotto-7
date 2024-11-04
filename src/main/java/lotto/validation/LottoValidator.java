package lotto.validation;

import static lotto.utils.Utils.makeErrorMessage;

import java.util.List;
import lotto.domain.LottoInfo;

public class LottoValidator {
    public static void isLottoNumInRange(int winningNum) {
        if (!(LottoInfo.MIN_NUM_RANGE <= winningNum && winningNum <= LottoInfo.MAX_NUM_RANGE)) {
            throw new IllegalArgumentException(makeErrorMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다."));
        }
    }

    public static void hasDuplicates(List<Integer> list) {
        boolean isDuplicate = list.stream()
                .distinct()
                .count() != list.size();
        if (isDuplicate) {
            throw new IllegalArgumentException(makeErrorMessage("로또 번호는 중복되지 않아야 합니다."));
        }
    }

    public static void validateWinningNumbsSize(String[] winningNumbsStrs) {
        if (winningNumbsStrs.length != LottoInfo.WINNING_NUM_SIZE) {
            throw new IllegalArgumentException(makeErrorMessage("당첨 번호는 6개 이어야 합니다."));
        }
    }

    public static void validateEmptyString(String inputString) {
        if (inputString.trim().isEmpty()) {
            throw new IllegalArgumentException(makeErrorMessage("빈 문자열을 입력하였습니다."));
        }
    }


}
