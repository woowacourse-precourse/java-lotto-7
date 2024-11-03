package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @CsvSource(value = {
            "5,true",
            "9,false",
            "10,false",
            "44,false",
            "1,true"
    })
    void 로또_번호에_인자로_받는_번호_존재여부_반환한다(int number, boolean expectedResult) {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Number checkExistedNumber = new Number(number);

        // When
        boolean isContain = lotto.isContainNumber(checkExistedNumber);

        // Then
        assertThat(isContain).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("provideTwoLottoAndExpectedResult")
    void 두_로또_번호_동일한_번호_개수_반환한다(Lotto firstLotto, Lotto secondLotto, long expectedResult) {
        // Given & When
        long countSameNumbers = firstLotto.countSameNumbers(secondLotto);

        // Then
        assertThat(countSameNumbers).isEqualTo(expectedResult);
    }

    static Stream<Object[]> provideTwoLottoAndExpectedResult() {
        return Stream.of(
                new Object[] {
                      new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                      new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                      0
                },
                new Object[] {
                        new Lotto(List.of(1, 2, 3, 5, 8, 10)),
                        new Lotto(List.of(1, 2, 9, 10, 11, 12)),
                        3
                }
        );
    }
}
