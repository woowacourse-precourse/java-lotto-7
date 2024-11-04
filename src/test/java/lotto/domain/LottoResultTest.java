package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult; // 클래스 수준의 멤버 변수로 변경
    private Lotto winningNumber;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        lottoResult = new LottoResult(winningNumber, bonusNumber);
    }

    @DisplayName("당첨 결과가 올바르게 계산되는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoCases")
    void 로또_번호에_따른_당첨결과_집계_테스트(Lotto lotto, LottoPrize prize) {
        LottoPrize resultPrize = lottoResult.calculateResults(lotto);
        assertThat(resultPrize).isEqualTo(prize);
    }

    static Stream<Arguments> provideLottoCases() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1,2,3,4,5,6)), LottoPrize.MATCH_6),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,7)), LottoPrize.MATCH_5_BONUS),
                Arguments.of(new Lotto(List.of(1,2,3,4,5,10)), LottoPrize.MATCH_5),
                Arguments.of(new Lotto(List.of(1,2,3,4,10,11)), LottoPrize.MATCH_4),
                Arguments.of(new Lotto(List.of(1,2,3,10,11,12)), LottoPrize.MATCH_3),
                Arguments.of(new Lotto(List.of(1,2,10,11,12,13)), LottoPrize.NO_MATCH)
                );
    }

    @DisplayName("당청 수익률 계산 테스트")
    @Test
    void 총_당첨_수익_계산(){
        // given: 8장 구매, 3등 당첨 1장
        int purchaseCost = 8000;
        lottoResult.setResults(LottoPrize.MATCH_3);

        // when
        lottoResult.calculateTotalProfit(purchaseCost);

        // then
        assertThat(lottoResult.getTotalProfit()).isEqualTo(62.5);
    }
}
