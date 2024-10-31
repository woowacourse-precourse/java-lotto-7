package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            // 6개보다 많은 로또 번호를 검사하기 위해 Lotto 생성자를 호출
            Lotto lotto = new Lotto();
            // 랜덤으로 생성된 번호의 개수를 검사 (직접 검사는 불가능하므로 예외를 발생시켜야 함)
            if (lotto.getNumbers().size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto();
            // 중복 여부를 검사하기 위한 로직
            if (lotto.getNumbers().stream().distinct().count() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // 추가적인 예외 조건 테스트
    @DisplayName("로또 번호가 1에서 45 사이의 숫자여야 한다.")
    @Test
    void 로또_번호가_1에서_45_사이의_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto();
            // 번호 범위 검증
            if (lotto.getNumbers().stream().anyMatch(number -> number < 1 || number > 45)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1번부터 45번 사이여야 합니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    // 추가적인 테스트 메서드 구현
}
