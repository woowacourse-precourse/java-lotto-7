package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoBoxTest {

    @DisplayName("로또_티켓_구매_개수_확인")
    @Test
    void checkTheNumberOfTicket() {
        LottoBox lottoBox = new LottoBox(5); // 5개의 로또 티켓 구매
        List<Lotto> tickets = lottoBox.getLotto(); // 구입한 로또 티켓 리스트 가져오기

        assertThat(tickets).hasSize(5); // 티켓 개수가 5개인지 확인
    }

    @DisplayName("로또_번호_범위_확인")
    @Test
    void checkTheRangeOfTicket() {
        LottoBox lottoBox = new LottoBox(5); // 5개의 로또 티켓 구매
        List<Lotto> tickets = lottoBox.getLotto();

        for (Lotto ticket : tickets) {
            List<Integer> numbers = ticket.getNumbers();
            for (Integer number : numbers) {
                assertThat(number).isGreaterThan(0).isLessThan(46); // 숫자가 1과 45 사이인지 확인
            }
        }
    }

}