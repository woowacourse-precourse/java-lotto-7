package lotto.custom.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.custom.validator.CustomErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberServiceTest {
    private final BonusNumberService bonusNumberService = new BonusNumberService();

    @DisplayName("서비스_보너스번호입력_NULL일때_테스트")
    @Test
    void 서비스_보너스번호입력_NULL일때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumberService.run(winningNumbers, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.NULL_INPUT);
    }

    @DisplayName("서비스_보너스번호입력_빈문자열일때_테스트")
    @Test
    void 서비스_보너스번호입력_빈문자열일때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumberService.run(winningNumbers, ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.EMPTY_INPUT);
    }

    @DisplayName("서비스_보너스번호입력_공백으로구성되어있을때_테스트")
    @Test
    void 서비스_보너스번호입력_공백으로구성되어있을때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumberService.run(winningNumbers, "   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.WHITESPACE_ONLY);
    }

    @DisplayName("서비스_보너스번호입력_숫자와공백을제외한문자가존재할때_테스트")
    @Test
    void 서비스_보너스번호입력_숫자와공백을제외한문자가존재할때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumberService.run(winningNumbers, "*"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.INVALID_CHARACTERS);
    }

    @DisplayName("서비스_보너스번호입력_숫자와숫자사이에공백이존재할때_테스트") // 고칠 것
    @Test
    void 서비스_보너스번호입력_숫자와숫자사이에공백이존재할때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumberService.run(winningNumbers, "1 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(lotto.custom.common.ErrorMessages.SPACE_BETWEEN_NUMBERS);
    }

    @DisplayName("서비스_보너스번호입력_보너스번호와당첨번호가같을때_테스트") // 고칠 것
    @Test
    void 서비스_보너스번호입력_보너스번호와당첨번호가같을때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumberService.run(winningNumbers, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.BONUS_NUMBER_DUPLICATE);
    }

    @DisplayName("서비스_보너스번호입력_숫자의범위가1에서45가아닐때_테스트") // 고칠 것
    @Test
    void 서비스_보너스번호입력_숫자의범위가1에서45가아닐때_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> bonusNumberService.run(winningNumbers, "47"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
    }

    @DisplayName("서비스_보너스번호입력_앞뒤단일공백제거_테스트") // 고칠 것
    @Test
    void 서비스_보너스번호입력_앞뒤단일공백제거_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = bonusNumberService.run(winningNumbers, " 7 ");
        assertThat(result).isEqualTo(7);
    }

    @DisplayName("서비스_보너스번호입력_앞뒤연속공백제거_테스트") // 고칠 것
    @Test
    void 서비스_보너스번호입력_앞뒤연속공백제거_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = bonusNumberService.run(winningNumbers, "  7  ");
        assertThat(result).isEqualTo(7);
    }

    @DisplayName("서비스_보너스번호입력_전체실행_테스트") // 고칠 것
    @Test
    void 서비스_보너스번호입력_전체실행_테스트() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = bonusNumberService.run(winningNumbers, "7");
        assertThat(result).isEqualTo(7);
    }
}