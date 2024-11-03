package lotto.parameterizedTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class MethodSource {

    static Stream<Integer> generateNormalLottoNumber() {
        return IntStream.rangeClosed(1, 45).boxed();
    }

    static Stream<Arguments> provideLottoNumbers() {
        return Stream.generate(() -> Arguments.of(generateRandomLottoNumbers()))
                .limit(20);
    }

    static List<Integer> generateRandomLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        return numbers.subList(0, 6);
    }

    static Stream<Arguments> provideWrongSizeLottos() {
        return Stream.of(
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3)),
                Arguments.of(List.of(1, 2, 3, 4)),
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9))
        );
    }


}
