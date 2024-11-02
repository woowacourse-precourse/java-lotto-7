package lotto.domain.ticket;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketCreatorTest {

    private LottoTicketCreator lottoTicketCreator;
    private LottoCreator lottoCreator;

    @BeforeEach
    void setUp() {
        lottoCreator = new LottoCreator();
        LottoGenerator lottoGenerator = new FakeLottoGenerator(lottoCreator);
        lottoTicketCreator = new LottoTicketCreator(lottoGenerator);
    }

    @DisplayName("로또 티켓을 생성하는 테스트")
    @Test
    void createLottoTicket_fakeGenerator_returnLottoTicket() {
        LottoTicket lottoTicket = lottoTicketCreator.createLottoTicket(2);
        Lotto expectedLotto = lottoCreator.createLotto(List.of(1, 2, 3, 4, 5, 6));
        assertAll(() -> assertThat(lottoTicket.getLottoTicket().size()).isEqualTo(2),
                () -> assertThat(lottoTicket.getLottoTicket().getFirst().getLottoNumbers())
                        .containsExactlyElementsOf(expectedLotto.getLottoNumbers()),
                () -> assertThat(lottoTicket.getLottoTicket().get(1).getLottoNumbers())
                        .containsExactlyElementsOf(expectedLotto.getLottoNumbers())
        );
    }
}
