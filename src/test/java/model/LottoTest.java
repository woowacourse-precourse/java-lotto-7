package model;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수_6개_넘어가면_예외_발생_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호_중복_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력시 1~45 숫자가 아닐시 예외처리 ")
    @Test
    void 로또_번호_범위_벗어남_테스트() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1과 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호는 1부터 45 사이의 6개 고유 번호로 구성")
    @Test
    void 로또_번호_생성_테스트() {
        Lotto lotto = new Lotto(List.of(3, 11, 22, 28, 33, 44));
        assertThat(lotto.lottoNumbers()).hasSize(6);
        assertThat(lotto.lottoNumbers()).doesNotHaveDuplicates();
        assertThat(lotto.lottoNumbers()).allMatch(number -> number >= 1 && number <= 45);
    }

    @DisplayName("당첨 번호와의 매칭 개수 계산")
    @Test
    void 당첨_번호와_매칭_개수_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 7, 8, 9);
        int matchCount = lotto.countMatchingNumbers(winningNumbers);
        assertThat(matchCount).isEqualTo(3);
    }
}
