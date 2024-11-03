package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("추첨 테스트")
public class DrowTest {

    @Nested
    @DisplayName("예외처리 테스트")
    class ValidationTest {

        @Test
        void 당첨_번호는_숫자가_반드시_6개로_구분되어야_한다() {

        }

        @Test
        void 당첨_번호는_숫자로_되어있어야_한다() {

        }

        @Test
        void 당첨_번호는_1보다_작을_수_없다(){

        }

        @Test
        void 당첨_번호는_45보다_클_수_없다(){

        }

        @Test
        void 보너스_번호는_1보다_작을_수_없다(){

        }

        @Test
        void 보너스_번호는_45보다_클_수_없다(){

        }


        @Test
        void 숫자는_중복되면_안된다(){

        }

        @Test
        void 보너스_번호_또한_당첨번호_숫자와_중복되면_안된다(){

        }


    }

}
// 1. 숫자와 쉽표만 입력되어야 한다.
// 2. 당첨 번호는 숫자가 반드시 6개로 구분되어야 한다.
// 3. 숫자가 중복되면 안된다.
// 4. 보너스 번호 또한 당첨 번호 숫자와 중복되면 안된다.
