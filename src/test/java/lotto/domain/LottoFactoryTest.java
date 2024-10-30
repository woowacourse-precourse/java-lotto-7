package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;

import lotto.domain.user.UserLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    private LottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory();
    }

    @Test
    void 숫자가_아닌_입력값_예외_처리(){
        String input = "1,ㅁ,3,4,5,6";

        assertThatThrownBy(() -> lottoFactory.make(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잘못된_구분자_입력값_예외_처리(){
        String input = "1/5,3,4,5,6";

        assertThatThrownBy(() -> lottoFactory.make(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}