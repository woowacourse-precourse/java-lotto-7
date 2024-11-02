package lotto.application.in;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.Application;
import lotto.config.context.ApplicationContext;
import lotto.domain.core.Lotto;
import lotto.domain.core.LottoRank;
import lotto.domain.input.BonusNumber;
import lotto.domain.input.PurchaseAmount;
import lotto.domain.input.WinningNumber;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoUseCaseTest {

    private final LottoUseCase lottoUseCase;

    public LottoUseCaseTest() {
        lottoUseCase = ApplicationContext.getInstance(Application.class)
                .getBean(LottoUseCase.class);
    }

    @Test
    @DisplayName("금액에 알맞는 로또 개수를 반환한다.")
    void 금액에_알맞는_로또_개수를_반환한다() {
        // Given
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        // When
        LottoRound round = lottoUseCase.buyLotto(purchaseAmount);

        // Then
        assertThat(round).isNotNull();
        assertThat(round.getLottoCount()).isEqualTo(8);
    }

    @Test
    @DisplayName("알맞는 로또 결과를 반환한다")
    void 알맞는_로또_결과를_반환한다() {
        // Given
        LottoRound round = new LottoRound(List.of(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(1, 2, 3, 4, 5, 7),
                new Lotto(1, 2, 3, 4, 5, 8)
        ));
        WinningNumber winningNumber = new WinningNumber(1, 2, 3, 6, 10, 11);
        BonusNumber bonusNumber = new BonusNumber(8);

        // When
        LottoRoundResult result = lottoUseCase.checkResult(round, winningNumber, bonusNumber);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.getRankCount(LottoRank.MATCH_THREE_NUMBER)).isEqualTo(2);
        assertThat(result.getRankCount(LottoRank.MATCH_FOUR_NUMBER)).isEqualTo(1);
    }
}