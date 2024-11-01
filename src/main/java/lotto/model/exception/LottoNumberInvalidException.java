package lotto.model.exception;

import lotto.exception.CustomException;

public final class LottoNumberInvalidException extends IllegalArgumentException implements CustomException {

    private LottoNumberInvalidException(String message) {
        super(message);
    }

    public static IllegalArgumentException lottoNumberRange() {
        return new LottoNumberInvalidException("로또 번호는 1부터 45 사이여야 합니다.");
    }

    public static IllegalArgumentException lottoNumberSize() {
        return new LottoNumberInvalidException("로또 번호는 6개여야 합니다.");
    }

    public static IllegalArgumentException lottoNumberDuplicate() {
        return new LottoNumberInvalidException("로또 번호는 중복되지 않아야 합니다.");
    }

    public static IllegalArgumentException bonusNumberDuplicate() {
        return new LottoNumberInvalidException("보너스 번호가 당첨 번호에 포함되서는 안됩니다.");
    }
}
