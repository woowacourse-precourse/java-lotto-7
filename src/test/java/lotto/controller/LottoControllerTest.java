package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

   private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("입력받은 금액이 1000원 단위로 떨어지지 않는 경우")
    void 원_단위로_나눠지지않은_경우() {
        assertThatThrownBy(() -> new MoneyDTO(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 금액이 0원인 경우")
    void getMoneyAndReturn() {
        assertThatThrownBy(() -> new MoneyDTO(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("올바르지 않은 당첨번호를 입력받은 경우")
    void 올바르지_않은_당첨번호_입력() {
        assertThatThrownBy(()->new CorrectDTO(new Lotto(Arrays.asList(1,2,3,4,5,46))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 45이하의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("올바르지 않은 보너스 번호를 입력받은 경우")
    void 올바르지_않은_보너스번호_입력() {
        CorrectDTO correctDTO = new CorrectDTO(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThatThrownBy(() -> correctDTO.setBonus(46)) // 45 초과하는 보너스 번호 설정
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 45이하의 숫자여야 합니다.");
    }


    @Test
    @DisplayName("수익률 계산 확인")
    void 수익률_계산_확인() {
        MoneyDTO moneyDTO = new MoneyDTO(2000);
        LottoRank.THREE.setCount(1);
        RateOfReturnDTO rateOfReturnDTO = lottoService.calculateRateOfReturn(moneyDTO);
        assertThat(rateOfReturnDTO.getRateOfReturn()).isEqualTo(BigDecimal.valueOf(250.0).setScale(1, RoundingMode.HALF_UP));

        // 테스트 후 LottoRank의 count 초기화
        LottoRank.resetCounts();
    }
}