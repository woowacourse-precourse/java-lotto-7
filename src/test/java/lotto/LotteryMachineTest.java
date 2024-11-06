package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.common.Price;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.number.BonusNumber;
import lotto.domain.number.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Lotto 추첨을 테스트한다.")
class LotteryMachineTest {

    private final LotteryMachine lotteryMachine = new LotteryMachine(generateWinningNumbers(), generateBonusNumber());

    @DisplayName("성공 케이스를 테스트한다.")
    @Nested
    class HappyCase {

        @DisplayName("추첨 후, 통계를 내면 성공한다.")
        @Test
        void drawSuccessTest() {
            Lottos lottos = generateLottos(3);
            Price price = new Price(3000);

            lotteryMachine.draw(lottos);

            assertDoesNotThrow(() -> lotteryMachine.generateWinningStatisticBy(price));
        }
    }

    @DisplayName("실패 케이스를 테스트한다.")
    @Nested
    class EdgeCase {

        @DisplayName("추첨하지 않고 통계를 내면 실패한다.")
        @Test
        void drawTest() {
            Price price = new Price(1000);

            assertThatThrownBy(() -> lotteryMachine.generateWinningStatisticBy(price))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    private Lottos generateLottos(int count) {
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(ignored -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .peek(Collections::sort)
                .map(Lotto::new)
                .toList();

        return new Lottos(lottos);
    }

    private WinningNumbers generateWinningNumbers() {
        return new WinningNumbers(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    private BonusNumber generateBonusNumber() {
        return new BonusNumber(Randoms.pickNumberInRange(1, 45));
    }
}