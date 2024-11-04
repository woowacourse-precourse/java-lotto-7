package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

import lotto.model.BonusNumber;

public class BonusNumberTest {

    @Test
    void 입력이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("숫자"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("-1000"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("46"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력이_정수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("2.3"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_입력_테스트() {
        assertSimpleTest(() -> {
            BonusNumber bonusNumber = new BonusNumber("3");
            assertThat(bonusNumber.getBonusNumber()).isEqualTo(3);
        });
    }
}
