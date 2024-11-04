package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JackpotTest {
    @DisplayName("예외 테스트: 로또 보너스 번호의 범위가 1과 45 사이가 아닌 경우")
    @Test
    void lotto_bonus_out_of_range_exception() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        assertThatThrownBy(() -> new Jackpot(lotto, 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("예외 테스트: 로또 보너스 번호가 일련의 로또 번호와 중복되는 경우")
    @Test
    void lotto_bonus_duplicate_exception() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lottoNumbers = new Lotto(numbers);

        assertThatThrownBy(() -> new Jackpot(lottoNumbers, 6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}