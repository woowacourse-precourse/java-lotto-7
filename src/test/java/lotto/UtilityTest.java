package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.LottoRandomNumber;
import lotto.utility.NumberUtility;
import lotto.utility.StringUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilityTest extends NsTest {

    @DisplayName("유틸리티의 인스턴스를 생성하면 예외가 발생한다")
    @Test
    void 숫자_유틸리티의_인스턴스를_생성하면_예외가_발생한다() {
        assertThatThrownBy(() -> new NumberUtility())
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("유틸리티의 인스턴스를 생성하면 예외가 발생한다")
    @Test
    void 문자열_유틸리티의_인스턴스를_생성하면_예외가_발생한다() {
        assertThatThrownBy(() -> new StringUtility())
                .isInstanceOf(IllegalStateException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
