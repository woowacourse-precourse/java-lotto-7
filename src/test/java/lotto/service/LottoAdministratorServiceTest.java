package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.EmptyInputException;
import lotto.exception.NotNumberException;
import lotto.exception.administrator.LottoNumbersDuplicationException;
import lotto.exception.administrator.LottoNumbersMustBeSixException;
import lotto.exception.administrator.NotNumberOrCommaException;
import lotto.exception.administrator.OutOfRangeLottoNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoAdministratorServiceTest {

    private LottoAdministratorService service;

    @BeforeEach
    void setUp() {
        service = new LottoAdministratorService();
    }

    @Nested
    @DisplayName("당첨 번호 검증 테스트")
    class SetUpWinningNumbersTests {

        @Test
        void 숫자_또는_콤마_외_문자_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers("!","1"))
                            .isInstanceOf(NotNumberOrCommaException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 빈값_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers("","1"))
                            .isInstanceOf(EmptyInputException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void Integer_범위를_벗어난_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers(String.valueOf(Long.MAX_VALUE),"1"))
                            .isInstanceOf(OutOfRangeLottoNumberException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 숫자6개_중_빈값_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers("1,2,3,4,,6","7"))
                            .isInstanceOf(OutOfRangeLottoNumberException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 숫자6개_중_범위_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers("1,2,3,4,46,6","7"))
                            .isInstanceOf(OutOfRangeLottoNumberException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 숫자6개_중_중복_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers("1,2,3,4,4,6","7"))
                            .isInstanceOf(LottoNumbersDuplicationException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 콤마와_콤마_사이_빈값_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers(",,","1"))
                            .isInstanceOf(LottoNumbersMustBeSixException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 숫자_6개_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers("1,2,3,4,5","1"))
                            .isInstanceOf(LottoNumbersMustBeSixException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 정상_테스트() {
            assertSimpleTest(() ->
                    assertDoesNotThrow(() ->
                            service.setUpWinningNumbers("1,2,3,4,5,6","7")));
        }
    }

    @Nested
    @DisplayName("보너스 번호 검증 테스트")
    class BonusNumberTests {

        @Test
        void 빈값_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers("1,2,3,4,5,6",""))
                            .isInstanceOf(EmptyInputException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 숫자_아닌_문자_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers("1,2,3,4,5,6","!"))
                            .isInstanceOf(NotNumberException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void Integer_범위를_벗어난_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers("1,2,3,4,5,6",String.valueOf(Long.MAX_VALUE)))
                            .isInstanceOf(OutOfRangeLottoNumberException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 범위_예외테스트() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            service.setUpWinningNumbers("1,2,3,4,5,6","0"))
                            .isInstanceOf(OutOfRangeLottoNumberException.class)
                            .isInstanceOf(IllegalArgumentException.class));
        }

        @Test
        void 정상_테스트() {
            assertSimpleTest(() ->
                    assertDoesNotThrow(() ->
                            service.setUpWinningNumbers("1,2,3,4,5,6","45")));
        }
    }
}