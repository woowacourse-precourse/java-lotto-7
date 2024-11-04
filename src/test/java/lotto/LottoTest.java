package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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

    //로또번호 1-45사이의 숫자의 검증
    @DisplayName("로또 번호가 1과 45 사이의 숫자가 아니면 예외가 발생한다")
    @Test
    void 로또_번호_범위_검증() {
        // 숫자 중 하나가 0일 때 예외 발생
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1과 45사이의 숫자입니다");

        // 숫자 중 하나가 46일 때 예외 발생
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1과 45사이의 숫자입니다");
    }

    //정상적인 객체생성하는지 확인  && 정렬 확인
    @DisplayName("정상적인 로또 번호 리스트로 객체를 생성할 수 있다")
    @Test
    void 로또_객체_생성_성공() {
        Lotto lotto = new Lotto(List.of(8, 21, 35, 11, 42, 7));

        assertThat(lotto.getNumbers()).containsExactly(7, 8, 11, 21, 35, 42);
    }

    //랜덤으로 로또 번호 생성되는지 확인
    @DisplayName("랜덤으로 로또 번호를 생성할 수 있다")
    @Test
    void 로또_랜덤_번호_생성() {
        Lotto lotto = Lotto.generateRandomNumbers();

        assertThat(lotto.getNumbers()).hasSize(6);

        assertThat(lotto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);

        long uniqueCount = lotto.getNumbers().stream().distinct().count();
        assertThat(uniqueCount).isEqualTo(6);
    }
}
