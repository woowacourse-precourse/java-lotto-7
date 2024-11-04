package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.LottoConstants;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    private final LottoService service = new LottoService();

    @Test
    void 구입_장수_계산() {
        String purchaseAmount = "8000";
        assertThat(service.calculateLottoCount(purchaseAmount)).isEqualTo(8);
    }

    @Test
    void 로또_객체_생성() {
        int lottoCount = 5;
        List<Lotto> result = service.generateAutoLottoNumbers(lottoCount);
        assertThat(result.size()).isEqualTo(5);
        result.forEach(lotto -> assertThat(lotto.getNumbers().size()).isEqualTo(6));
    }

    @Test
    void 당첨_번호_반환() {
        String winningNumber = "1,2,5,6,7,11";
        List<Integer> expected = Arrays.asList(1, 2, 5, 6, 7, 11);
        assertThat(service.changeWinningNumbers(winningNumber)).isEqualTo(expected);
    }

    @Test
    void 예외_당첨_번호_반환_빈_입력() {
        String winningNumber = "";
        assertThatThrownBy(() -> service.changeWinningNumbers(winningNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 예외_당첨_번호_반환_구분자_오류() {
        String winningNumber = "12567:11";
        assertThatThrownBy(() -> service.changeWinningNumbers(winningNumber)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 당첨_통계() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        String bonusNumber = "7";
        List<Lotto> generatedLottoNumbers = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Lotto(Arrays.asList(1, 3, 5, 7, 9, 11)));

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(3, 2);
        expected.put(4, 0);
        expected.put(5, 0);
        expected.put(6, 1);
        expected.put(7, 0);

        Map<Integer, Integer> result = service.calculateLottoStatistics(winningNumbers, bonusNumber,
                generatedLottoNumbers);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 수익_계산() {
        Map<Integer, Integer> lottoStatistics = new HashMap<>();
        lottoStatistics.put(3, 1);
        lottoStatistics.put(4, 0);
        lottoStatistics.put(5, 1);
        lottoStatistics.put(6, 1);
        lottoStatistics.put(7, 0);

        int expected = LottoConstants.THREE_MATCHED_PRIZE + LottoConstants.FIVE_MATCHED_PRIZE
                + LottoConstants.SIX_MATCHED_PRIZE;
        assertThat(service.calculateProfits(lottoStatistics)).isEqualTo(expected);
    }

    @Test
    void 수익률_계산() {
        int lottoCount = 10;
        int lottoSum = 5000;

        double expectedRate = (double) lottoSum / (lottoCount * LottoConstants.PURCHASE_UNIT) * 100;
        expectedRate = new BigDecimal(expectedRate).setScale(2, RoundingMode.HALF_UP).doubleValue();

        assertThat(service.calculateRateOfReturn(lottoCount, lottoSum)).isEqualTo(expectedRate);
    }

}