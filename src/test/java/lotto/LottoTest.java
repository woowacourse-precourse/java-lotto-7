package lotto;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 랜덤 번호 간의 매칭 개수 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6 : 6",
            "1,2,3,4,5,10 : 5",
            "1,2,3,4,10,11 : 4",
            "1,2,3,10,11,12 : 3",
            "1,2,10,11,12,13 : 2",
            "1,10,11,12,13,14 : 1",
            "10,11,12,13,14,15 : 0"
    }, delimiter = ':')
    void numberMatchCount_매칭_개수_테스트(String randomNumbers, int expectedMatchCount) {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        List<Integer> randomLotto = new ArrayList<>();

        String[] numbers = randomNumbers.split(",");
        for (String number : numbers) {
            randomLotto.add(Integer.parseInt(number));
        }

        int matchCount = Lotto.numberMatchCount(lotto, randomLotto);

        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }
}
