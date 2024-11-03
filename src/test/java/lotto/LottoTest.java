package lotto;

import lotto.Messages.ErrorMessage;
import lotto.Model.MyResults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("validateTest 로또 number들이 6개가 아닌 경우")
    void validateTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUM.getError());
    }

    @Test
    @DisplayName("validateTest 로또 number 사이에 중복이 있을 때")
    void validateDuplicateTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_DUPLICATE.getError());
    }

    @Test
    @DisplayName("validateTest 로또 number 정상 작동")
    void validateCorrectTest() {
        assertThatNoException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("sortLotto 정상 작동")
    void sortLottoTest() {
        Lotto actualLotto = Lotto.sortLotto(new Lotto(List.of(6, 4, 3, 2, 1, 7)));
        Lotto expectedLotto = new Lotto(List.of(1, 2, 3, 4, 6, 7));
        assertThat(actualLotto.getNumbers()).isEqualTo(expectedLotto.getNumbers());
    }

    @Test
    @DisplayName("sortLottoList 정상 작동")
    void sortLottoListTest() {
        int lottoCount = 4;
        List<Lotto> expectedLottos = new ArrayList<>();
        expectedLottos.add(new Lotto(List.of(1, 2, 3, 4, 6, 7)));
        expectedLottos.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        expectedLottos.add(new Lotto(List.of(3, 4, 5, 6, 7, 8)));
        expectedLottos.add(new Lotto(List.of(1, 2, 3, 4, 6, 7)));
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    List<Lotto> actualLottos = Lotto.sortLottoList(lottoCount);
                    for (int i = 0; i < lottoCount; i++) {
                        assertThat(actualLottos.get(i)
                                .getNumbers())
                                .isEqualTo(expectedLottos
                                        .get(i)
                                        .getNumbers());
                    }
                },
                List.of(6, 4, 3, 2, 1, 7),
                List.of(2, 3, 4, 5, 6, 7),
                List.of(8, 7, 6, 5, 4, 3),
                List.of(1, 2, 3, 4, 6, 7)
        );
    }

    @Test
    @DisplayName("gradeLotto 정상 작동 테스트")
    void gradeLottoTest() {
        Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto targetLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        int bonus = 8;
        MyResults actualMyResult = Lotto.gradeLotto(answerLotto, targetLotto, bonus);
        MyResults expectedMyResult = new MyResults(5, true);
        assertThat(actualMyResult.getMatches()).isEqualTo(expectedMyResult.getMatches());
        assertThat(actualMyResult.getIsBonus()).isEqualTo(expectedMyResult.getIsBonus());
    }

}
