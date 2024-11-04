package lotto;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {
    private static final String NON_DIGIT_PATTERN = ".*[^0-9].*";
    private final Lotto lotto;

    public WinningNumber(String inputWinningNumber) {
        this.lotto = validateWinningNumber(inputWinningNumber);
    }

    public Boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber.value());
    }

    public int getSameCount(Lotto lotto){
        return this.lotto.getSameCount(lotto);
    }

    private Lotto validateWinningNumber(String inputWinningNumber) {
        List<String> winningNumber = createStringList(inputWinningNumber);
        if (hasInvalidDelimiter(winningNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분한 숫자들이어야 합니다.");
        }
        return new Lotto(createIntegerList(winningNumber));
    }

    private boolean hasInvalidDelimiter(List<String> winningNumber) {
        return winningNumber.stream().anyMatch(s -> s.matches(NON_DIGIT_PATTERN));
    }

    private List<String> createStringList(String inputWinningNumber) {
        return Arrays.stream(inputWinningNumber.split(",")).toList();
    }

    private List<Integer> createIntegerList(List<String> winningNumber){
        return winningNumber.stream()
                .map(LottoNumber::new)
                .map(LottoNumber::value)
                .toList();
    }
}