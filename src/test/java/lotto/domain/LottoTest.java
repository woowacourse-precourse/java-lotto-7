package lotto.domain;

import lotto.domain.generator.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("로또 당첨 확인 - 랜덤 번호와 당첨 번호 일치 갯수를 Map 에 저장")
    void randomNumberMatchingWinningNumber_saveMatchCount() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        HashMap<Integer, Integer> winningCount = new HashMap<>();
        List<List<Integer>> randomNumbers = new ArrayList<>();
        randomNumbers.add(RandomNumberGenerator.generate());
        randomNumbers.add(RandomNumberGenerator.generate());

        //when
        lotto.checkWinning(randomNumbers, 7);

        //then
        assertThat(winningCount).satisfiesAnyOf(
                map -> assertThat(map).hasSize(2),
                map -> assertThat(map.values()).allMatch(value -> value == 2)
        );
    }
}
