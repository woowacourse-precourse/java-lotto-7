package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("추첨 테스트")
public class DrowTest {

    @Nested
    @DisplayName("예외처리 테스트")
    class ValidationTest {

        @Test
        void 당첨_번호는_숫자가_반드시_6개로_구분되어야_한다() {

            Drow drow = new Drow();

            String fiveNumbers = "1,2,3,4,5"; //5자리 숫자
            String sixNumbers = "1,2,3,4,5,6"; //6자리 숫자
            String sevenNumbers = "1,2,3,4,5,6,7"; //6자리 숫자

            assertThat(drow.validateDrowNumbers(fiveNumbers))
                    .isEqualTo(false);
            assertThat(drow.validateDrowNumbers(sixNumbers)) // 6자리 숫자만 true 반환
                    .isEqualTo(true);
            assertThat(drow.validateDrowNumbers(sevenNumbers))
                    .isEqualTo(false);

        }

        @Test
        void 당첨_번호는_숫자로_되어있어야_한다() {

            Drow drow = new Drow();

            String numbersIncludeAlphabet = "1,2,3,root,5,6";

            assertThat(drow.validateDrowNumbers(numbersIncludeAlphabet))
                    .isEqualTo(false);
        }

        @Test
        void 보너스_번호는_숫자로_되어있어야_한다() {

            Drow drow = new Drow();

            String bonusNumberAlphabet = "root";

            assertThat(drow.validateBonusNumber(bonusNumberAlphabet))
                    .isEqualTo(false);
        }


        @Test
        void 당첨_번호와_보너스_번호는_1보다_작을_수_없다(){

            Drow drow = new Drow();

            int smallNumber = 0;

            assertThatThrownBy(() -> drow.validateInputNumber(smallNumber))
                    .isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        void 당첨_번호와_보너스_번호는_45보다_클_수_없다(){

            Drow drow = new Drow();

            int bigNumber = 46;

            assertThatThrownBy(() -> drow.validateInputNumber(bigNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }


        @Test
        void 숫자는_중복되면_안된다(){
            Drow drow = new Drow();

            String duplicateNumbers = "41,42,43,44,45,45";

            assertThat(drow.validateDrowNumbers(duplicateNumbers))
                    .isEqualTo(false);
        }

        @Test
        void 보너스_번호는_당첨번호_숫자와_중복되면_안된다(){
            Drow drow = new Drow();

            List<Integer> drawNumbers = List.of(1, 2, 3, 4, 5, 6);
            int duplicateBonusNumber = 6;

            assertThatThrownBy(() -> drow.validateDuplicationNumber(drawNumbers,duplicateBonusNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }


    }

}
// 1. 숫자와 쉽표만 입력되어야 한다.
// 2. 당첨 번호는 숫자가 반드시 6개로 구분되어야 한다.
// 3. 숫자가 중복되면 안된다.
// 4. 보너스 번호 또한 당첨 번호 숫자와 중복되면 안된다.
