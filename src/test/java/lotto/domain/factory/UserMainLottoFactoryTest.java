package lotto.domain.factory;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.lottos.Lotto;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserMainLottoFactoryTest {
    private final UserSixLottoFactory factory = new UserSixLottoFactory();


    @DisplayName("6자리 숫자가 같은지 확인")
    @Test
    void Lotto_객체_생성_확인() {
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);
        String input = "1,2,3,4,5,6";
        boolean expected = true;

        Lotto lotto = factory.make(input);
        for (Integer i : inputNumbers) {
            if (!lotto.isContainNumber(i)) {
                expected = false;
            }
        }
        assertTrue(expected);
    }

    @DisplayName("콤마 이외 특수문자 입력시 예외 처리")
    @Test
    void 잘못된_구분자_예외_처리() {
        String input = "1,2,3,5%,6";
        AssertionsForClassTypes.assertThatThrownBy(() -> factory.make(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_입력값_예외_처리() {
        String input = "";
        AssertionsForClassTypes.assertThatThrownBy(() -> factory.make(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_입력값_예외_처리() {
        String input = " ";
        AssertionsForClassTypes.assertThatThrownBy(() -> factory.make(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈_입력값_포함_예외_처리() {
        String input = "1,2,3,4,,5";
        AssertionsForClassTypes.assertThatThrownBy(() -> factory.make(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}