package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class LottoMachineTest {
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("구입한 금액만큼 로또를 구매할 수 있다.")
    @ParameterizedTest
    @MethodSource("generatePriceAndCountList")
    void 구입한_금액만큼_로또를_구매할_수_있다(int price, int count) {
        // when
        List<Lotto> lottoList = lottoMachine.buyLottoByPrice(price);

        // then
        Assertions.assertThat(lottoList.size()).isEqualTo(count);
    }

    private static Stream<Arguments> generatePriceAndCountList() {
        return Stream.of(
                Arguments.of(1000, 1),
                Arguments.of(3000, 3),
                Arguments.of(226000, 226)
        );
    }
}