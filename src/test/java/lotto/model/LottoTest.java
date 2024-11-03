package lotto.model;

import lotto.exception.LottoException.LottoNumberOutOfRangeException;
import lotto.util.generator.LottoNumberGenerator;
import lotto.vo.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void 로또_번호가_지정된_숫자_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(LottoNumberOutOfRangeException.class);

        assertThatThrownBy(() -> new Lotto(List.of(1,2,3,4,5,46)))
                .isInstanceOf(LottoNumberOutOfRangeException.class);
    }

    @DisplayName("정상적인 로또 당첨 번호 생성")
    @Test
    void 정상적인_로또_당첨_번호를_생성한다() {
        assertDoesNotThrow(() -> new Lotto(List.of(1,2,3,4,5,6)));
    }

    @DisplayName("구매한 로또 번호를 생성합니다.")
    @Test
    void 구매한_로또_번호_생성() {
        LottoNumberGenerator testGenerator = new TestLottoNumberGenerator();

        Lotto lotto = Lotto.createLottoNumber(testGenerator);

        assertDoesNotThrow(() -> new Lotto(lotto.getNumbers()));
    }

    @Test
    void 동일한_로또_번호_숫자_반환() {
        LottoNumberGenerator testGenerator = new TestLottoNumberGenerator();

        Lotto lotto = Lotto.createLottoNumber(testGenerator);
        Lotto winningLotto = Lotto.createWinningLotto(List.of(1, 2, 3, 4, 5, 11));

        int count = lotto.countMatchedNumbers(winningLotto);

        assertEquals(count, 5);
    }

    @DisplayName("입력된 보너스 번호가 로또번호에 존재하지 않는 경우")
    @Test
    void 보너스_번호_비일치_확인() {
        BonusNumber bonusNumber = new BonusNumber(7);
        LottoNumberGenerator testGenerator = new TestLottoNumberGenerator();

        Lotto lotto = Lotto.createLottoNumber(testGenerator);

        assertFalse(lotto.checkBonusNumberContain(bonusNumber));
    }

    @DisplayName("입력된 보너스 번호가 로또번호에 존재하는 않는 경우")
    @Test
    void 보너스_번호_일치_확인() {
        BonusNumber bonusNumber = new BonusNumber(6);
        LottoNumberGenerator testGenerator = new TestLottoNumberGenerator();

        Lotto lotto = Lotto.createLottoNumber(testGenerator);

        assertTrue(lotto.checkBonusNumberContain(bonusNumber));
    }

    @DisplayName("테스트용 LottoNumberGenerator 구현")
    private static class TestLottoNumberGenerator implements LottoNumberGenerator {
        @Override
        public List<Integer> numberGenerator() {
            return List.of(1, 2, 3, 4, 5, 6);
        }
    }
}
