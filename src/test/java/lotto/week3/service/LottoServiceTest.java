package lotto.week3.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.week3.dto.PurchaseRequestDto;
import lotto.week3.dto.WinningNumberRequestDto;
import lotto.week3.domain.LottoMatching;
import lotto.week3.model.LottoStatistics;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    void 로또_발행_수량_확인() {
        // Given
        LottoService lottoService = new LottoService();
        PurchaseRequestDto purchaseRequestDto = new PurchaseRequestDto(8000); // 8개의 로또 구매

        // When
        LottoMatching lottoMatching = lottoService.generatorLottos(purchaseRequestDto);

        // Then
        assertEquals(8, lottoMatching.getLottos().size(), "발행된 로또 수량이 올바르지 않습니다.");
    }


    @Test
    void 당첨_번호와_보너스_번호_매칭_통계_확인() {
        // Given
        LottoService lottoService = new LottoService();
        PurchaseRequestDto purchaseRequestDto = new PurchaseRequestDto(5000);
        LottoMatching lottoMatching = lottoService.generatorLottos(purchaseRequestDto);

        // 설정된 당첨 번호와 보너스 번호
        WinningNumberRequestDto winningNumber = new WinningNumberRequestDto(
                List.of(1, 2, 3, 4, 5, 6), 7
        );

        // When
        lottoService.calculateWinningStatistics(lottoMatching, winningNumber);

        // Then
        // 통계 객체에서 예상 당첨 결과를 확인 (예: 특정 일치 개수가 있는지 확인)
        LottoStatistics statistics = lottoMatching.getLottoStatistics();
        assertNotNull(statistics, "당첨 통계가 null입니다.");
        // 예를 들어, 3개 일치, 4개 일치 등 테스트 조건에 따라 확인할 수 있습니다.
    }


    @Test
    void 수익률_계산_확인() {
        // Given
        LottoService lottoService = new LottoService();
        LottoStatistics statistics = new LottoStatistics();

        // 당첨 로또 및 보너스 설정
        // 예시: 1등 당첨으로 2,000,000,000원 상금이 설정되어 있다고 가정

        // When
        int purchaseAmount = 8000; // 로또 구매 금액
        double yield = lottoService.calculateYied(statistics, purchaseAmount);

        // Then
        // 기대되는 수익률이 정확히 계산되었는지 확인
    }
}