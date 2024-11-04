package lotto.model.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import lotto.model.lotto.lottoNumber.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private Lotto defaultLotto;
    private List<Integer> defaultNumbers;

    @BeforeEach
    void setUp() {
        defaultNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        defaultLotto = new Lotto(defaultNumbers);
    }

    @Test
    @DisplayName("[success] 숫자를 리스트에 순서대로 저장한다.")
    void saveNumbersList() {
        for (int number : defaultNumbers) {
            assertThat(defaultLotto.getNumbers()).contains(number);
        }
    }

    @ParameterizedTest
    @DisplayName("[success] 특정 번호와 로또 번호가 일치하는 개수를 확인한다.")
    @MethodSource("lottoWithMatchingNumberProvider")
    void countMatchingAmountWithOtherNumber(int expectedMatchingAmount, List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        List<Integer> targetNumbers = new ArrayList<>(
                List.of(1, 2, 3, 4, 5, 6)
        );

        int matchingAmount = lotto.checkMatchingAmountWith(targetNumbers);

        assertThat(matchingAmount).isEqualTo(expectedMatchingAmount);
    }

    static Stream<Object[]> lottoWithMatchingNumberProvider() {
        return Stream.of(
                new Object[]{6, Arrays.asList(1, 2, 3, 4, 5, 6)},
                new Object[]{5, Arrays.asList(1, 2, 3, 4, 5, 7)},
                new Object[]{5, Arrays.asList(1, 2, 3, 4, 5, 8)},
                new Object[]{4, Arrays.asList(1, 2, 3, 4, 8, 9)},
                new Object[]{3, Arrays.asList(1, 2, 3, 8, 9, 10)},
                new Object[]{2, Arrays.asList(1, 2, 8, 9, 10, 11)},
                new Object[]{1, Arrays.asList(1, 8, 9, 10, 11, 12)},
                new Object[]{0, Arrays.asList(8, 9, 10, 11, 12, 13)}
        );
    }

    @Test
    @DisplayName("[success] 특정 번호가 로또 번호와 중복되면 true를 반환한다")
    void true_WhenLottoDuplicatesOtherNumber() {
        int targetNumber = 6;

        boolean containsNumber = defaultLotto.contains(targetNumber);

        assertThat(containsNumber).isTrue();
    }

    @Test
    @DisplayName("[success] 특정 번호가 로또 번호와 중복되지 않으면 false를 반환한다")
    void false_WhenLottoNotDuplicatesOtherNumber() {
        int targetNumber = 7;

        boolean containsNumber = defaultLotto.contains(targetNumber);

        assertThat(containsNumber).isFalse();
    }

    @Test
    @DisplayName("[fail] 로또 번호의 개수가 6개가 아니면 예외가 발생한다.")
    void fail_IfLottoSizeNotSize() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    @DisplayName("[fail] 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void fail_IfLottoNumbersDuplicate() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(List.of(1, 2, 3, 4, 5, 5)));
    }

    @Test
    @DisplayName("[fail] 로또 번호에 1 이상 45 이하가 아닌 숫자가 있으면 예외가 발생한다.")
    void fail_IfLottoNumbersOutOfRange() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Lotto(List.of(1, 2, 3, 4, 5, 46)));
    }

    @Test
    @DisplayName("[fail] getter로 반환한 숫자 리스트를 수정할 경우 예외가 발생한다.")
    void fail_ifModifyNumbers() {
        List<Integer> unmodifiableList = defaultLotto.getNumbers();

        assertThatThrownBy(() -> unmodifiableList.add(10))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> unmodifiableList.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
