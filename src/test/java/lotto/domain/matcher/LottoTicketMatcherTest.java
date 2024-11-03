package lotto.domain.matcher;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.LottoResult;
import lotto.domain.ticket.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketMatcherTest {

    @DisplayName("구입한 로또와 당첨 로또를 비교해 결과를 반환하는 테스트")
    @Test
    void matchLotto_winningLotto_returnLottoResult() {
        LottoTicketMatcher lottoTicketMatcher = new LottoTicketMatcher();
        Lotto lotto1 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lotto lotto2 = new Lotto(Arrays.asList(new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15), new LottoNumber(16)));
        Lotto lotto3 = new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14)));

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(lotto1, lotto2));
        WinningLotto winningLotto = new WinningLotto(lotto3, new LottoNumber(45));

        LottoResult lottoResult = lottoTicketMatcher.matchLottoTicket(lottoTicket, winningLotto);
        assertThat(lottoResult.getLottoResult().get(LottoPrize.FIFTH_PRIZE)).isEqualTo(2);
    }
}
