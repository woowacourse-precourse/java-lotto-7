package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    void 구매금액에_따른_티켓수_반환() {
        assertThat(new LottoService().getNumberOfTickets("1000")).isEqualTo(1);
        assertThat(new LottoService().getNumberOfTickets("5000")).isEqualTo(5);
        assertThat(new LottoService().getNumberOfTickets("10000")).isEqualTo(10);
    }

    @Test
    void 구매금액이_1000의_배수가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoService().getNumberOfTickets(""))
                .isInstanceOf(IllegalArgumentException.class); // 빈 값
        assertThatThrownBy(() -> new LottoService().getNumberOfTickets("jkh2000"))
                .isInstanceOf(IllegalArgumentException.class); // 문자 포함
        assertThatThrownBy(() -> new LottoService().getNumberOfTickets("-1000"))
                .isInstanceOf(IllegalArgumentException.class); // 음수일 때
        assertThatThrownBy(() -> new LottoService().getNumberOfTickets("1001"))
                .isInstanceOf(IllegalArgumentException.class); // 1000의 배수가 아닐 때
    }
}
