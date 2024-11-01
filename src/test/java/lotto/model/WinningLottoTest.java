package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    private static final int VALID_SIZE = 6;
    private static final int START_INCLUSIVE = 1;

    @Test
    @DisplayName("중복되는 숫자의 개수를 올바르게 반환한다.")
    void returnValidMatchingNumber() {
        // given
        List<Integer> numbers = createValidNumbers();
        int bonusNumber = numbers.getLast() + 1;
        WinningLotto winningLotto = new WinningLotto(new Lotto(numbers), bonusNumber);

        List<Integer> comparedNumbers = numbers;

        // when
        int matchingNumber = winningLotto.countMatchingNumberWith(comparedNumbers);

        // then
        assertThat(matchingNumber).isEqualTo(numbers.size());
    }

    private List<Integer> createValidNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < VALID_SIZE; i++) {
            numbers.add(START_INCLUSIVE + i);
        }
        return numbers;
    }
}
