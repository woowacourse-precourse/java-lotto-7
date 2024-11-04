package lotto.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Nested
    @DisplayName("로또 뭉치 생성 Test")
    class CreateLottosTest {

        @DisplayName("로또 구입 테스트")
        @Test
        void buyLottosTest() {
            Lottos lottos = new Lottos();
            lottos.buyLottos(10000L);
            List<Lotto> lottoList = lottos.getLottos();

            assertEquals(lottoList.size(), 10);
        }

        @DisplayName("로또 invalid 비용 테스트 (1000원 이하)")
        @Test
        void buyLottosError1() {
            // 1000원 이하
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.buyLottos(10L))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 invalid 비용 테스트 (not 1000원 단위)")
        @Test
        void buyLottosError2() {
            // 1000원 단위 아님
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.buyLottos(100010L))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 invalid 비용 테스트 (int 자료형 초과)")
        @Test
        void buyLottosError3() {
            // 1000원 이하
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.buyLottos(50000000000L))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("로또 당첨 번호 세팅 Test")
    class SetWinningNumberTest {

        @DisplayName("당첨 번호 개수 예외 (7개)")
        @Test
        void countOfWinningNumbersError1() {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            Integer bonusNumber = 9;
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.setWinningNumbers(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호 개수 예외 (5개)")
        @Test
        void countOfWinningNumbersError2() {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5);
            Integer bonusNumber = 9;
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.setWinningNumbers(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호 중복 예외")
        @Test
        void duplicationOfWinningNumbersError() {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 6, 6);
            Integer bonusNumber = 9;
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.setWinningNumbers(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호 범위 예외 (초과)")
        @Test
        void winningNumbersOutOfRangeError1() {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);
            Integer bonusNumber = 9;
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.setWinningNumbers(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호 범위 예외 (미만)")
        @Test
        void winningNumbersOutOfRangeError2() {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 0);
            Integer bonusNumber = 9;
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.setWinningNumbers(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호 범위 예외 (초과)")
        @Test
        void bonusNumberOutOfRangeError1() {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            Integer bonusNumber = 55;
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.setWinningNumbers(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호 범위 예외 (미만)")
        @Test
        void bonusNumberOutOfRangeError2() {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            Integer bonusNumber = 0;
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.setWinningNumbers(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 번호 중복")
        @Test
        void duplicationOfBonusNumberError() {
            List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            Integer bonusNumber = 1;
            Lottos lottos = new Lottos();
            assertThatThrownBy(() -> lottos.setWinningNumbers(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
