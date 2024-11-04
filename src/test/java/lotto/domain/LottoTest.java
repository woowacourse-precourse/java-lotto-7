package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;


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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @Test
    @DisplayName("로또 객체 생성 성공 - 유효한 번호 6개 제공")
    void success_createLotto() {
        // given
        List<Integer> numbers = Arrays.asList(5, 12, 23, 34, 41, 45);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.getNumbers()).containsExactly(5, 12, 23, 34, 41, 45);
    }

    @Test
    @DisplayName("로또 객체 생성 실패 - 번호가 6개 미만일 때")
    void fail_createLotto_lessThanSixNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(5, 12, 23, 34, 41);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 정확히 6개여야 합니다.");
    }

    @Test
    @DisplayName("로또 객체 생성 실패 - 중복된 번호가 있을 때")
    void fail_createLotto_withDuplicateNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(5, 12, 23, 34, 41, 41);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호에 중복된 숫자가 포함되어 있습니다.");
    }

    @Test
    @DisplayName("로또 객체 생성 실패 - 범위를 벗어난 번호가 있을 때")
    void fail_createLotto_withOutOfRangeNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(0, 12, 23, 34, 41, 46);

        // when & then
        assertThatThrownBy(() -> new Lotto(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 로또 번호는 1 이상 45 이하의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 당첨 매칭 성공 - 일치하는 번호 수에 따라 등수 반환")
    void success_matchRank() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(5, 12, 23, 34, 41, 45);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningNumbersList = Arrays.asList(5, 12, 23, 34, 41, 45);
        Lotto winningLotto = new Lotto(winningNumbersList);
        int bonusNumber = 7;

        // when
        Rank rank = lotto.match(winningLotto, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("로또 당첨 매칭 실패 - 일치하는 번호가 없을 때")
    void fail_matchRank_noMatch() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        List<Integer> winningNumbersList = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto winningLotto = new Lotto(winningNumbersList);
        int bonusNumber = 13;

        // when
        Rank rank = lotto.match(winningLotto, bonusNumber);

        // then
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
