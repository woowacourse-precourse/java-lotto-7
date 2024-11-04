package lotto.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    InputValidator inputValidator;

    @BeforeEach
    void setup() {
        inputValidator = new InputValidator();
    }

    @DisplayName("입력한 금액이 1000단위가 아닐 경우 예외가 발생한다.")
    @Test
    void 입력한_금액이_1000단위가_아닐_경우_예외가_발생한다() {
        assertThat(inputValidator.payment("100")).isEqualTo(false);
    }

    @DisplayName("입력한 값에 숫자가 아닌 문자가 있을 경우 예외가 발생한다.")
    @Test
    void 입력한_값에_숫자가_아닌_문자가_있을_경우_예외가_발생한다() {
        assertThat(inputValidator.convertToInteger("1000j"))
                .isEqualTo(false);
    }

    @DisplayName("입력한 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void 입력한_번호가_1보다_작으면_예외가_발생한다() {
        assertThat(inputValidator.lottoRange("0"))
                .isEqualTo(false);
    }

    @DisplayName("입력한 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void 입력한_번호가_45보다_크면_예외가_발생한다() {
        assertThat(inputValidator.lottoRange("46"))
                .isEqualTo(false);
    }

    @DisplayName("빈 문자열이 있을 경우 예외가 발생한다.")
    @Test
    void 빈_문자열이_있을_경우_예외가_발생한다() {
        assertThat(inputValidator.empty(""))
                .isEqualTo(false);
    }

    @DisplayName("로또 번호 개수가 6이 아니면 예외가 발생한다.")
    @Test
    void 로또_번호_개수가_6이_아니면_예외가_발생한다() {
        String[] splitPrizeNumbers = new String[]{"1","2","3","4","5"};
        assertThat(inputValidator.lottoSize(splitPrizeNumbers.length))
                .isEqualTo(false);
    }

    @DisplayName("당첨 번호에 보너스 번호와 같은 값이 있을 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_보너스_번호와_같은_값이_있을_경우_예외가_발생한다() {
        List<Integer> prizeNumbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 6;

        assertThat(inputValidator.sameNumber(prizeNumbers,bonusNumber))
                .isEqualTo(false);
    }

    @DisplayName("당첨 번호에 중복된 값이 있을 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_값이_있을_경우_예외가_발생한다() {
        Set<String> notDuplication = new HashSet<>(Arrays.asList("1","2","3","4","5"));
        String str = "5";

        assertThat(inputValidator.sameNumberInPrize(notDuplication,str))
                .isEqualTo(false);
    }
}
