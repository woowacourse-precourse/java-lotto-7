package lotto.front.util;

import java.util.List;
import java.util.stream.Stream;
import lotto.global.exception.CustomIllegalArgumentException;

public class LottoRequestParser {

    public static Integer parsePrice(String price) {
        try {
            return Integer.valueOf(price);
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgumentException("금액은 유효한 숫자로 입력해주세요.");
        }
    }

    public static List<Integer> parsePrizeNumber(String prizeNumber) {
        try {
            return Stream.of(prizeNumber.split(","))
                    .map(String::trim)
                    .map(Integer::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgumentException("당첨 번호는 유효한 숫자로 입력해주세요.");
        }
    }

    public static Integer parseBonusNumber(String bonusNumber) {
        try {
            return Integer.valueOf(bonusNumber);
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgumentException("보너스 번호는 유효한 숫자로 입력해주세요.");
        }
    }

}
