package lotto.provider;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUniqueNumbersProviderTest {

    @DisplayName("랜덤한 유니크 숫자를 생성한다.")
    @Test
    void provideRandomUniqueNumbers() {
        //given
        RandomUniqueNumbersProvider provider = new RandomUniqueNumbersProvider();
        //when
        List<Integer> numbers = provider.getNumbers();
        //then
        assertThat(numbers).hasSize(6)
            .doesNotHaveDuplicates()
            .allMatch(number -> number >= 1 && number <= 45);
    }

}