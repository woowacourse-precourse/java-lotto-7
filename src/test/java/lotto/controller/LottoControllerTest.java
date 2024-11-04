package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.LottoTicketsDto;
import lotto.dto.MoneyDto;
import lotto.service.LottoService;
import lotto.viewer.MockViewer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @Test
    @DisplayName("다른 에러로 동작이 정지되고 에러를 반환한다.")
    void test1() {
        LottoController lottoController = new LottoController(new LottoService() {
            @Override
            public MoneyDto createMoney(String money) {
                throw new IllegalStateException();
            }

            @Override
            public LottoTicketsDto generateLottoTickets() {
                return null;
            }
        }, new MockViewer());

        assertThatThrownBy(lottoController::getMoney).isInstanceOf(IllegalStateException.class);
    }
}
