package lotto;

import lotto.model.Lotto;
import lotto.service.LottoCreator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.LottoConstant.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoCreatorTest {
    @Test
    void 생성된_로또_번호_6개() {
        Lotto lotto = LottoCreator.createLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        assertThat(lottoNumbers.size()).isEqualTo(LOTTO_NUMBERS_LENGTH.getValue());
    }

    @Test
    void 생성된_로또_번호_1에서_45사이의_범위() {
        Lotto lotto = LottoCreator.createLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        for (Integer number : lottoNumbers) {
            assertThat(number).isBetween(
                    MIN_LOTTO_NUMBER.getValue(),
                    MAX_LOTTO_NUMBER.getValue());
        }
    }

    @Test
    void 생성된_로또_번호_중복() {
        Lotto lotto = LottoCreator.createLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        long distinctCount = lottoNumbers.stream().distinct().count();
        assertThat(distinctCount).isEqualTo(lottoNumbers.size());
    }

    @Test
    void 생성된_로또_번호_오름차순_정렬() {
        Lotto lotto = LottoCreator.createLotto();
        List<Integer> lottoNumbers = lotto.getNumbers();

        assertThat(lottoNumbers).isSorted();
    }
}
