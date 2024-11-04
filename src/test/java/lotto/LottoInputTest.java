package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Constants.ErrorMessages;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.DisplayName;

public class LottoInputTest extends NsTest {
    @DisplayName("구입금액은 1000원 단위여야 한다.")
    @Test
    void 구입금액은_1000원_단위여야_한다_1() {
        assertSimpleTest(() -> {
            runException("100");
            assertThat(output()).contains(ErrorMessages.INPUT_TOTAL_AMOUNT_ERROR.getMessage());
        });
    }

    @DisplayName("구입금액은 1000원 단위여야 한다.")
    @Test
    void 구입금액은_1000원_단위여야_한다_2() {
        assertSimpleTest(() -> {
            runException("1004");
            assertThat(output()).contains(ErrorMessages.INPUT_TOTAL_AMOUNT_ERROR.getMessage());
        });
    }

    @DisplayName("구입금액은 양수여야 한다.")
    @Test
    void 구입금액은_양수여야_한다() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains(ErrorMessages.INPUT_TOTAL_AMOUNT_ERROR.getMessage());
        });
    }

    @DisplayName("구입금액은 빈문자열일 수 없다.")
    @Test
    void 구입금액은_빈문자열일_수_없다() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ErrorMessages.NUMBER_FORMAT_ERROR.getMessage());
        });
    }

    @DisplayName("bonus 번호가 당첨번호와 중복되면 예외가 발생한다.")
    @Test
    void bonus_번호가_당첨번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 50))).setBonusNumber("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
