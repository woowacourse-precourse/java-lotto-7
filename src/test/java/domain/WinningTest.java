package domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.error.ErrorMessage;
import java.util.List;
import lotto.domain.Winning;
import org.junit.jupiter.api.Test;

class WinningTest {

    @Test
    void 당첨_번호_반환_테스트() {
        assertSimpleTest(
                () -> {
                    Winning winning = new Winning(List.of(8, 21, 23, 41, 42, 43), 11);
                    assertThat(winning.getNumbers()).isEqualTo(List.of(8, 21, 23, 41, 42, 43));
                }
        );
    }

    @Test
    void 로또_상세_내역_반환_테스트() {
        assertSimpleTest(
                () -> {
                    Winning winning = new Winning(List.of(8, 21, 23, 41, 42, 43), 11);
                    assertThat(winning.getBonus()).isEqualTo(11);
                }
        );
    }

    @Test
    void 당첨_번호가_6개가_아닌_경우_예외_테스트() {
        assertSimpleTest(
                () -> {
                    assertThatThrownBy(() -> new Winning(List.of(8, 21, 22, 23, 24), 11))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.LOTTO_NUMBERS_SIZE_ERROR_MESSAGE.toString());
                }
        );
    }

    @Test
    void 당첨_번호에_보너스_번호가_중복되는_경우_예외_테스트() {
        assertSimpleTest(
                () -> {
                    assertThatThrownBy(() -> new Winning(List.of(8, 21, 22, 23, 24, 11), 11))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage(ErrorMessage.BONUS_DUPLICATE_ERROR_MESSAGE.toString());
                }
        );
    }

}