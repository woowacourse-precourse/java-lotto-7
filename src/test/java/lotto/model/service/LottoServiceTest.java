package lotto.model.service;

import lotto.dto.LottoDto;
import lotto.dto.LottoWinningNumbersDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("유효한 금액으로 로또를 구매하여 LottosDto를 반환한다")
    void givenValidAmount_whenBuyingLottos_thenReturnsLottosDto() {
        // given
        long purchaseAmount = 5000; // LOTTO_PRICE의 배수로 테스트

        // when
        LottosDto lottosDto = lottoService.buyLottos(purchaseAmount);

        // then
        assertNotNull(lottosDto);
        assertEquals(5, lottosDto.lottos().size()); // 5000원으로 5개의 로또 구매 가능
    }


    @ParameterizedTest(name = "매칭 번호 개수={0}, 보너스 일치={1}, 예상 등수={2}")
    @DisplayName("주어진 매칭 번호 개수와 보너스 일치 여부에 따라 올바른 랭크를 반환한다")
    @CsvSource({
            "6, false, 1",  // 6개 일치, 보너스 미일치 -> 1등 (보너스 무의미)
            "5, true, 2",   // 5개 일치, 보너스 일치 -> 2등
            "5, false, 3",  // 5개 일치, 보너스 미일치 -> 3등
            "4, true, 4",   // 4개 일치, 보너스 일치 -> 4등 (보너스 무의미)
            "4, false, 4",  // 4개 일치, 보너스 미일치 -> 4등
            "3, true, 5",   // 3개 일치, 보너스 일치 -> 5등 (보너스 무의미)
            "3, false, 5",  // 3개 일치, 보너스 미일치 -> 5등
            "2, true, 0",   // 2개 이하 일치, 보너스 일치 -> 당첨 없음
            "0, false, 0"   // 0개 일치, 보너스 미일치 -> 당첨 없음
    })
    void givenMatchCountAndBonusMatch_whenCalculatingResults_thenReturnsCorrectRank(int matchCount, boolean bonusMatch, int expectedRank) {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        List<Integer> testNumbers;
        switch (matchCount) {
            case 6:
                testNumbers = List.of(1, 2, 3, 4, 5, 6); // 6개 일치 (보너스 번호 상관없음)
                break;
            case 5:
                testNumbers = bonusMatch ? List.of(1, 2, 3, 4, 5, 7) : List.of(1, 2, 3, 4, 5, 8); // 5개 일치 + 보너스 여부
                break;
            case 4:
                testNumbers = bonusMatch ? List.of(1, 2, 3, 4, 7, 8) : List.of(1, 2, 3, 4, 9, 10); // 4개 일치 + 보너스 여부
                break;
            case 3:
                testNumbers = bonusMatch ? List.of(1, 2, 3, 7, 8, 9) : List.of(1, 2, 3, 10, 11, 12); // 3개 일치 + 보너스 여부
                break;
            default:
                testNumbers = bonusMatch ? List.of(7, 8, 9, 10, 11, 12) : List.of(13, 14, 15, 16, 17, 18); // 당첨 없음
                break;
        }

        LottoWinningNumbersDto winningNumbersDto = new LottoWinningNumbersDto(new LottoDto(winningNumbers), bonusNumber);
        LottosDto purchasedLottosDto = new LottosDto(List.of(new LottoDto(testNumbers)));

        // when
        List<RankResultDto> rankResults = lottoService.calculateResults(winningNumbersDto, purchasedLottosDto);

        // then
        assertNotNull(rankResults);
        assertEquals(1, rankResults.size());
        assertEquals(expectedRank, rankResults.get(0).rank());
    }

    @Test
    @DisplayName("랭크 결과를 입력하여 수익률을 정확히 계산한다")
    void givenRankResults_whenCalculatingProfitRate_thenReturnsCorrectProfitRate() {
        // given
        List<RankResultDto> rankResults = List.of(
                new RankResultDto(1), // 1등 당첨
                new RankResultDto(3)  // 3등 당첨
        );

        // when
        double profitRate = lottoService.calculateProfitRate(rankResults);

        // then
        assertTrue(profitRate > 0);
    }
}