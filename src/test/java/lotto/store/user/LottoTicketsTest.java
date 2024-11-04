package lotto.store.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import lotto.util.RandomNumber;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    void 로또_티켓의_번호를_확인할_수_있다() {
        //given
        List<Lotto> lottos = IntStream.range(0, 8)
            .mapToObj(i -> Lotto.from(
                RandomNumber.getUniqueNumbers(1, 45, 6)
            ))
            .toList();

        //when
        LottoTickets lottoTickets = LottoTickets.from(lottos);

        //then
        assertThat(lottoTickets.toString()).containsAnyOf("[", "]");
    }

}
