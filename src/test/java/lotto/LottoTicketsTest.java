package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    void 로또_티켓의_번호를_확인할_수_있다() {
        //given
        List<Lotto> lottos = IntStream.range(0, 8)
            .mapToObj(i -> new Lotto(
                RandomNumber.getUniqueNumbers(1, 45, 6)
            ))
            .toList();

        //when
        LottoTickets lottoTickets = new LottoTickets(lottos);

        //then
        assertThat(lottoTickets.toString()).containsAnyOf("[", "]");
    }

}
