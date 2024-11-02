package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.domain.factory.UserSixLottoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    private UserSixLottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        lottoFactory = new UserSixLottoFactory();
    }

    @Test
    void 숫자가_아닌_입력값_예외_처리() {
        String input = "1,ㅁ,3,4,5,6";

        assertThatThrownBy(() -> lottoFactory.make(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잘못된_구분자_입력값_예외_처리() {
        String input = "1/5,3,4,5,6";

        assertThatThrownBy(() -> lottoFactory.make(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_입력값_예외_처리() {
        String input = "1,,3,4,5,6";

        assertThatThrownBy(() -> lottoFactory.make(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}