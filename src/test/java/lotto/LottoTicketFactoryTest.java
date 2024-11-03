package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.factory.LottoTicketFactory;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketFactoryTest {

    @DisplayName("구매 금액을 계산해서 생성할 로또 티켓 수를 정상적으로 계산한다.")
    @Test
    void 구매_금액에_따른_로또_티켓_수_계산() {
        List<Lotto> lottoTickets = LottoTicketFactory.generateLottoTickets(3000);
        assertThat(lottoTickets).hasSize(3);
    }

    @DisplayName("1부터 45 범위의 6개 고유 숫자를 포함한 티켓을 생성한다.")
    @Test
    void 로또_티켓의_번호_유효성_검사() {
        List<Lotto> lottoTickets = LottoTicketFactory.generateLottoTickets(1000);
        for (Lotto lotto : lottoTickets) {
            assertThat(lotto.getNumbers())
                    .hasSize(6)
                    .allMatch(num -> num >= 1 && num <= 45)
                    .doesNotHaveDuplicates();
        }
    }

    @DisplayName("구매 금액이 0원일 때 로또 티켓이 생성되지 않음")
    @Test
    void 구매_금액이_0원일때_로또_티켓_생성되지_않음() {
        List<Lotto> lottoTickets = LottoTicketFactory.generateLottoTickets(0);
        assertThat(lottoTickets).isEmpty();
    }

}
