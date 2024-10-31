package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    public WinningLotto(String lottoNumber, int bonusNumber) {
        validateInput(lottoNumber);
        validateNumber(bonusNumber);
        this.lotto = new Lotto(splitLottoNumber(lottoNumber));
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> splitLottoNumber(String lottoNumber) {

        return Arrays.stream(lottoNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private void validateInput(String lottoNumber) {
        // 숫자와 쉼표만 허용하는 정규식 검증
        if (!lottoNumber.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException(ErrorMessage.printError(ErrorMessage.ERROR_DELIMETER_ONLY_HAS_COMMA));
        }
    }

    private void validateNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.printError(ErrorMessage.ERROR_NUMBER_UNDER_ZERO_OVER_FORTY_FIVE));
        }
    }


}
