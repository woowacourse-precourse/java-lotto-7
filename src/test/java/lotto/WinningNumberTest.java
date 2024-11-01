package lotto;

import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {
    private final WinningNumberValidator validator = new WinningNumberValidator();
    private static List<Integer> testWinningNums;

    @BeforeAll
    static void setUp() {
        testWinningNums =  Stream.of(2, 13, 20, 23, 31, 42)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Test
    void 정상적인_당첨_번호_입력() {
        List<Integer> actual = validator.validateWinningNumbers("1,2,3,4,5,6");
        assertThat(actual).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 당첨_번호가_6개가_아니면_예외_발생() {
        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_숫자가_아닌_것이_있으면_예외_발생() {
        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,three,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_1이상_45이하_정수가_아닌_것이_있으면_예외_발생() {
        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,3,4,-5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_중복이_있으면_예외_발생() {
        assertThatThrownBy(() -> validator.validateWinningNumbers("1,2,2,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상적인_보너스_번호_입력() {
        assertThat(validator.validateBonusNumber(testWinningNums, "45"))
                .isEqualTo(45);
    }

    @Test
    void 보너스_번호가_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> validator.validateBonusNumber(testWinningNums, "ten"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1이상_45이하_정수가_아니면_예외_발생() {
        assertThatThrownBy(() -> validator.validateBonusNumber(testWinningNums, "70"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외_발생() {
        assertThatThrownBy(() -> validator.validateBonusNumber(testWinningNums, "23"))
        .isInstanceOf(IllegalArgumentException.class);
    }
}
