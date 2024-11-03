package lotto.model.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    @DisplayName("정적 팩토리 메서드 of로 WinningLotto 객체를 생성하는지 확인")
    void of() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;

        // when
        WinningLotto winningLotto = WinningLotto.of(numbers, bonusNumber);

        // then
        assertThat(winningLotto).isNotNull();
        assertThat(winningLotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("getNumbers 호출 시 WinningLotto의 번호 리스트를 반환하는지 확인")
    void getNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        WinningLotto winningLotto = WinningLotto.of(numbers, bonusNumber);

        // when
        List<Integer> retrievedNumbers = winningLotto.getNumbers();

        // then
        assertThat(retrievedNumbers).containsExactly(1, 2, 3, 4, 5, 6);

    }

    @Test
    @DisplayName("getBonusNumber 호출 시 WinningLotto의 보너스 번호를 반환하는지 확인")
    void getBonusNumber() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 7;
        WinningLotto winningLotto = WinningLotto.of(numbers, bonusNumber);

        // when
        Integer retrievedBonusNumber = winningLotto.getBonusNumber();

        // then
        assertThat(retrievedBonusNumber).isEqualTo(7);

    }
}
