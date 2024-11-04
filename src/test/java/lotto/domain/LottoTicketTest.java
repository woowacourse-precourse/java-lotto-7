package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @DisplayName("올바른 로또 티켓 양식을 만든다.")
    @Test
    void toStringTest() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        LottoTicket lottoTicket = new LottoTicket(List.of(lotto1, lotto2));

        String lottoTicketFormat = lottoTicket.toString();

        String expectedOutput = "\n2개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]";
        assertThat(lottoTicketFormat).isEqualTo(expectedOutput);
    }
}
