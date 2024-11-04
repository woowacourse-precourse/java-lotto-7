package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        List<LottoNumber> numbers = List.of(
                LottoNumber.valueOf("1"),
                LottoNumber.valueOf("2"),
                LottoNumber.valueOf("3"),
                LottoNumber.valueOf("4"),
                LottoNumber.valueOf("5"),
                LottoNumber.valueOf("6"),
                LottoNumber.valueOf("7")
        );
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        List<LottoNumber> numbers = List.of(
                LottoNumber.valueOf("1"),
                LottoNumber.valueOf("2"),
                LottoNumber.valueOf("3"),
                LottoNumber.valueOf("4"),
                LottoNumber.valueOf("5"),
                LottoNumber.valueOf("5")
        );
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
