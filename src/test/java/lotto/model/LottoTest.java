package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 번호는 6개의 숫자여야 합니다.")
    void testLottoNumberValidation() {
        // 로또 번호가 6개가 아닐 때 예외가 발생하는지 테스트합니다.
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");

        // 중복 번호가 있을 때 예외가 발생하는지 테스트합니다.
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는  중복되지 않는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("구매한 로또의 당첨갯수 카운트 테스트")
    void testCountMatchingNumbers() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(userLotto.countMatchingNumbers(winningLotto)).isEqualTo(3);

        Lotto noMatchLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        assertThat(noMatchLotto.countMatchingNumbers(winningLotto)).isEqualTo(0);
    }

    @Test
    @DisplayName("보너스 번호가 포함되어 있는지 테스트")
    void testHasBonusNumber() {
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        assertThat(userLotto.hasBonusNumber(bonusNumber)).isTrue();
        assertThat(userLotto.hasBonusNumber(10)).isFalse();
    }

    @Test
    @DisplayName("로또 번호 생성 시 오름차순 정렬 되는지 테스트")
    void testLottoSorting() {
        Lotto unorderedLotto = new Lotto(List.of(5, 3, 1, 6, 2, 4));
        assertThat(unorderedLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}