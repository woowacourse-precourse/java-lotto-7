package lotto.service;

import lotto.model.domain.*;
import lotto.model.service.LottoRateService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;

public class LottoRateServiceTest {

    @ParameterizedTest
    @MethodSource("당첨상태_데이터")
    void 당첨_상태_테스트(List<Integer> lotto, List<Integer> winningNumber, int bonus, String expectedResult) {
        LottoRateService lottoRateService = new LottoRateService();

        Lottos lottos = new Lottos(List.of(new Lotto(lotto)));
        WinningNumbers winningNumbers = new WinningNumbers(winningNumber);
        BonusNumber bonusNumber = new BonusNumber(bonus, winningNumbers);

        Rate rate = lottoRateService.calculateRate(lottos, winningNumbers, bonusNumber);

        assertThat(rate.getMatchStatus().get(expectedResult)).isEqualTo(1);  // 해당 상태의 당첨 개수 확인
    }

    // 테스트 데이터 공급 메서드
    static Stream<Arguments> 당첨상태_데이터() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 7, 8, 9),  //실패 상황 가정 
                        List.of(1, 2, 3, 7, 11, 12),
                        13,
                        "three_match"
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 8, 9),
                        List.of(1, 2, 3, 4, 10, 11),
                        13,
                        "four_match"
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 8),
                        List.of(1, 2, 3, 4, 5, 12),
                        8,
                        "five_bonus_match"
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 9),
                        List.of(1, 2, 3, 4, 5, 12),
                        8,
                        "five_match"
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        7,
                        "six_match"
                )
        );
    }
}
