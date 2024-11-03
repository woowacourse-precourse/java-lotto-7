package lotto;

import enums.Prize;
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
    void 로또_번호가_올바르지_않으면_예외가_발생한다() {
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
    void 보너스_번호가_올바르지_않으면_예외가_발생한다() {
        assertThatThrownBy(
                () -> new LottoService().checkBonusNumber(null, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(NullPointerException.class); // null 값
        assertThatThrownBy(() -> new LottoService().checkBonusNumber("", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class); // 빈 값
        assertThatThrownBy(
                () -> new LottoService().checkBonusNumber("J", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class); // 문자인 경우
        assertThatThrownBy(
                () -> new LottoService().checkBonusNumber("-1", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class); // 음수인 경우
        assertThatThrownBy(
                () -> new LottoService().checkBonusNumber("0", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class); // 1-45에서 벗어난 양수인 경우
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(
                () -> new LottoService().checkBonusNumber("1", List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
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

    @Test
    void 로또_당첨_결과_기록_해시맵_초기화_후_반환() {
        assertThat(new LottoService().getInitialLottoResult()).
                containsEntry("FIRST", 0).containsEntry("SECOND", 0).containsEntry("THIRD", 0)
                .containsEntry("FOURTH", 0).containsEntry("FIFTH", 0);
    }

    @Test
    void 일치하는_숫자의_개수를_반환() {
        assertThat(new LottoService().getNumberOfMatch(List.of(1, 2, 3, 4, 5, 6),
                List.of(2, 3, 4, 5, 6, 7))).isEqualTo(5);
        assertThat(new LottoService().getNumberOfMatch(List.of(10, 11, 12, 13, 14, 15),
                List.of(2, 3, 4, 5, 6, 7))).isEqualTo(0);
    }

    @Test
    void 일치하는_숫자의_개수와_보너스번호_일치여부에_따라_알맞은_등수를_반환() {
        assertThat(new LottoService().getLottoRank(6, true)).isEqualTo(Prize.FIRST);
        assertThat(new LottoService().getLottoRank(6, false)).isEqualTo(Prize.FIRST);
        assertThat(new LottoService().getLottoRank(5, true)).isEqualTo(Prize.SECOND);
        assertThat(new LottoService().getLottoRank(5, false)).isEqualTo(Prize.THIRD);
    }

    @Test
    void 모든_티켓의_당첨_확인_후_결과_기록_해시맵_반환() {
        assertThat(new LottoService().assessLottoOutcome(new LottoService().getInitialLottoResult(),
                List.of(List.of(1, 2, 3, 4, 5, 6), List.of(2, 3, 4, 5, 6, 7),
                        List.of(3, 4, 5, 6, 7, 8), List.of(4, 5, 6, 7, 8, 9),
                        List.of(5, 6, 7, 8, 9, 10), List.of(1, 2, 3, 9, 10, 11),
                        List.of(1, 2, 3, 10, 11, 12), List.of(2, 3, 4, 5, 6, 8)),
                List.of(1, 2, 3, 4, 5, 6), 7)).containsEntry("FIRST", 1).containsEntry("SECOND", 1)
                .containsEntry("THIRD", 1).containsEntry("FOURTH", 1).containsEntry("FIFTH", 3);
    }
}
