package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.utils.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSystemTest {
    private LottoSystem lottoSystem;
    private PurchasePrice purchasePrice;

    @BeforeEach
    public void setUp() {
        lottoSystem = new LottoSystem();
        purchasePrice = new PurchasePrice("10000");
    }

    @DisplayName("로또 티켓의 상태와 크기를 올바르게 반환한다.")
    @Test
    void 로또_티켓의_상태와_크기를_올바르게_반환한다() {
        int lottoQuantity = purchasePrice.getLottoTicketCount();

        Lottos lottos = lottoSystem.generateLottos(purchasePrice);

        assertThat(lottos.getLottos().size()).isEqualTo(lottoQuantity);
    }

    @DisplayName("구매가격에 대해 올바른 수익률 객체를 반환한다.")
    @Test
    void 구매가격에_대해_올바른_수익률_객체를_반환한다() {
        String winningNumbers = "1,2,3,4,5,6";
        String bonusNumber = "7";
        Lottos lottos = lottoSystem.generateLottos(purchasePrice);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(Parser.parseWinningNumber(winningNumbers),
                bonusNumber);

        LottoProfitRate profitRate = lottoSystem.generateLottoResults(lottos, winningLottoNumber, purchasePrice);

        assertThat(profitRate).isNotNull(); //수익률 객체가 생성이 안될경우 null 반환
    }
}