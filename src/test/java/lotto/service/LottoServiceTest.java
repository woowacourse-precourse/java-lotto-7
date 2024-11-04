package lotto.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.enums.Prize;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private LottoService lottoService;
    private String purchaseAmount;
    private List<Lotto> lottos;
    private String winningNumbers;
    private String bonusNumber;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        purchaseAmount = "8000";
        winningNumbers = "8, 21, 23, 1, 2, 3";
        bonusNumber = "16";
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(8, 21, 23, 1, 2, 16)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45))
        );
    }

    @Test
    @DisplayName("구입한 금액만큼 로또 개수가 올바르게 생성 되는지 확인")
    void 로또_구입_금액_생성_테스트() {
        // when
        List<Lotto> lottos = lottoService.generateLotto(purchaseAmount);

        // then
        assertThat(lottos).hasSize(8);
    }

    @Test
    @DisplayName("구입한 로또들의 당첨 여부를 판별 - 일반 케이스")
    void 당첨_확인_일반_케이스_테스트() {
        // when
        Map<Prize, Integer> finalResult = lottoService.determineFinalResults(winningNumbers, bonusNumber, lottos);

        // then
        AssertionsForClassTypes.assertThat(finalResult.get(Prize.SIX_MATCH)).isEqualTo(0);
        AssertionsForClassTypes.assertThat(finalResult.get(Prize.FIVE_MATCH)).isEqualTo(0);
        AssertionsForClassTypes.assertThat(finalResult.get(Prize.FOUR_MATCH)).isEqualTo(0);
        AssertionsForClassTypes.assertThat(finalResult.get(Prize.THREE_MATCH)).isEqualTo(1);
    }

    @Test
    @DisplayName("구입한 로또들의 당첨 여부를 판별 - 보너스 케이스")
    void 당첨_확인_보너스_케이스_테스트() {
        // when
        Map<Prize, Integer> finalResult = lottoService.determineFinalResults(winningNumbers, bonusNumber, lottos);

        // then
        AssertionsForClassTypes.assertThat(finalResult.get(Prize.SIX_MATCH)).isEqualTo(0);
        AssertionsForClassTypes.assertThat(finalResult.get(Prize.FIVE_MATCH)).isEqualTo(0);
        AssertionsForClassTypes.assertThat(finalResult.get(Prize.FOUR_MATCH)).isEqualTo(0);
        AssertionsForClassTypes.assertThat(finalResult.get(Prize.FIVE_BONUS_MATCH)).isEqualTo(1);
    }

    @Test
    @DisplayName("최종 결과 계산이 올바른지 확인")
    void 최종_결과_테스트() {
        // when
        Map<Prize, Integer> matchCounts = lottoService.determineFinalResults(winningNumbers, bonusNumber, lottos);
        BigDecimal calculatedRate = lottoService.calculateRate(matchCounts, purchaseAmount);

        // Debugging output
        System.out.println("Calculated Rate: " + calculatedRate);

        // then
        AssertionsForClassTypes.assertThat(calculatedRate).isEqualTo(new BigDecimal("375062.5"));
    }
}