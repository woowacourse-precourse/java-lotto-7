package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ProfitTest {
    private final Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final BonusNumber bonusNumber = BonusNumber.from("7");
    private final WinNumber winNumber = WinNumber.of(winningNumber, bonusNumber);

    @ParameterizedTest
    @MethodSource("generateLottoData")
    void 수익률_계산을_잘_하는지_확인한다(List<Lotto> userLotto, String moneyInput, double expectedProfit) {
        Money money = Money.from(moneyInput);
        Lottos lottos = Lottos.from(userLotto);
        LottoResult lottoResult = LottoResult.of(lottos, winNumber);
        Profit profit = Profit.of(money, lottoResult);

        assertThat(profit.calculateProfit()).isEqualTo(expectedProfit);
    }

    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                        , "1000"
                        , 200000000.0),
                Arguments.of(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                                new Lotto(List.of(30, 31, 32, 33, 34, 35)))
                        , "3000"
                        , 1050000.0),
                Arguments.of(List.of(new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                                new Lotto(List.of(5, 6, 7, 8, 9, 10)),
                                new Lotto(List.of(1, 2, 3, 4, 19, 20)),
                                new Lotto(List.of(40, 41, 42, 43, 44, 45)))
                        , "5000"
                        , 1100.0)
        );
    }
}
