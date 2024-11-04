package lotto.committee;

import lotto.MessageCenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class HeadQuarterTest {

    HeadQuarter headQuarter = new HeadQuarter();

    @BeforeEach
    void setUp() {

    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    @DisplayName("일반번호를 정상적으로 입력하면 저장된다.")
    void 일반번호를_정상적으로_입력하면_저장된다(String input) {
        headQuarter.loopMains(input);
        assertThat(headQuarter.wonNumbers.getWonNumbers()).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    @EmptySource
    @DisplayName("입력한 일반번호가 비어있으면 예외가_발생한다.")
    void 입력한_일반번호가_비어있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> headQuarter.loopMains(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PICK.get());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    @EmptySource
    @DisplayName("입력한 보너스번호가 비어있으면 예외가_발생한다.")
    void 입력한_보너스번호가_비어있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> headQuarter.loopBonus(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PICK.get());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4,5"})
    @DisplayName("일반번호를 개수에 맞지 않게 입력하면 예외가_발생한다.")
    void 일반번호를_개수에_맞지_않게_입력하면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> headQuarter.loopMains(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PICK.get());
    }

    @ParameterizedTest
    @ValueSource(strings = {"10.000", "1000.000", "0",
            "-1", "-1000.000", "0.1000"})
    @DisplayName("입력한 보너스번호가 양의 정수가 아니면 예외가_발생한다.")
    void 입력한_보너스번호가_양의_정수가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> headQuarter.loopMains(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PICK.get());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3,4,5,6", "0,1,2,3,4,5", "-100,-1,2,3,4,5",
            "3.14,1,2,3,4,5", "0.1000,1,2,3,4,5"})
    @DisplayName("입력한 일반번호묶음에 양의 정수가 아닌 수가 있으면 예외가_발생한다.")
    void 입력한_일반번호묶음에_양의_정수가_아닌_수가_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> headQuarter.loopMains(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PICK.get());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,3,4,5", "1,1,1,1,1,1", "1,1,7,7,8,8",
            "45,45,45,45,45,45", "1,45,1,45,1,45"})
    @DisplayName("입력한 일반번호묶음에 중복된번호가 있으면 예외가_발생한다.")
    void 입력한_일반번호묶음에_중복된_번호가_있으면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> headQuarter.loopMains(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PICK.get());
    }

    @ParameterizedTest
    @CsvSource({"'1,5,7,8,13,45','1'",
                "'1,2,3,4,5,6', '5'",
                "'1,5,7,8,13,45', '7'",
                "'1,5,7,8,13,45', '8'",
                "'1,5,7,8,13,45', '23'",
                "'1,5,7,8,13,45', '45'"})
    @DisplayName("입력한 보너스번호가 일반번호묶음과 중복되면 예외가_발생한다.")
    void 입력한_보너스번호가_일반번호묶음과_중복되면_예외가_발생한다(String mainNums, String bonusNum) {
        headQuarter.loopMains(mainNums);
        assertThatThrownBy(() -> headQuarter.loopMains(bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageCenter.ERROR_PICK.get());
    }



}
