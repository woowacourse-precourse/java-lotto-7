package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private Lotto lotto;
    private int BonusNumber;

    public WinningLotto(String lottoNumber) {
        validateInput(lottoNumber);
        List<Integer> winningLotto = splitLottoNumber(lottoNumber);
        validateNumber(winningLotto);
        this.lotto = new Lotto(winningLotto);
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

    private void validateNumber(List<Integer> lotto) {

        if (!validateDuplicateNumber(lotto)) {
            throw new IllegalArgumentException(ErrorMessage.printError(ErrorMessage.ERROR_DUPLICATE_NUMBER));
        }
        if (!checkLottoNumberRange(lotto)) {
            throw new IllegalArgumentException(ErrorMessage.printError(ErrorMessage.ERROR_NUMBER_UNDER_ZERO_OVER_FORTY_FIVE));
        }
    }

    private static boolean validateDuplicateNumber(List<Integer> lotto) {
        Set<Integer> uniqueNumbers = new HashSet<>(lotto);
        return uniqueNumbers.size() == lotto.size();
    }

    private static boolean checkLottoNumberRange(List<Integer> lotto) {
        for (Integer number : lotto) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

}
