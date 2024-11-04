package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lotto.controller.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoPurchaseHistory;
import lotto.model.enums.Rank;
import lotto.model.lottoInfo.LottoGame;
import lotto.model.lottoInfo.PrizeDataImpl;
import lotto.model.lottoInfo.StandardLottoPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private final LottoService service = new LottoService();
    private LottoGame game;

    @BeforeEach
    void setUp() {
        game = new LottoGame(new StandardLottoPrice(), new PrizeDataImpl());
        game.enterWinningNumber(List.of(1, 2, 3, 4, 5, 6));
        game.enterBonusNumber(7);
    }

    @DisplayName("로또 구매 요청 시 지정된 개수만큼의 로또를 생성한다")
    @Test
    void 로또_구매_요청_시_지정된_개수만큼의_로또를_생성한다() {
        //given
        int purchaseCount = 10;

        //when
        LottoPurchaseHistory lottoPurchaseHistory = service.buyLotto(purchaseCount);

        //then
        assertThat(lottoPurchaseHistory.getPurchaseHistory())
                .hasSize(purchaseCount);
    }

    @DisplayName("로또를 진행하면 로또 결과를 반환한다")
    @Test
    void 로또를_진행하면_로또_결과를_반환한다() {
        //given
        List<Lotto> purchasedLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        LottoPurchaseHistory lottoPurchaseHistory = new LottoPurchaseHistory(purchasedLotto);

        //when
        LottoResult result = service.playLottoGame(game, lottoPurchaseHistory);

        //then
        assertThat(result.ranks()).contains(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.NONE);
        assertThat(result.ranks()).hasSize(4);
    }

    @DisplayName("돈과 결과를 통해 수익률을 계산할 수 있다")
    @Test
    void 돈과_결과를_통해_수익률을_계산할_수_있다() {
        //given
        int purchaseMoney = 5000;
        LottoResult lottoResult = new LottoResult(List.of(Rank.THIRD, Rank.NONE));

        //when
        BigDecimal serviceRate = service.calculatePrizeRate(game, lottoResult, purchaseMoney);

        //then
        BigDecimal rate = BigDecimal.valueOf(1500000)
                .multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(purchaseMoney), 2, RoundingMode.HALF_UP);

        assertThat(serviceRate).isEqualTo(rate);
    }
}