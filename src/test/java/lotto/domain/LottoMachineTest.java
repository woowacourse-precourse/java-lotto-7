package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("구입 금액에 따라 정렬된 LottoTicket들을 생성한다")
    @Test
    void 구입_금액에_따라_정렬된_LottoTicket들을_생성한다() {
        // given
        LottoMachine lottoMachine = new LottoMachine(() -> List.of(6, 5, 4, 3, 2, 1));
        int purchaseAmount = 8000;

        // when
        LottoTickets lottoTickets = lottoMachine.getLottoTickets(purchaseAmount);

        // then
        List<String> lottoNumbers = lottoTickets.getLottoNumbers();
        assertThat(lottoTickets.getCount()).isEqualTo(8);
        assertThat(lottoNumbers).contains("[1, 2, 3, 4, 5, 6]");
    }

}