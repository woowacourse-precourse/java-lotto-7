package exception;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HandlerTest extends NsTest {
    @DisplayName("로또 구입 개수")
    @Test
    void 로또_구입_개수() {
        assertSimpleTest(() -> {
            run("1000", "1,2,3,4,5,6", "7");

            assertThat(output()).contains(
                    "1개를 구매했습니다.");
        });
    }

    @DisplayName("로또 구입 개수")
    @Test
    void 로또_구입_개수_2() {
        assertSimpleTest(() -> {
            run("10000", "14,17,19,23,11,15", "6");

            assertThat(output()).contains(
                    "10개를 구매했습니다.");
        });
    }

    @DisplayName("moneyIsValidException")
    @Test
    void moneyIsValidExceptionTest() {
        assertThatThrownBy(() -> exception.Handler.moneyIsValid(1100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("isValid")
    @Test
    void isValidTest() {
        assertSimpleTest(() -> {
            boolean result = exception.Handler.isValid(List.of(31, 11, 13, 15, 42, 32));
            assertThat(result).isEqualTo(true);
        });
    }

    @DisplayName("isValidException_validateNumbers")
    @Test
    void isValidExceptionTest1() {
        assertSimpleTest(() -> {
            boolean result = exception.Handler.isValid(List.of(1, 2, 3, 4, 5));
            assertThat(result).isEqualTo(false);
        });
    }

    @DisplayName("isValidException_findDuplicateNumber")
    @Test
    void isValidExceptionTest2() {
        assertSimpleTest(() -> {
            boolean result = exception.Handler.isValid(List.of(1, 2, 3, 4, 5, 5));
            assertThat(result).isEqualTo(false);
        });
    }

    @DisplayName("moneyIsValidException_findInvalidNumber")
    @Test
    void isValidExceptionTest3() {
        assertSimpleTest(() -> {
            boolean result = exception.Handler.isValid(List.of(44, 45, 46, 7, 8, 35));
            assertThat(result).isEqualTo(false);
        });
    }

//    @DisplayName("findDuplicateNumber") private이라서 테스트 불가
//    @Test
//    void findDuplicateNumberTest() {
//        assertSimpleTest(() -> {
//            boolean result = exception.Handler.findDuplicateNumber(List.of(1, 2, 3, 4, 5, 5));
//            assertThat(result).isEqualTo(5);
//        });
//    }
//
//    @DisplayName("findInvalidNumber")
//    @Test
//    void findDuplicateNumberTest() {
//        assertSimpleTest(() -> {
//            boolean result = exception.Handler.findInvalidNumber(List.of(31, 11, 13, 15, 42, 32));
//            assertThat(result).isEqualTo(true);
//        });
//    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

