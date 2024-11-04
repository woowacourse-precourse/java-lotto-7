package io.lotto;

import lotto.Lotto;
import lotto.LottoMachine;
import lotto.type.WinType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutPutLottoHandlerTest {

    private final OutPutLottoHandler outPutLottoHandler = new OutPutLottoHandler();
    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("생성된 로또 번호들 출력 확인")
    @Test
    void checkNumbers() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(40, 41, 42, 43, 44, 45));
        Lotto lotto3 = new Lotto(List.of(20, 21, 22, 23, 24, 25));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);

        // when
        List<String> lottoNumbers = outPutLottoHandler.showLottos(lottos);

        // then
        assertThat(lottoNumbers).hasSize(3)
                .containsExactlyInAnyOrder(
                        "1, 2, 3, 4, 5, 6",
                        "40, 41, 42, 43, 44, 45",
                        "20, 21, 22, 23, 24, 25"
                );
    }

    @DisplayName("당첨 금액 콤마 형식의 문자로 변환")
    @Test
    void convertLottoWinningsToStringBy() {
        // given
        WinType winType = WinType.FIRST;

        // when
        String result = outPutLottoHandler.convertLottoWinningsToStringBy(winType);

        // then
        assertThat(result).isEqualTo("2,000,000,000");
    }
    
    @DisplayName("수익률 구하는 로직 테스트")
    @Test
    void getProfitRate() {
        // given
        int price = 8000;
        int profit = 5000;

        // when
        String profitRate = outPutLottoHandler.getProfitRate(price, profit);

        // then
        assertThat(profitRate).isEqualTo("62.5");
    }
}