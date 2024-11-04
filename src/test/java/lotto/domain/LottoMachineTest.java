package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoMachineTest {
    @ParameterizedTest
    @MethodSource("generateMoneyAndCountData")
    void 로또_게임_수에_맞는_로또를_발행한다(String moneyInput, int expectedCount) {
        Money money = Money.from(moneyInput);
        LottoMachine lottoMachine = LottoMachine.from(money);
        List<Lotto> lottos = lottoMachine.publishLotto();
        assertThat(lottos.size()).isEqualTo(expectedCount);
    }

    static Stream<Arguments> generateMoneyAndCountData() {
        return Stream.of(
                Arguments.of("1000", 1),
                Arguments.of("10000", 10),
                Arguments.of("35000", 35)
        );
    }

    @Test
    void 유효한_금액일_경우_예외_없이_로또를_발행한다() {
        Money money = Money.from("1000");
        LottoMachine lottoMachine = LottoMachine.from(money);
        assertDoesNotThrow(() -> lottoMachine.publishLotto());
    }
}
