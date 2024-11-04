package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.RequestUrl;
import lotto.model.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DispatcherServletTest {

    @DisplayName("랜덤 로또 구입 컨트롤러 호출")
    @Test
    void randomLottoPurchaseMap() {
        // given
        HandlerMapper mapper = new HandlerMapper();
        Request request = new Request(RequestUrl.PURCHASE_RANDOM_LOTTO);
        // when & then
        assertThat(mapper.getController(request.getUrl()))
                .isInstanceOf(RandomLottoPurchaseController.class);
    }

    @DisplayName("당첨 로또 초기화 컨트롤러 호출")
    @Test
    void winningLottoMap() {
        // given
        HandlerMapper mapper = new HandlerMapper();
        Request request = new Request(RequestUrl.INIT_WINNING_LOTTO);
        // when & then
        assertThat(mapper.getController(request.getUrl()))
                .isInstanceOf(WinningLottoController.class);
    }

    @DisplayName("로또 당첨 통계 계산 컨트롤러 호출")
    @Test
    void resultCalculatorMap() {
        // given
        HandlerMapper mapper = new HandlerMapper();
        Request request = new Request(RequestUrl.CALCULATE_RESULT);
        // when & then
        assertThat(mapper.getController(request.getUrl()))
                .isInstanceOf(LottoResultController.class);
    }
}