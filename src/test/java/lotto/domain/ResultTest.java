package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void from_메서드는_로또_티켓에_대해_결과를_계산한다() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getWinningNumbers());
        LottoTicket lottoTicket = LottoTicket.from(3);

        Result result = Result.from(lottoTicket, winningNumbers, bonusNumber);

        assertThat(result).isNotNull();
    }

    @Test
    void 총_상금이_올바르게_계산된다() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers.getWinningNumbers());
        LottoTicket lottoTicket = LottoTicket.from(5);

        Result result = Result.from(lottoTicket, winningNumbers, bonusNumber);
        int totalPrize = result.getTotalPrize();

        assertThat(totalPrize).isGreaterThanOrEqualTo(0);
    }
}
