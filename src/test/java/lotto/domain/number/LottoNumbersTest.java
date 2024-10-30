package lotto.domain.number;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LottoNumbersTest {

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("testSize")
    void 중복되지않은_번호가_6개가_아니면_에러를_던진다(List<Integer> numbers) {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumbers(numbers);
        });
    }

    private static Stream<Arguments> testSize() {
        return Stream.of(
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }
}