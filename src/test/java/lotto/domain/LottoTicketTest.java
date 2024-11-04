package lotto.domain;

import lotto.generator.RandomLottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private static final int TEST_LOTTO_COUNT = 5;
    private static final int EXPECTED_LOTTO_COUNT = 5;

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        RandomLottoNumberGenerator generator = new RandomLottoNumberGenerator();
        lottoTicket = new LottoTicket(generator, TEST_LOTTO_COUNT);
    }

    @Test
    void 로또_티켓_생성_테스트() {
        List<Lotto> lottos = lottoTicket.getLottos();
        assertThat(lottos).hasSize(EXPECTED_LOTTO_COUNT);
    }
}
