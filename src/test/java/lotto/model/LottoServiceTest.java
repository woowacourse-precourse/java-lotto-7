package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoServiceImpl();
    }

    @DisplayName("로또 구매 금액 오류")
    @Test
    void buyLottoTest_Failure() {
        //given
        int amount = 5100;
        //when & then
        assertThatThrownBy(() -> lottoService.buyLotto(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 로또 구매 테스트")
    @Test
    void buyLottoTest_Success() {
        //given
        int amount = 5000;
        //when
        lottoService.buyLotto(amount);

        //then
        List<Lotto> lottoList = lottoService.getLottoList();
        assertThat(lottoList).hasSize(5);
    }
}
