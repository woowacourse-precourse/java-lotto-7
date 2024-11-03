package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PrizeNumbersTest {

    @DisplayName(", 외에 다른 특수문자 포함시 예외 발생")
    @Test
    void 콤마_외에_다른_특수문자_포함시_예외_발생() {
        assertThatThrownBy(() -> new PrizeNumbers("1,.2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호에는 ,와 숫자값만 입력해주세요");
    }

    @DisplayName("당첨 번호 문자열에 공백값이 있어도 숫자를 변형하는데 문제가 있으면 안된다.")
    @ValueSource(strings = {"1 ,2 ,3 ,4 ,5 ,6 ", "1    ,  2   , 3           ,      4               ,      5      ,          6   "})
    @ParameterizedTest
    void 공백값이_존재해도_예외가_발생하면_안됨(String prizeNumber) {
        assertDoesNotThrow(() -> new PrizeNumbers(prizeNumber));
    }

    @DisplayName("양 끝에 ,가 있으면 예외가 발생된다")
    @ValueSource(strings = {", 1,2,3,4", "1,2,3,4,"})
    @ParameterizedTest
    void 양끝에_콤마가_있으면_예외_발생(String prizeNumList) {
        assertThatThrownBy(() -> new PrizeNumbers(prizeNumList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양 끝에 ,가 있거나 ,가 연속으로 2개가 있는지 확인해주세요");
    }

    @DisplayName(",가 연속으로 있어도 예외가 발생된다.")
    @ValueSource(strings = {"1,2,3,,4", "1,2,3,4,,,,,,,,,,,,,,,,,,,,,,,,,,,", ",,1,2,3,4", "1,,2,3,4"})
    @ParameterizedTest
    void 연속으로_콤마가_있어도_예외_발생(String prizeNumList) {
        assertThatThrownBy(() -> new PrizeNumbers(prizeNumList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 양 끝에 ,가 있거나 ,가 연속으로 2개가 있는지 확인해주세요");
    }

    @DisplayName("보너스 번호가 숫자, 공백 외의 값을 가지고 있으면 예외 발생")
    @ValueSource(strings = {"4,", "4번", "4a", "4A", "4ㅁ"})
    @ParameterizedTest
    void 보너스_번호가_숫자_공백_외의_값을_가지면_예외_발생(String bonusNumber) {
        assertThatThrownBy(() -> new BonusNumbers(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자값만 입력해야합니다.");
    }

    @DisplayName("보너스 번호에 공백이 있어도 예외 발생하면 안된다.")
    @ValueSource(strings = {"23 ", "1 4 ", " 10 ", "     11    ", " 21  "})
    @ParameterizedTest
    void 보너스_번호에_공백이_있어도_예외_발생하면_안된다(String bonusNumber) {
        assertDoesNotThrow(() -> new BonusNumbers(bonusNumber));
    }

    @DisplayName("당첨번호중 같은 번호가 있으면 예외 발생")
    @Test
    void 당첨_번호중_같은_번호가_있으면_예외_발생() {
        assertThatThrownBy(() -> new PrizeNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호중 동일한 번호가 존재합니다");
    }

    @DisplayName("입력값의 번호가 45를 넘어가면 예외발생")
    @Test
    void 입력값이_45가_넘으면_예외_발생() {
        assertThatThrownBy(() -> new PrizeNumbers("1,2,3,4,50,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 45를 넘을 수 없습니다.");
    }


    @DisplayName("보너스 당첨 번호 입력값의 번호가 45를 넘어가면 예외발생")
    @Test
    void 보너스_번호_입력값이_45가_넘으면_예외_발생() {
        assertThatThrownBy(() -> new BonusNumbers("60"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 45를 넘을 수 없습니다.");
    }

    @DisplayName("당첨번호가 정상적인 입력값이어도 6개가 아니면 예외 발생")
    @ValueSource(strings = {"1,2,34,5", "1,2,3,4,5,6,7", "1,2,3,4,5", "1,2,3,4,5,6,7,8"})
    @ParameterizedTest
    void 입력값_개수_6개_아니면_예외(String prizeNumber) {
        assertThatThrownBy(() -> new PrizeNumbers(prizeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨번호는 6개의 숫자가 있어야합니다.");
    }
}