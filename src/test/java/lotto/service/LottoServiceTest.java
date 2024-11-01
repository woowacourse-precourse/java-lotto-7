package lotto.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private final LottoService lottoService = new LottoServiceImpl();

    @Test
    void 로또_구입_정상_금액_입력_시_로또_장수_반환_테스트() {
        String purchaseAmount = "5000";
        int expectedLottoCount = 5;

        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);

        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }

    @Test
    void 당첨_번호_입력값_파싱_테스트() {
        String winningNumbersInput = "1, 2, 3, 4, 5, 6";
        List<Integer> expectedWinningNumbers = List.of(1, 2, 3, 4, 5, 6);

        List<Integer> parsedWinningNumbers = lottoService.parseWinningNumbers(winningNumbersInput);

        assertThat(parsedWinningNumbers).isEqualTo(expectedWinningNumbers);
    }
}
