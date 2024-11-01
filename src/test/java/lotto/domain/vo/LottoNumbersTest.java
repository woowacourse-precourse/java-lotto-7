package lotto.domain.vo;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 포함 여부를 판단한다")
    void hasNumberShouldJudgeContainInt() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3));
        int input = 1;
        int wrongInput = 4;

        assertThat(lottoNumbers.hasNumber(input)).isEqualTo(true);
        assertThat(lottoNumbers.hasNumber(wrongInput)).isEqualTo(false);
    }
}