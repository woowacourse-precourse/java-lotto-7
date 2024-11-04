package lotto.domain.player;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.constant.Rank;
import lotto.random.LottoRandom;

@DisplayName("플레이어는")
class PlayerTest {

    private LottoRandom lottoRandom;

    @BeforeEach
    void setup() {
        lottoRandom = () -> List.of(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "1000, 1",
        "3000, 3",
        "10000, 10",
        "500000, 500"
    })
    void 로또를_구입_금액에_맞게_구매한다(long money, int lottoCount) {
        Player player = new Player(money);
        player.buyLottos(lottoRandom);
        assertThat(player.getLottoTicketCounts()).isEqualTo(lottoCount);
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 33, 100, 1001, 9999})
    void 구입_금액이_로또_가격으로_나누어떨어지지_않으면_예외를_반환한다(long money) {
        assertThatThrownBy(() -> new Player(money))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("calculateGain")
    void 수익률을_올바르게_계산한다(long money, Rank rank) {
        Player player = new Player(money);
        player.addRank(rank);
        assertThat(player.gain()).isEqualTo((double)rank.getPrice() / money);
    }

    private static Stream<Arguments> calculateGain() {
        return Stream.of(
            Arguments.of(1000, Rank.FIRST),
            Arguments.of(2000, Rank.SECOND),
            Arguments.of(3000, Rank.THIRD),
            Arguments.of(4000, Rank.FOURTH),
            Arguments.of(5000, Rank.FIFTH)
        );
    }
}
