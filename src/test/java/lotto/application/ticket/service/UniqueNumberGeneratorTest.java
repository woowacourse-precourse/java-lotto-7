package lotto.application.ticket.service;


import static lotto.application.ticket.domain.ticket.LottoNumberRule.END_INCLUSIVE;
import static lotto.application.ticket.domain.ticket.LottoNumberRule.SIZE;
import static lotto.application.ticket.domain.ticket.LottoNumberRule.START_INCLUSIVE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayName("UniqueNumberGenerator - 고유 번호 생성기")
class UniqueNumberGeneratorTest {

    @DisplayName("생성된 번호는 항상 6개")
    @Test
    void 생성된_번호는_항상_6개() {
        // given
        UniqueNumberGenerator generator = new UniqueNumberGenerator();

        // when
        List<Integer> numbers = generator.generate();

        // then
        Assertions.assertThat(numbers).hasSize(SIZE.getValue());
    }

    @RepeatedTest(10)
    @DisplayName("생성된 번호는 중복되지 않는다")
    void 생성된_번호는_중복없음() {
        // given
        UniqueNumberGenerator generator = new UniqueNumberGenerator();

        // when
        List<Integer> numbers = generator.generate();
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        // then
        Assertions.assertThat(uniqueNumbers).hasSize(numbers.size());
    }

    @RepeatedTest(10)
    @DisplayName("생성된 번호는 모두 1과 45 사이다")
    void 생성된_번호는_범위내() {
        // given
        UniqueNumberGenerator generator = new UniqueNumberGenerator();

        // when
        List<Integer> numbers = generator.generate();

        // then
        Assertions.assertThat(numbers)
                .allMatch(number ->
                        number >= START_INCLUSIVE.getValue() &&
                                number <= END_INCLUSIVE.getValue());
    }

    @Test
    @DisplayName("여러 번 생성해도 매번 새로운 번호 조합이 생성된다")
    void 매번_새로운_번호조합_생성() {
        // given
        UniqueNumberGenerator generator = new UniqueNumberGenerator();
        Set<List<Integer>> generatedCombinations = new HashSet<>();

        // when
        for (int i = 0; i < 10; i++) {
            List<Integer> numbers = generator.generate();
            generatedCombinations.add(numbers);
        }

        // then
        Assertions.assertThat(generatedCombinations).hasSizeGreaterThan(1);
    }

    @RepeatedTest(10)
    @DisplayName("생성된 번호는 로또 규칙에 맞는 유효한 번호다")
    void 생성된_번호는_규칙에_맞음() {
        // given
        UniqueNumberGenerator generator = new UniqueNumberGenerator();

        // when
        List<Integer> numbers = generator.generate();

        // then
        Assertions.assertThat(numbers)
                .hasSize(SIZE.getValue())
                .doesNotHaveDuplicates()
                .allMatch(number ->
                        number >= START_INCLUSIVE.getValue() &&
                                number <= END_INCLUSIVE.getValue());
    }

}
