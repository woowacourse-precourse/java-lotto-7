package lotto.store;

import lotto.basic.NumbersGeneratorStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoGeneratorTest {

    private LottoGenerator generator;
    private NumbersGeneratorStub numbersGenerator;

    @BeforeEach
    void beforeEach() {
        numbersGenerator = new NumbersGeneratorStub();
        generator = new LottoGenerator(numbersGenerator);
    }

    @DisplayName("숫자 생성기가 준 숫자로 랜덤 로또를 생성한다")
    @Test
    void test1() {
        List<Integer> testNumbers = List.of(1, 2, 3, 4, 5, 6);
        numbersGenerator.setTestRandomNumbers(testNumbers);

        Lotto random = generator.random();

        assertThat(random.hasSameNumber(toLotto(testNumbers))).isTrue();
    }

    @DisplayName("선택한 숫자로 로또를 생성한다")
    @Test
    void test2() {
        List<Integer> testNumbers = List.of(1, 2, 3, 4, 5, 6);
        numbersGenerator.setTestRandomNumbers(testNumbers);

        Lotto random = LottoGenerator.manual(testNumbers);

        assertThat(random.hasSameNumber(toLotto(testNumbers))).isTrue();
    }

    @DisplayName("선택한 숫자가 Lotto 규칙에 맞지 않으면 예외가 발생한다")
    @Test
    void test3() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> LottoGenerator.manual(List.of(1, 2, 3, 4, 5, 100))
        );
    }

    private Lotto toLotto(List<Integer> numbers) {
        return new Lotto(toLottoNumbers(numbers));
    }

    private List<LottoNumber> toLottoNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).toList();
    }
}