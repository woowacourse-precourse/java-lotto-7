package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    private LottoTicket lottoTicket;
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        lottoTicket = new LottoTicket(lottos);
    }

    @Test
    @DisplayName("LottoTicket의 로또 갯수 테스트")
    void getLottosCount() {
        assertThat(lottoTicket.getLottosCount()).isEqualTo(2);
    }

}
