package lotto.model.lottoInfo;

import static lotto.model.enums.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.controller.dto.LottoResult;
import lotto.controller.dto.PrizeResultInfo;
import lotto.controller.dto.PrizeResultsDto;
import lotto.model.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {
    private LottoGame game;

    @BeforeEach
    void setUp() {
        game = new LottoGame(new StandardLottoPrice(), new PrizeDataImpl());
        game.enterWinningNumber(List.of(1, 2, 3, 4, 5, 6));
        game.enterBonusNumber(7);
    }

    @DisplayName("당첨 번호를 입력할 수 있다")
    @Test
    void 당첨_번호를_입력할_수_있다() {
        //given
        List<Integer> winningNumber = List.of(7, 8, 9, 10, 11, 12);

        //when
        game.enterWinningNumber(winningNumber);

        //then
        assertThat(game.getWinningNumbers())
                .containsExactly(7, 8, 9, 10, 11, 12);
    }

    @DisplayName("보너스 번호를 입력할 수 있다")
    @Test
    void 보너스_번호를_입력할_수_있다() {
        //given
        int bonusNumber = 1;

        //when
        game.enterBonusNumber(bonusNumber);

        //then
        assertThat(game.getBonusNumber())
                .isEqualTo(bonusNumber);
    }

    @DisplayName("로또의 당첨 결과를 반환할 수 있다")
    @Test
    void 로또의_당첨_결과를_반환할_수_있다() {
        //given
        List<Integer> FirstNumber = List.of(1, 2, 3, 4, 5, 6);

        //when
        Rank rank = game.calculateRank(FirstNumber);

        //then
        assertThat(rank).isEqualTo(FIRST);
    }

    @DisplayName("총 상금을 계산할 수 있다")
    @Test
    void 총_상금을_계산할_수_있다() {
        //given
        LottoResult lottoResult = new LottoResult(List.of(THIRD, THIRD, NONE));

        //when
        long totalPrize = game.calculateTotalPrize(lottoResult.ranks());

        //then
        assertThat(totalPrize).isEqualTo(3000000);
    }

    @DisplayName("로또 경기 결과를 반환할 수 있다")
    @Test
    void 로또_경기_결과를_반환할_수_있다() {
        //given
        LottoResult result = new LottoResult(List.of(THIRD, THIRD, NONE));

        //when
        PrizeResultsDto prizeResult = game.getPrizeResult(result);

        //then
        List<PrizeResultInfo> resultInfos = prizeResult.results();
        assertThat(resultInfos)
                .anyMatch(info ->
                        info.condition()
                                .equals(THIRD.getMessage())
                                && info.count()
                                .equals(2));
    }
}