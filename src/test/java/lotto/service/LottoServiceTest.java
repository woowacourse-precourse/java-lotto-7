package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.common.LottoConstants;
import lotto.domain.lotto.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService lottoService = new LottoServiceImpl();

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void 로또_번호_생성_테스트() {
        //given
        String amount = "8000";

        //when
        lottoService.buyLotto(amount);
        List<LottoDto> purchasedLottos = lottoService.getPurchaseDto().getLottoDtos();

        //then
        assertThat(purchasedLottos.size()).isEqualTo(8);
        for (LottoDto lotto : purchasedLottos) {
            List<Integer> numbers = lotto.getNumbers();
            assertThat(numbers.size()).isEqualTo(LottoConstants.NUMBERS_COUNT);
            assertThat(numbers.stream()
                    .allMatch(number -> number >= LottoConstants.MIN_NUMBER
                            && number <= LottoConstants.MAX_NUMBER)).isTrue();
        }
    }
}