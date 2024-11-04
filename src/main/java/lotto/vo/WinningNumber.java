package lotto.vo;

import java.util.Arrays;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;

public record WinningNumber(Lotto lotto) {
    private static final String NON_DIGIT_PATTERN = ".*[^0-9].*";
    
    public WinningNumber(String inputWinningNumber) {
        this(validateWinningNumber(inputWinningNumber));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber.value());
    }

    public int getSameCount(Lotto lotto) {
        return this.lotto.getSameCount(lotto);
    }

    private static Lotto validateWinningNumber(String inputWinningNumber) {
        List<String> winningNumber = createStringList(inputWinningNumber);
        if (hasInvalidDelimiter(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER_SPLIT_ERROR);
        }
        return new Lotto(createIntegerList(winningNumber));
    }

    private static boolean hasInvalidDelimiter(List<String> winningNumber) {
        return winningNumber.stream().anyMatch(s -> s.matches(NON_DIGIT_PATTERN));
    }

    private static List<String> createStringList(String inputWinningNumber) {
        return Arrays.stream(inputWinningNumber.split(",")).toList();
    }

    private static List<Integer> createIntegerList(List<String> winningNumber) {
        return winningNumber.stream()
                .map(LottoNumber::new)
                .map(LottoNumber::value)
                .toList();
    }
}