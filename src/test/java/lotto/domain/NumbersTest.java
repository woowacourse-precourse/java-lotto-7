package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import lotto.factory.NumbersMakeFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> NumbersMakeFactory.createNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 5)), 8))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에 중복이 존재하면 안됩니다.");
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
    @Test
    void 당첨_번호와_보너스_번호가_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new Numbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
    }

}