package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.InputParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    private final List<Integer> NORMAL_INPUT = List.of(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(NORMAL_INPUT);

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "10,2"})
    void 숫자_개수가_틀릴경우_예외발생(String numbers) {
        assertThatThrownBy(() -> {
            lotto.validateNumberCount(InputParser.parseListOfInteger(numbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "999,1,0,-1,4,2"})
    void 숫자_개수가_맞을경우_통과(String numbers) {
        lotto.validateNumberCount(InputParser.parseListOfInteger(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,3,10,5,4,10"})
    void 중복된_값이_있을경우_예외발생(String numbers) {
        assertThatThrownBy(() -> {
            lotto.validateDuplicates(InputParser.parseListOfInteger(numbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "999,998,997,6,5,4"})
    void 중복된_값이_없을경우_통과(String numbers) {
        lotto.validateDuplicates(InputParser.parseListOfInteger(numbers));
    }

    @ParameterizedTest
    @ValueSource(strings = {"999,998,997,6,5,4", "0,1,2,3,4,5"})
    void 범위를_벗어날_경우_예외발생(String numbers) {
        assertThatThrownBy(() -> {
            lotto.validateRange(InputParser.parseListOfInteger(numbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,45,3,2,6,7"})
    void 범위내에_있는_경우_통과(String numbers) {
        lotto.validateRange(InputParser.parseListOfInteger(numbers));
    }
}
