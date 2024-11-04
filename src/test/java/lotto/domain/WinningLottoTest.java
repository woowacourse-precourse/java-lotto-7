package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @ParameterizedTest
    @MethodSource("duplicateNumberException")
    void 보너스_번호와_당첨_번호에_중복된_값이_있으면_예외가_발생한다(Lotto firstPlaceLotto, BonusLotto bonusNumber) {
        assertThatThrownBy(() -> new WinningLotto(firstPlaceLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> duplicateNumberException() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusLotto(1)),
                Arguments.of(new Lotto(List.of(11, 23, 33, 40, 15, 16)), new BonusLotto(23)),
                Arguments.of(new Lotto(List.of(10, 20, 30, 14, 25, 36)), new BonusLotto(30))
        );
    }

}