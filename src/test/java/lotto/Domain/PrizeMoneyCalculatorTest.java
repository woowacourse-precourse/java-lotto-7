package lotto.Domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.DTO.BonusNumberDTO;
import lotto.DTO.LottoStatisticsDTO;
import lotto.DTO.RandomLottoNumberDTO;
import lotto.DTO.WinningNumberDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeMoneyCalculatorTest {

    private PrizeMoneyCalculator prizeMoneyCalculator;
    private WinningNumberDTO winningNumberDTO;
    private BonusNumberDTO bonusNumberDTO;
    private RandomLottoNumberDTO randomLottoNumberDTO;

    @BeforeEach
    void setUp() {
        // given: 로또 구매 개수와 당첨 번호, 보너스 번호, 구매한 로또 티켓 설정
        prizeMoneyCalculator = new PrizeMoneyCalculator(4);
        winningNumberDTO = new WinningNumberDTO(List.of(8, 21, 23, 41, 42, 43));
        bonusNumberDTO = new BonusNumberDTO(16);
        randomLottoNumberDTO = new RandomLottoNumberDTO(
                new LottoTickets(List.of(
                        new Lotto(List.of(8, 21, 23, 41, 42, 43)), // 6개 일치
                        new Lotto(List.of(8, 21, 23, 41, 42, 16)), // 5개 + 보너스 일치
                        new Lotto(List.of(8, 21, 23, 41, 16, 17)), // 4개 일치
                        new Lotto(List.of(8, 21, 23, 15, 18, 19))  // 3개 일치
                ))
        );
    }

    @DisplayName("랜덤한 로또의 번호와 당첨 번호의 일치 개수를 계산한다.")
    @Test
    void calculatePrizeStatistics_일치_개수_계산() {
        // when: 일치 개수를 계산
        prizeMoneyCalculator.calculatePrizeStatistics(winningNumberDTO, bonusNumberDTO, randomLottoNumberDTO);
        LottoStatisticsDTO result = prizeMoneyCalculator.calculateProfitRate();

        // then: 각 일치 개수가 예상대로 나오는지 검증
        assertThat(result.getMatched3Count()).isEqualTo(1);
        assertThat(result.getMatched4Count()).isEqualTo(1);
        assertThat(result.getMatched5Count()).isEqualTo(0);
        assertThat(result.getMatched5WithBonusCount()).isEqualTo(1);
        assertThat(result.getMatched6Count()).isEqualTo(1);
    }

    @DisplayName("랜덤한 로또의 번호와 당첨 번호의 일치 개수를 바탕으로 수익률을 계산한다.")
    @Test
    void calculateProfitRate_수익률_계산() {
        // given: 로또 일치 개수를 계산하도록 설정
        prizeMoneyCalculator.calculatePrizeStatistics(winningNumberDTO, bonusNumberDTO, randomLottoNumberDTO);

        // when: 수익률을 계산
        LottoStatisticsDTO result = prizeMoneyCalculator.calculateProfitRate();
        String formattedProfitRate = String.format("총 수익률은 %.1f%%입니다.", result.getProfitRate());

        // then: 예상 수익률과 일치하는지 검증
        assertThat(formattedProfitRate).isEqualTo("총 수익률은 50751375.0%입니다.");
    }
}
