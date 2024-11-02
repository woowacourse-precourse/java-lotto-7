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
    void 로또_번호가_올바르지_않으면_예외가_발생한다(){
        assertThatThrownBy(() -> new Lotto(new LottoService().checkWinningNumber(null)))
                .isInstanceOf(NullPointerException.class); // null 값
        assertThatThrownBy(() -> new Lotto(new LottoService().checkWinningNumber("")))
                .isInstanceOf(IllegalArgumentException.class); // 빈 값
        assertThatThrownBy(() -> new Lotto(new LottoService().checkWinningNumber("j2,2,3k,4,5,6")))
                .isInstanceOf(IllegalArgumentException.class); // 문자 포함
        assertThatThrownBy(() -> new Lotto(new LottoService().checkWinningNumber("-1,2,3,-4,5,6")))
                .isInstanceOf(IllegalArgumentException.class); // 음수 포함
        assertThatThrownBy(() -> new Lotto(new LottoService().checkWinningNumber("0,2,3,46,5,6")))
                .isInstanceOf(IllegalArgumentException.class); // 1-45에서 벗어난 양수 포함
    }

    @Test
    void 천원당_한장의_티켓_수가_반환된다() {
        assertThat(new LottoService().getNumberOfTickets("1000")).isEqualTo(1);
        assertThat(new LottoService().getNumberOfTickets("5000")).isEqualTo(5);
        assertThat(new LottoService().getNumberOfTickets("10000")).isEqualTo(10);
    }

    @Test
    void 구매금액이_천의_배수가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoService().getNumberOfTickets(null))
                .isInstanceOf(NullPointerException.class); // null 값
        assertThatThrownBy(() -> new LottoService().getNumberOfTickets(""))
                .isInstanceOf(IllegalArgumentException.class); // 빈 값
        assertThatThrownBy(() -> new LottoService().getNumberOfTickets("jkh2000"))
                .isInstanceOf(IllegalArgumentException.class); // 문자 포함
        assertThatThrownBy(() -> new LottoService().getNumberOfTickets("-1000"))
                .isInstanceOf(IllegalArgumentException.class); // 음수일 때
        assertThatThrownBy(() -> new LottoService().getNumberOfTickets("1001"))
                .isInstanceOf(IllegalArgumentException.class); // 1000의 배수가 아닐 때
    }

    @Test
    void 티켓_구매_수만큼_티켓_리스트_반환() {
        assertThat(new LottoService().getTickets(5)).hasSize(5);
    }
}
