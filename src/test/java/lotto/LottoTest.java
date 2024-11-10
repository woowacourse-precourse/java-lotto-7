package lotto;

import lotto.domain.Handler;
import lotto.view.Input;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성


    //    중복된 숫자가 포함된 경우 : IllegalArgumentException
    @DisplayName("중복된 숫자가 포함된 경우 : IllegalArgumentException")
    @Test
    void IllegalArgumentExceptionTest_되도_않는_영어이름_테스트_3() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }



    //    입력 수가 6개가 넘어가는 경우 : OutOfRangeException -> IllegalArgumentException 기존 고객 요구에 맞춰 예외명 개선
    @DisplayName("입력 수가 6개가 넘어가는 경우 IllegalArgumentException")
    @Test
    void IllegalArgumentExceptionTest_되도_않는_영어이름_테스트_5() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}


