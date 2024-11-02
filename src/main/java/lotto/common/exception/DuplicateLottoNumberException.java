package lotto.common.exception;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;

public class DuplicateLottoNumberException extends LottoException {
    public DuplicateLottoNumberException(List<LottoNumber> lottoNumbers) {
        super(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage() + "(로또 번호: " +
                lottoNumbers.stream()
                        .map(LottoNumber::getLottoNumber)
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))
                + ")"
        );
    }

    public DuplicateLottoNumberException(List<LottoNumber> lottoNumbers, Exception e) {
        super(ErrorMessage.LOTTO_NUMBER_DUPLICATE.getMessage() + "(로또 번호: " +
                lottoNumbers.stream()
                        .map(LottoNumber::getLottoNumber)
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))
                + ")"
        );
    }
}
