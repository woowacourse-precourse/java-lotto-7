package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("1개의 로또를 발행할 때 중복된 숫자가 없고 번호가 6개가 여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,", "1,1,2,3,4,5", "1,2,3,4,5,6,7"})
    void validateLotto(String numbers) {
        // given
        String delimiter = ",";
        List<Integer> lottoNumbers = Arrays.stream(numbers.split(delimiter))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        // when

        // then
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}