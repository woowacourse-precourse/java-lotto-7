package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Enum.ExceptionCode;
import lotto.Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest extends NsTest {
    @DisplayName("EXCEPTION_LOTTO_01: 숫자가 6개가 아니면 예외 발생")
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ExceptionCode.INVALID_NUMBERS_LENGTH.getMessage());
    }

    @DisplayName("EXCEPTION_LOTTO_03: 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ExceptionCode.DUPLICATED_NUMBER.getMessage());
    }

    @DisplayName("번호_정렬: List<Integer>로 받은 번호를 정렬한다.")
    @Test
    void 번호가_정렬_후_저장된다() {
        assert(new Lotto(List.of(42, 43, 41, 21, 8, 23)).getNumbers()).equals(List.of(8, 21, 23, 41, 42, 43));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
