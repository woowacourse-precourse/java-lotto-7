package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AdditionalApplicationTest {
    @Test
    void 양의정수_10자리_이하_금액을_입력한다() {
        String testString = "50";

        assertThatCode(() -> Application.validateInputInteger(testString))
                .doesNotThrowAnyException();
    }

    @Test
    void 금액_null일시_예외() {
        String testNumber = null;

        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testNumber))
                .withMessage("[ERROR] 금액을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 금액_빈_문자열일시_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testNumber))
                .withMessage("[ERROR] 금액을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-20.2, -1.0, 0.5, 2.0, 2.5, 3.24321"})
    void 금액이_정수가_아니면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testNumber))
                .withMessage("[ERROR] 양의 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-20, -1, 0"})
    void 금액이_양수가_아니면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testNumber))
                .withMessage("[ERROR] 양의 정수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"10000000000", "123456789123456789"})
    void 금액이_10자리를_넘어가면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.validateInputInteger(testNumber))
                .withMessage("[ERROR] 10자리 이하의 금액을 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5", "11000:11", "25000:25", "303000:303", "1474134000:1474134", "1000000000:1000000"}, delimiter = ':')
    void 금액을_1000으로_나누어_개수를_구한다(String testNumber, int expected) {
        int lottoAmount = Application.countLottoAmount(testNumber);

        assertThat(lottoAmount).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "1002", "2524", "100001", "100020"})
    void 금액이_1000으로_나누어떨어지지_않으면_예외(String testNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> Application.countLottoAmount(testNumber))
                .withMessage("[ERROR] 1000 단위의 금액을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void 숫자를_뽑을_때_오름차순으로_정렬한다(int randomNumbersIndex) {
        List<Integer> testNumbers = Application.pickSortedNumbers();

        assertThat(testNumbers.get(randomNumbersIndex)).isLessThan(testNumbers.get(randomNumbersIndex + 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4 ,5})
    void 랜덤넘버_6개를_뽑아_로또를_한장_발행한다(int randomNumbersIndex) {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = Application.issueOneLotto(randomNumbers);

        assertThat(lotto.getNumbers()).contains(randomNumbers.get(randomNumbersIndex));
    }

    @Test
    void 구매_개수만큼_로또를_발행한다() {
        int testNumber = 2;

        List<Lotto> lottos = Application.issueLottos(testNumber);

        assertThat(lottos.size()).isEqualTo(testNumber);
    }


}
