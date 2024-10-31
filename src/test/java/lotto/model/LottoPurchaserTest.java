package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPurchaserTest {

    static class FixedNumberGenerator implements NumberGenerator {

        private final List<Integer> numbers;

        public FixedNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public List<Integer> generateNumber() {
            return numbers;
        }
    }

    @Test
    void 올바른_로또_구입_테스트() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoPurchaser lottoPurchaser = new LottoPurchaser(new FixedNumberGenerator(numbers));

        lottoPurchaser.purchaseLotto();
        List<Lotto> purchasedLottos = lottoPurchaser.getPurchasedLottos();

        assertThat(purchasedLottos.getFirst().getNumbers()).isEqualTo(numbers);
    }

    @ParameterizedTest
    @MethodSource("invalidLottoNumbers")
    void 잘못된_로또_구입_테스트(List<Integer> numbers) {
        LottoPurchaser lottoPurchaser = new LottoPurchaser(new FixedNumberGenerator(numbers));

        assertThatThrownBy(lottoPurchaser::purchaseLotto).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> invalidLottoNumbers() {
        return Stream.of(
                List.of(0, 1, 2, 3, 4, 5),
                List.of(1, 2, 3, 4, 5, 46)
        );
    }
}
