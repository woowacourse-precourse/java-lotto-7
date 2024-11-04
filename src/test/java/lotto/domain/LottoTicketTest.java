package lotto.domain;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    void 로또_티켓_생성_시_불변성_유지() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        LottoTicket lottoTicket = new LottoTicket(lottos);

        assertThat(lottoTicket.getLottos()).isEqualTo(lottos);

        assertThatThrownBy(() -> lottoTicket.getLottos().add(new Lotto(List.of(13, 14, 15, 16, 17, 18))))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void getLottos_메서드가_올바른_로또_리스트를_반환하는지_테스트() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );

        LottoTicket lottoTicket = new LottoTicket(lottos);

        assertThat(lottoTicket.getLottos()).containsExactlyElementsOf(lottos);
    }
}
