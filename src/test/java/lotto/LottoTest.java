package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("로또 번호가 지정된 범위(1~45)를 벗어났다면 예외가 발생한다.")
    @Test
    void 로또_번호가_지정된_범위를_벗어났다면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 빈 문자열이라면 예외가 발생한다.")
    @Test
    void 로또_번호가_빈_문자열이라면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메시지에서 상금이 잘 추출되는지 확인한다.")
    @Test
    void 메시지에서_상금이_잘_추출되는지_확인한다() {
        LottoResult lotto = new LottoResult();

        String message = "당첨 금액은 (1,000,000원)입니다.";
        int prize = lotto.extractPrize(message);

        assertThat(prize).isEqualTo(1000000);
    }
}
