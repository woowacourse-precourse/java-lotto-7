package lotto.domain;

import lotto.constants.string.InputError;
import lotto.constants.string.RangeError;
import lotto.constants.value.LottoRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class LottoTest {

    // a 부터 시작해서 원하는 길이 만큼의 알파벳 로또를 만들어줍니다.
    public static List<Component> generateWordLottoOfLength(int n) {
        List<Character> wordLotto = IntStream.range(0, n)
                .mapToObj(i -> (char) ('a' + i))
                .collect(Collectors.toList());

        return wordLotto.stream()
                .map(ComponentChar::new)
                .collect(Collectors.toList());
    }

    // 1 부터 시작해서 원하는 길이 만큼의 숫자 로또를 만들어줍니다.
    public static List<Component> generateNumberLottoOfLength(int n) {
        List<Integer> numberLotto = IntStream.range(0, n)
                .mapToObj(i -> (1 + i))
                .collect(Collectors.toList());

        return numberLotto.stream()
                .map(ComponentNumber::new)
                .collect(Collectors.toList());
    }


    @Test
    @DisplayName("Lotto는 정체성인 길이만 맞다면 자유로운 구성 요소를 가질 수 있다.")
    void testLottoComponent() {

        assertDoesNotThrow(() -> {
            new Lotto(generateWordLottoOfLength(LottoRule.COMBINATION_LENGTH.getInstance()));
        });
    }

    @Test
    @DisplayName("Lotto는 정체성인 길이가 맞지 않다면 에러 메시지를 출력한다.")
    void testLottoLengthValidation() {
        assertThatThrownBy(() -> {
            new Lotto(generateNumberLottoOfLength(LottoRule.COMBINATION_LENGTH.getInstance() + 1));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RangeError.LOTTO_LENGTH.getInstance());
    }

    @Test
    @DisplayName("Lotto는 구성요소가 무엇이든 같은 로또를 판별할 수 있다.")
    void testLottoEqualsMethod() {
        assertThat(generateWordLottoOfLength(LottoRule.COMBINATION_LENGTH.getInstance()))
                .isEqualTo(generateWordLottoOfLength(LottoRule.COMBINATION_LENGTH.getInstance()));
    }

    @Test
    @DisplayName("Lotto는 중복값을 허용하지 않는다")
    void testLottoDuplicateValidation() {
        List<Component> duplicateList = Stream.of('a', 'a', 'b', 'c', 'd', 'e')
                .map(ComponentChar::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> {
            new Lotto(duplicateList);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(InputError.DUPLICATE_LOTTO_NUMBER.getInstance());

    }

    @Test
    @DisplayName("Lotto의 Getter 매서드는 수정할 수 없다")
    void testUnmodifiedGetter() {
        Lotto lotto = new Lotto(generateWordLottoOfLength(LottoRule.COMBINATION_LENGTH.getInstance()));

        assertThatThrownBy(() -> {
            ComponentNumber number = new ComponentNumber(8);
            lotto.getComponents().add(number);
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}
