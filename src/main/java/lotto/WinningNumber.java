package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private static final String NON_DIGIT_PATTERN = ".*[^0-9].*";
    private final Lotto lotto;

    public WinningNumber(String inputWinningNumber) {
        this.lotto = validateWinningNumber(inputWinningNumber);
    }

    private Lotto validateWinningNumber(String inputWinningNumber) {
        List<String> winningNumber = Arrays.stream(inputWinningNumber.split(",")).toList();
        if (winningNumber.stream().anyMatch(s -> s.matches(NON_DIGIT_PATTERN))) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분한 숫자들이어야 합니다.");
        }
        List<Integer> lotto = winningNumber.stream()
                .map(LottoNumber::new)
                .map(LottoNumber::value)
                .toList();
        return new Lotto(lotto);
    }
}