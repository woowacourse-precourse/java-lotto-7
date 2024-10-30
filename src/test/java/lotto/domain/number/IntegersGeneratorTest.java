package lotto.domain.number;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegersGeneratorTest {

    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int COUNT = 6;

    private IntegersGenerator integersGenerator;
    private List<Integer> randomPickNumbers;

    @BeforeEach
    void setUp() {
        integersGenerator = new IntegersGenerator();
        randomPickNumbers = integersGenerator.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
    }

    @Test
    void 랜덤_숫자는_정해진_COUNT만큼_나와야한다() {
        //then
        assertThat(randomPickNumbers.size()).isEqualTo(COUNT);
    }

    @Test
    void 랜덤_숫자는_정해진_범위_안이여야한다() {
        //then
        for (Integer number : randomPickNumbers) {
            assertThat(number).isGreaterThanOrEqualTo(START_INCLUSIVE);
            assertThat(number).isLessThanOrEqualTo(END_INCLUSIVE);
        }
    }
}
