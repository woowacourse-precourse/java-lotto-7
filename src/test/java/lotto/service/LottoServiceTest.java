package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("MoneyDTO의 티켓 수만큼 로또 목록이 생성되는지 테스트")
    void 로또_목록_개수_확인() {
        MoneyDTO moneyDTO = new MoneyDTO(8000);
        LottoDTO lottoDTO = lottoService.makeLottos(moneyDTO);

        List<Lotto> lottos = lottoDTO.getLottos();
        assertThat(lottoDTO.getLottos().size()).isEqualTo(8);
    }

    @Test
    @DisplayName("각 로또가 6개의 번호를 가지는지 테스트")
    void 로또_개수_확인() {
        MoneyDTO moneyDTO = new MoneyDTO(2000);
        LottoDTO lottoDTO = lottoService.makeLottos(moneyDTO);

        lottoDTO.getLottos().forEach(lotto ->
                assertThat(lotto.getLotto().size()).isEqualTo(6)
        );
    }

    @Test
    @DisplayName("각 로또 번호가 오름차순으로 정렬되어 있는지 테스트")
    void 오름차순_정렬_테스트() {
        MoneyDTO moneyDTO = new MoneyDTO(2000);
        LottoDTO lottoDTO = lottoService.makeLottos(moneyDTO);

        lottoDTO.getLottos().forEach(lotto -> {
            List<Integer> lottoNumbers = lotto.getLotto();

            List<Integer> sortedNumbers = lottoNumbers.stream().sorted().collect(Collectors.toList());
            assertThat(lottoNumbers).isEqualTo(sortedNumbers);
        });
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 번호 수를 세어 각 랭크 카운트 업데이트")
    void 당첨번호_맞는_개수_확인() {

        LottoDTO lottoDTO = new LottoDTO(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 5개 + 보너스 일치
                new Lotto(List.of(1, 2, 3, 4, 8, 9)), // 4개 일치
                new Lotto(List.of(1, 2, 3, 10, 11, 12)) // 3개 일치
        ));
        CorrectDTO correctDTO = new CorrectDTO(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        correctDTO.setBonus(7);

        lottoService.countMatchingNumbers(correctDTO, lottoDTO);

        assertThat(LottoRank.SIX.getCount()).isEqualTo(1);
        assertThat(LottoRank.FIVE_BONUS.getCount()).isEqualTo(1);
        assertThat(LottoRank.FOUR.getCount()).isEqualTo(1);
        assertThat(LottoRank.THREE.getCount()).isEqualTo(1);

        LottoRank.resetCounts();
    }

    @Test
    @DisplayName("각 랭크별 상금을 합산하여 총 당첨금을 계산")
    void 상금_합산_테스트() {

        LottoRank.SIX.setCount(1);           // 6개 일치 1개 (2,000,000,000원)
        LottoRank.FIVE_BONUS.setCount(1);    // 5개 + 보너스 1개 (30,000,000원)
        LottoRank.FOUR.setCount(1);          // 4개 일치 1개 (50,000원)
        LottoRank.THREE.setCount(1);         // 3개 일치 1개 (5,000원)

        BigDecimal totalPrize = lottoService.calculateTotalPrize();

        BigDecimal expectedPrize = BigDecimal.valueOf(2000000000 + 30000000 + 50000 + 5000);
        assertThat(totalPrize).isEqualTo(expectedPrize);

        LottoRank.resetCounts();
    }

    @Test
    @DisplayName("투자 금액 대비 수익률 계산")
    void 수익률_계산_테스트() {

        MoneyDTO moneyDTO = new MoneyDTO(5000);
        LottoRank.THREE.setCount(1);

        RateOfReturnDTO rateOfReturnDTO = lottoService.calculateRateOfReturn(moneyDTO);

        BigDecimal expectedRateOfReturn = BigDecimal.valueOf(100.0);
        assertThat(rateOfReturnDTO.getRateOfReturn()).isEqualTo(expectedRateOfReturn);

        LottoRank.resetCounts();
    }
}