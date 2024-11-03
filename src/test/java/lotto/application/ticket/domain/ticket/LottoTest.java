package lotto.application.ticket.domain.ticket;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Lotto - 로또 번호 생성")
class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("로또 번호가 정상 범위면 생성 성공")
    @Test
    void 로또_번호가_정상_범위면_생성_성공() {

        // expect
        Assertions.assertThatCode(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 45)))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호에 1보다 작은 숫자가 있으면 예외가 발생한다")
    @Test
    void 로또_번호가_최소값보다_작으면_예외발생() {

        // expect
        Assertions.assertThatThrownBy(() -> Lotto.of(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호에 45보다 큰 숫자가 있으면 예외가 발생한다")
    @Test
    void 로또_번호가_최대값보다_크면_예외발생() {

        // expect
        Assertions.assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 6개가 아니면 예외가 발생한다")
    @Test
    void 로또_번호_개수가_6개가_아니면_예외발생() {

        // expect
        Assertions.assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("비교대상 숫자를 포함하면 true 반환")
    @Test
    void 비교대상_숫자를_포함하면_false반환() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 45));
        int input = 1;

        // when
        boolean result = lotto.contains(input);

        //then
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("비교대상 숫자를 포함 안하면 false 반환")
    @Test
    void 비교대상_숫자를_포함안하면_false반환() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 45));
        int input = 30;

        // when
        boolean result = lotto.contains(input);

        //then
        Assertions.assertThat(result).isFalse();
    }

}
