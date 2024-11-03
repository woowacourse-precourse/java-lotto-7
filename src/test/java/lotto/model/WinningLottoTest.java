package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    private static final int VALID_SIZE = 6;
    private static final int START_INCLUSIVE = 1;

    private WinningLotto winningLotto;
    private List<Integer> numbers;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        numbers = createValidNumbers(START_INCLUSIVE);
        bonusNumber = numbers.get(VALID_SIZE - 1) + 1;
        winningLotto = new WinningLotto(new Lotto(numbers), bonusNumber);
    }

    @Test
    @DisplayName("중복되는 숫자의 개수를 올바르게 반환한다.")
    void returnValidMatchingNumber() {
        // given
        Lotto winningNumbers = new Lotto(numbers);

        // when
        int matchingNumber = winningLotto.countMatchingNumberWith(winningNumbers);

        // then
        assertThat(matchingNumber).isEqualTo(numbers.size());
    }

    @Test
    @DisplayName("보너스 숫자와의 일치 여부를 올바르게 반환한다.")
    void shouldReturnCorrectBonusMatchStatus() {
        // given
        Lotto winningNumbers = new Lotto(createValidNumbers(bonusNumber));

        // when
        boolean bonusNumberMatched = winningLotto.isBonusNumberMatchedWith(winningNumbers);

        // then
        assertThat(bonusNumberMatched).isTrue();
    }

    private List<Integer> createValidNumbers(int startInclusive) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < VALID_SIZE; i++) {
            numbers.add(startInclusive + i);
        }
        return numbers;
    }
}
