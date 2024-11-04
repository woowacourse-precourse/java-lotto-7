package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constants.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserLottoTest {

    Lotto testLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    int testBonus = 6;

    @Test
    @DisplayName("보너스 번호와, 로또 번호 6개가 중복되면 오류가 발생합니다.")
    void 보너스번호와_로또번호가_중복이면_오류() {
        assertThatThrownBy(() -> UserLotto.of(testLotto, testBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_DUPLICATED.getMessage());
    }

    @ParameterizedTest
    @DisplayName("보너스 번호가 범위 바깥에 있으면 오류가 발생합니다.")
    @ValueSource(ints = {0, 46, -100, 100, -1})
    void 보너스번호가_범위_바깥이면_오류(int target) {
        assertThatThrownBy(() -> UserLotto.of(testLotto, target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}
