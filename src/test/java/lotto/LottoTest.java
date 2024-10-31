package lotto;

import lotto.domain.Lotto;
import lotto.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에 중복이 존재하면 안됩니다.");
    }

    @DisplayName("구입금액에 숫자 이외의 입력이 들어오면 예외가 발생한다.")
    @Test
    void 구입금액에_숫자_이외의_입력이_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> Validator.validateAmount("8000qwer"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("[ERROR] 구입금액은 숫자만 입력 가능합니다."); //NumberFormatException은 IllegalArgumentException을 상속받아 둘다 나옴
    }

    @DisplayName("로또 번호로 범위에 벗어난 숫자가 들어오면 예외가 발생한다.")
    @Test
    void 로또_번호로_범위에_벗어난_숫자가_들어오면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 77, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
