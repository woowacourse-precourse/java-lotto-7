package lotto;

import java.util.ArrayList;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerTest {


    @ParameterizedTest
    @MethodSource("providePrizeAmount")
    void 수익률을_계산할_수_있다(long purchaseAmount, double prizeRatio) {
        Player player = new Player(8000, new ArrayList<>());

        double result = player.calculatePrizeRatio(purchaseAmount);
        Assertions.assertThat(result).isEqualTo(prizeRatio);
    }

    private static Stream<Arguments> providePrizeAmount() {
        return Stream.of(
                Arguments.of(0, 0.0),
                Arguments.of(2666, 33.3),
                Arguments.of(5000, 62.5),
                Arguments.of(8000, 100.0),
                Arguments.of(16000, 200.0)
        );
    }
}