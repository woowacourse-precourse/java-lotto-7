package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lotto.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
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
            assertThat(numbers.size()).isEqualTo(LOTTO_NUMBERS_COUNT);
            assertThat(numbers.stream()
                    .allMatch(number -> number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER)).isTrue();
        }
    }
}