package lotto;

import lotto.domain.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @DisplayName("로또 갯수 계산 테스트")
    @Test
    void 로또_갯수_계산_테스트() {
        LottoGame lottoGame = new LottoGame(8000);
        assertThat(lottoGame.getLottoCount()).isEqualTo(8);
    }

    @DisplayName("구매 금액 만큼 로또 생성 테스트")
    @Test
    void 구매_금액_만큼_로또_생성_테스트() {
        LottoGame lottoGame = new LottoGame(10000);
        assertThat(lottoGame.getGeneratedLottos().size()).isEqualTo(10);
    }

}
