package lotto.domain.matcher;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.prize.LottoPrize;
import lotto.domain.prize.LottoResult;
import lotto.domain.ticket.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketMatcherTest {

    private LottoTicketMatcher lottoTicketMatcher;

    @BeforeEach
    void setUp() {
        lottoTicketMatcher = new LottoTicketMatcher();
    }

    @DisplayName("구입한 로또와 당첨 로또를 비교해 결과를 반환하는 테스트")
    @Test
    void matchLotto_winningLotto_returnLottoResult() {
        Lotto purchasedLotto1 = createLotto(1, 2, 3, 4, 5, 6);
        Lotto purchasedLotto2 = createLotto(11, 12, 13, 14, 15, 16);
        Lotto winning = createLotto(1, 2, 3, 12, 13, 14);

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(purchasedLotto1, purchasedLotto2));
        WinningLotto winningLotto = new WinningLotto(winning, new LottoNumber(45));

        LottoResult lottoResult = lottoTicketMatcher.matchLottoTicket(lottoTicket, winningLotto);
        assertThat(lottoResult.getLottoResult().get(LottoPrize.FIFTH_PRIZE)).isEqualTo(2);
    }

    @DisplayName("보너스 볼 테스트")
    @Test
    void matchLotto_winningLottoAndBonusBallMatches_returnSecondLottoResult() {
        Lotto purchasedLotto1 = createLotto(1, 2, 3, 4, 5, 6);
        Lotto purchasedLotto2 = createLotto(11, 12, 13, 14, 15, 16);
        Lotto winning = createLotto(1, 2, 3, 4, 5, 11);

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(purchasedLotto1, purchasedLotto2));
        WinningLotto winningLotto = new WinningLotto(winning, new LottoNumber(6));

        LottoResult lottoResult = lottoTicketMatcher.matchLottoTicket(lottoTicket, winningLotto);
        assertThat(lottoResult.getLottoResult().get(LottoPrize.SECOND_PRIZE)).isEqualTo(1);
    }

    private Lotto createLotto(Integer... numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .map(LottoNumber::new)
                .toList();
        return new Lotto(lottoNumbers);
    }

    @DisplayName("3등 테스트")
    @Test
    void matchLotto_thirdPrizeLotto_returnThirdLottoResult() {
        Lotto purchasedLotto1 = createLotto(1, 2, 3, 4, 5, 6);
        Lotto purchasedLotto2 = createLotto(1, 2, 3, 4, 5, 7);
        Lotto winning = createLotto(1, 2, 3, 4, 5, 11);

        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(purchasedLotto1, purchasedLotto2));
        WinningLotto winningLotto = new WinningLotto(winning, new LottoNumber(9));

        LottoResult lottoResult = lottoTicketMatcher.matchLottoTicket(lottoTicket, winningLotto);
        assertThat(lottoResult.getLottoResult().get(LottoPrize.THIRD_PRIZE)).isEqualTo(2);
    }
}
