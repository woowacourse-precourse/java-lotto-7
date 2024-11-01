package lotto.front.util;

import lotto.global.exception.CustomIllegalArgumentException;

public class LottoRequestParser {

    public static Integer parsePrice(String price) {
        try {
            return Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgumentException("금액은 유효한 숫자로 입력해주세요.");
        }
    }
}
