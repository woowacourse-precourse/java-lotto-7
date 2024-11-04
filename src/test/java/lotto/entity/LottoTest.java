package lotto.entity;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

    @Nested
    @DisplayName("로또 생성 Test")
    class CreateLottoTest {

        @DisplayName("기본 생성")
        @Test
        void createTest() {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
            Lotto lotto = new Lotto(numbers);

            List<Integer> lottoNumbers = lotto.getNumbers();
            assertTrue(lottoNumbers.contains(1));
            assertTrue(lottoNumbers.contains(2));
            assertTrue(lottoNumbers.contains(3));
            assertTrue(lottoNumbers.contains(4));
            assertTrue(lottoNumbers.contains(5));
            assertTrue(lottoNumbers.contains(6));
            assertFalse(lottoNumbers.contains(7));
        }

        @DisplayName("로또 번호 6개 아닌 경우 예외 발생")
        @Test
        void inputSizeError1() {
            // 7개
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호 6개 아닌 경우 예외 발생")
        @Test
        void inputSizeError2() {
            // 5개
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 번호 중복 시 예외 발생")
        @Test
        void duplicationError() {
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자 범위를 벗어난 경우 예외 발생")
        @Test
        void outOfRangeError1() {
            // 초과
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("숫자 범위를 벗어난 경우 예외 발생")
        @Test
        void outOfRangeError2() {
            // 미만
            assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("로또 당첨 확인")
    class CheckLottoTest {

        @DisplayName("1등 당첨 Test")
        @Test
        void firstPrizeTest() {
            List<Integer> numbersForLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> numbersForCheck = Arrays.asList(1, 2, 3, 4, 5, 6);
            Integer bonusNumber = 9;
            Lotto lotto = new Lotto(numbersForLotto);

            assertEquals(lotto.checkPrize(numbersForCheck, bonusNumber), Prize.FIRST);
        }

        @DisplayName("2등 당첨 Test")
        @Test
        void secondPrizeTest() {
            List<Integer> numbersForLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> numbersForCheck = Arrays.asList(1, 2, 3, 4, 5, 7);
            Integer bonusNumber = 6;
            Lotto lotto = new Lotto(numbersForLotto);

            assertEquals(lotto.checkPrize(numbersForCheck, bonusNumber), Prize.SECOND);
        }

        @DisplayName("3등 당첨 Test")
        @Test
        void thirdPrizeTest() {
            List<Integer> numbersForLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> numbersForCheck = Arrays.asList(1, 2, 3, 4, 5, 7);
            Integer bonusNumber = 8;
            Lotto lotto = new Lotto(numbersForLotto);

            assertEquals(lotto.checkPrize(numbersForCheck, bonusNumber), Prize.THIRD);
        }

        @DisplayName("4등 당첨 Test")
        @Test
        void fourthPrizeTest() {
            List<Integer> numbersForLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> numbersForCheck = Arrays.asList(1, 2, 3, 4, 10, 11);
            Integer bonusNumber = 8;
            Lotto lotto = new Lotto(numbersForLotto);

            assertEquals(lotto.checkPrize(numbersForCheck, bonusNumber), Prize.FOURTH);
        }

        @DisplayName("5등 당첨 Test")
        @Test
        void fifthPrizeTest() {
            List<Integer> numbersForLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> numbersForCheck = Arrays.asList(1, 2, 3, 9, 10, 11);
            Integer bonusNumber = 8;
            Lotto lotto = new Lotto(numbersForLotto);

            assertEquals(lotto.checkPrize(numbersForCheck, bonusNumber), Prize.FIFTH);
        }

        @DisplayName("미당첨 Test (당첨 숫자 없음)")
        @Test
        void noPrizeTest1() {
            List<Integer> numbersForLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> numbersForCheck = Arrays.asList(10, 11, 12, 13, 14, 15);
            Integer bonusNumber = 8;
            Lotto lotto = new Lotto(numbersForLotto);

            assertEquals(lotto.checkPrize(numbersForCheck, bonusNumber), Prize.NO_PRIZE);
        }

        @DisplayName("미당첨 Test (당첨 숫자 1개)")
        @Test
        void noPrizeTest2() {
            List<Integer> numbersForLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> numbersForCheck = Arrays.asList(1, 11, 12, 13, 14, 15);
            Integer bonusNumber = 8;
            Lotto lotto = new Lotto(numbersForLotto);

            assertEquals(lotto.checkPrize(numbersForCheck, bonusNumber), Prize.NO_PRIZE);
        }

        @DisplayName("미당첨 Test (당첨 숫자 2개)")
        @Test
        void noPrizeTest3() {
            List<Integer> numbersForLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> numbersForCheck = Arrays.asList(1, 2, 12, 13, 14, 15);
            Integer bonusNumber = 8;
            Lotto lotto = new Lotto(numbersForLotto);

            assertEquals(lotto.checkPrize(numbersForCheck, bonusNumber), Prize.NO_PRIZE);
        }
    }
}
