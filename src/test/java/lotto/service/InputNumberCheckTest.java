package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputNumberCheckTest {

    @DisplayName("입력 문자열이 숫자 형태가 아니면 예외를 발생시킨다.")
    @Test
    void 입력_문자열이_숫자_형태가_아니면_예외를_발생시킨다() {
        Assertions.assertThatThrownBy(() -> new InputNumberCheck("a")).isInstanceOf(IllegalArgumentException.class);
    }

}