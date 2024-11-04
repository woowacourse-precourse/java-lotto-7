package lotto.model.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FixedNumberGeneratorTest {

    @Test
    @DisplayName("생성 시점과 동일한 로또 번호를 가진다.")
    void testFixedNumberGenerator() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator(List.of(1, 2, 3, 4, 5, 6));
        assertThat(fixedNumberGenerator.generateLottoNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new FixedNumberGenerator(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new FixedNumberGenerator(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_개수가_6개보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new FixedNumberGenerator(List.of(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("유니크한 로또 번호 6개를 받으면 로또가 생성된다.")
    void testValidLottoTest() {
        assertThatCode(() -> new FixedNumberGenerator(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 번호의 범위가 1~45 아니면 예외를 던진다.")
    void testInvalidRangeNumbersThrowsException() {
        assertThatThrownBy(() -> new FixedNumberGenerator(List.of(1, 2, 3, 100, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}