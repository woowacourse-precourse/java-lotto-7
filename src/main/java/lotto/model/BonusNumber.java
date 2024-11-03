package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.constant.LottoConfiguration;

public class BonusNumber {

    public static final String OUT_OF_RANGE_NUMBER_EXCEPTION_MESSAGE =
            String.format("보너스 번호는 %d~%d 사이여야 합니다.",
                    LottoConfiguration.LOTTO_NUMBER_RANGE_START, LottoConfiguration.LOTTO_NUMBER_RANGE_END);
    public static final String NULL_BANNED_NUMBER_EXCEPTION_MESSAGE = "금지 숫자 목록에 null은 허용하지 않습니다.";
    public static final String BANNED_NUMBER_MESSAGE = "당첨 번호와 중복되는 보너스 번호는 허용하지 않습니다.";

    private final int number;

    public BonusNumber(int number, List<Integer> bannedNumbers) {
        validateRange(number);
        validateNull(bannedNumbers);
        validateBan(number, bannedNumbers);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < LottoConfiguration.LOTTO_NUMBER_RANGE_START
                || number > LottoConfiguration.LOTTO_NUMBER_RANGE_END) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validateNull(List<Integer> bannedNumbers) {
        if (Objects.isNull(bannedNumbers)) {
            throw new IllegalArgumentException(NULL_BANNED_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private void validateBan(int number, List<Integer> bannedNumbers) {
        boolean isBannedNumber = bannedNumbers.stream()
                .anyMatch(bannedNumber -> bannedNumber.equals(number));
        if (isBannedNumber) {
            throw new IllegalArgumentException(BANNED_NUMBER_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }
}
