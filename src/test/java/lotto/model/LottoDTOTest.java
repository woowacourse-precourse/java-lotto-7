package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoDTOTest {

    @DisplayName("로또 번호 목록을 올바르게 반환한다.")
    @Test
    void 로또_번호_목록을_올바르게_반환한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoDTO lottoDTO = new LottoDTO(numbers);

        List<Integer> returnedNumbers = lottoDTO.getNumbers();

        assertThat(returnedNumbers).isEqualTo(numbers);
    }

    @DisplayName("로또 번호 목록이 null이면 예외가 발생한다.")
    @Test
    void 로또_번호_목록이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoDTO(null))
                .isInstanceOf(NullPointerException.class);
    }
}
