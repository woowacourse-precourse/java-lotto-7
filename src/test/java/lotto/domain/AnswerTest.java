package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class AnswerTest {
    @Test
    void 보너스번호는_정답번호와_중복될_수_없다() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(4);

        assertThrows(IllegalArgumentException.class, () -> {
            new Answer(lottoNumbers, bonusNumber);
        });
    }
}