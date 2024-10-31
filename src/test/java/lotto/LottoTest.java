package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("로또 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({
            "0, 2, 3, 4, 5, 6",     // 0은 범위 밖
            "1, 2, 3, 4, 5, 46"     // 46은 범위 밖
    })
    void 로또_번호가_범위를_벗어나면_예외가_발생한다(int num1, int num2, int num3, int num4, int num5, int num6) {
        List<Integer> numbers = List.of(num1, num2, num3, num4, num5, num6);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("유효한 로또 번호 리스트로 객체를 생성할 때 예외가 발생하지 않는다.")
    @ParameterizedTest
    @CsvSource({
            "1, 2, 3, 4, 5, 6",        // 정상 번호
            "10, 20, 30, 40, 41, 42",  // 정상 번호
            "5, 15, 25, 35, 45, 1"     // 정상 번호
    })
    void 유효한_로또_번호로_객체_생성시_예외가_발생하지_않는다(int num1, int num2, int num3, int num4, int num5, int num6) {
        List<Integer> numbers = List.of(num1, num2, num3, num4, num5, num6);
        assertThatNoException().isThrownBy(() -> new Lotto(numbers));
    }

    @DisplayName("정렬된 로또 번호 리스트를 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "5, 3, 4, 2, 1, 6",
            "10, 1, 5, 8, 3, 7"
    })
    void getNumbers_정렬된_로또_번호_리스트를_반환한다(int num1, int num2, int num3, int num4, int num5, int num6) {
        List<Integer> numbers = List.of(num1, num2, num3, num4, num5, num6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isSorted();
    }

    @DisplayName("중복되지 않는 6개의 랜덤 번호를 생성한다.")
    @Test
    void generateRandomNumbers_중복되지_않는_6개의_랜덤_번호를_생성한다() {
        List<Integer> randomNumbers = Lotto.generateRandomNumbers();
        assertThat(randomNumbers).hasSize(6);
        assertThat(randomNumbers).doesNotHaveDuplicates();
        assertThat(randomNumbers).allMatch(num -> num >= 1 && num <= 45);
    }

    @DisplayName("일치하는 개수를 정확히 계산한다.")
    @ParameterizedTest
    @CsvSource({
            "1,2,3,10,11,12, 3",  // 3개 일치
            "1,2,3,4,5,6, 6",     // 6개 일치
            "7,8,9,10,11,12, 0"   // 0개 일치
    })
    void getMatchCount_일치하는_개수를_계산한다(int num1, int num2, int num3, int num4, int num5, int num6,
                                     int expectedMatchCount) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(num1, num2, num3, num4, num5, num6);
        assertThat(lotto.getMatchCount(winningNumbers)).isEqualTo(expectedMatchCount);
    }

    @DisplayName("보너스 번호 포함 여부를 정확히 확인한다.")
    @ParameterizedTest
    @CsvSource({
            "5, true",   // 5 포함
            "10, false"  // 10 미포함
    })
    void containsBonus_보너스번호_포함여부를_확인한다(int bonusNumber, boolean expectedResult) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.containsBonus(bonusNumber)).isEqualTo(expectedResult);
    }

}
