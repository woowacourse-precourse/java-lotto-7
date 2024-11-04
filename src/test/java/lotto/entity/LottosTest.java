package lotto.entity;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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

    @Nested
    @DisplayName("로또 당첨 확인 Test")
    class CheckLottosTest {

        @DisplayName("로또 1등 회수율 확인 Test")
        @Test
        void checkReturnFirstPrizeTest() {
            Lottos lottos = new Lottos();
            lottos.buyLottos(1000L);

            List<Lotto> lottoList = lottos.getLottos();
            List<Integer> numbers = lottoList.getFirst().getNumbers();
            int bonus = 1;
            while (bonus < 45) {
                if (!numbers.contains(bonus)) {
                    break;
                }
                bonus++;
            }

            lottos.setWinningNumbers(numbers, bonus);
            assertEquals(lottos.getRateOfReturn(), (float) 2000000000 / 1000 * 100);
        }

        @DisplayName("로또 회수율 확인 Test")
        @Test
        void checkReturnSecondPrizeTest() {
            // 로또에서 번호 뽑은 뒤
            // 하나의 숫자를 bonus 숫자로 설정
            // list에 없던 숫자를 당첨 번호에 추가하여 2등하는 경우를 생성

            Lottos lottos = new Lottos();
            lottos.buyLottos(1000L);

            List<Lotto> lottoList = lottos.getLottos();
            List<Integer> numbers = lottoList.getFirst().getNumbers();

            List<Integer> winningNumbers = new ArrayList<>();
            for (Integer number : numbers) {
                winningNumbers.add(number);
            }
            Integer bonus = winningNumbers.removeFirst();
            int append = 1;
            while (append < 45) {
                if (!numbers.contains(append)) {
                    winningNumbers.add(append);
                    break;
                }
                append++;
            }

            lottos.setWinningNumbers(winningNumbers, bonus);
            assertEquals(lottos.getRateOfReturn(), (float) 30000000 / 1000 * 100);
        }

        @DisplayName("당첨된 1등 로또 개수 확인")
        @Test
        void checkNumOfFirstPrizeLottos() {
            Lottos lottos = new Lottos();
            lottos.buyLottos(1000L);

            List<Lotto> lottoList = lottos.getLottos();
            List<Integer> numbers = lottoList.getFirst().getNumbers();
            int bonus = 1;
            while (bonus < 45) {
                if (!numbers.contains(bonus)) {
                    break;
                }
                bonus++;
            }

            lottos.setWinningNumbers(numbers, bonus);
            assertEquals(lottos.getCountOfPrize(Prize.FIRST), 1);
            assertEquals(lottos.getCountOfPrize(Prize.SECOND), 0);
            assertEquals(lottos.getCountOfPrize(Prize.THIRD), 0);
            assertEquals(lottos.getCountOfPrize(Prize.FOURTH), 0);
            assertEquals(lottos.getCountOfPrize(Prize.FIFTH), 0);
            assertEquals(lottos.getCountOfPrize(Prize.NO_PRIZE), 0);
        }

        @DisplayName("당첨된 2등 로또 개수 확인 Test")
        @Test
        void checkNumOfSecondPrizeLottos() {
            // 로또에서 번호 뽑은 뒤
            // 하나의 숫자를 bonus 숫자로 설정
            // list에 없던 숫자를 당첨 번호에 추가하여 2등하는 경우를 생성

            Lottos lottos = new Lottos();
            lottos.buyLottos(1000L);

            List<Lotto> lottoList = lottos.getLottos();
            List<Integer> numbers = lottoList.getFirst().getNumbers();

            List<Integer> winningNumbers = new ArrayList<>();
            for (Integer number : numbers) {
                winningNumbers.add(number);
            }
            Integer bonus = winningNumbers.removeFirst();
            int append = 1;
            while (append < 45) {
                if (!numbers.contains(append)) {
                    winningNumbers.add(append);
                    break;
                }
                append++;
            }

            lottos.setWinningNumbers(winningNumbers, bonus);
            assertEquals(lottos.getCountOfPrize(Prize.FIRST), 0);
            assertEquals(lottos.getCountOfPrize(Prize.SECOND), 1);
            assertEquals(lottos.getCountOfPrize(Prize.THIRD), 0);
            assertEquals(lottos.getCountOfPrize(Prize.FOURTH), 0);
            assertEquals(lottos.getCountOfPrize(Prize.FIFTH), 0);
            assertEquals(lottos.getCountOfPrize(Prize.NO_PRIZE), 0);
        }
    }
}
