package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto는 정렬된 리스트를 가진다.")
    void whenCreateLottoThenReturnSortedList() {
        //given
        List<Integer> expected = List.of(1, 7, 8, 13, 33, 45);

        //when
        Lotto lotto = new Lotto(List.of(45, 1, 13, 7, 8, 33));
        List<Integer> actual = lotto.getNumbers();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Nested
    @DisplayName("getEqualCount(Lotto otherLotto) 기능 테스트")
    class whenCallGetEqualCount {

        private Lotto target;

        @BeforeEach
        void setUp() {
            target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }

        @Test
        @DisplayName("1개가 일치하는 경우")
        void whenEqual1Return1() {
            //given
            Lotto other = new Lotto(List.of(10, 7, 8, 9, 1, 11));
            int expected = 1;

            //when
            int actual = target.getEqualCount(other);

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("2개가 일치하는 경우")
        void whenEqual2Return2() {
            //given
            Lotto other = new Lotto(List.of(2, 7, 8, 9, 1, 11));
            int expected = 2;

            //when
            int actual = target.getEqualCount(other);

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("3개가 일치하는 경우")
        void whenEqual3Return3() {
            //given
            Lotto other = new Lotto(List.of(2, 7, 8, 9, 1, 3));
            int expected = 3;

            //when
            int actual = target.getEqualCount(other);

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("4개가 일치하는 경우")
        void whenEqual4Return4() {
            //given
            Lotto other = new Lotto(List.of(2, 4, 8, 9, 1, 3));
            int expected = 4;

            //when
            int actual = target.getEqualCount(other);

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("5개가 일치하는 경우")
        void whenEqual5Return5() {
            //given
            Lotto other = new Lotto(List.of(2, 4, 5, 9, 1, 3));
            int expected = 5;

            //when
            int actual = target.getEqualCount(other);

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("6개가 일치하는 경우")
        void whenEqual6Return6() {
            //given
            Lotto other = new Lotto(List.of(2, 4, 5, 6, 1, 3));
            int expected = 6;

            //when
            int actual = target.getEqualCount(other);

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("isExist(int number) 기능 테스트")
    class whenCallIsExist {

        @ParameterizedTest
        @CsvSource({"1", "4", "8", "23", "33", "45"})
        @DisplayName("생성된 로또에 값이 들어있는 경우 true를 반환한다.")
        void thenReturnTrue(int number) {
            //given
            Lotto lotto = new Lotto(List.of(1, 4, 8, 23, 33, 45));
            boolean expected = true;

            //when
            boolean actual = lotto.isExist(number);

            //then
            assertThat(actual).isEqualTo(expected);
        }

        @ParameterizedTest
        @CsvSource({"2", "3", "5", "13", "32", "44"})
        @DisplayName("생성된 로또에 값이 들어있는 경우 true를 반환한다.")
        void thenReturnFalse(int number) {
            //given
            Lotto lotto = new Lotto(List.of(1, 4, 8, 23, 33, 45));
            boolean expected = false;

            //when
            boolean actual = lotto.isExist(number);

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }
}
