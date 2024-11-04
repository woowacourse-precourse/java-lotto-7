package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottosTest {
    @Test
    void 로또들이_잘_생성되는_지_확인(){
        //Given & When
        Lottos lottos = new Lottos(3);
        List<Lotto> lottoTickets = lottos.getLottoTickets();

        //Then
        Assertions.assertThat(lottoTickets.size()).isEqualTo(3);
        for (Lotto lottoTicket : lottoTickets) {
            Assertions.assertThat(lottoTicket.getNumbers().size()).isEqualTo(6);
        }
    }
}
