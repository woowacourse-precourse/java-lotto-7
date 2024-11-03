package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class InputListNumberCheckTest {

    @DisplayName("입력 문자열 리스트가 숫자 형태가 아니면 예외를 발생시킨다.")
    @Test
    void 입력_문자열_리스트가_숫자_형태가_아니면_예외를_발생시킨다() {
        Assertions.assertThatThrownBy(() -> new InputListNumberCheck(List.of("a,1,2,3,d,5"))).isInstanceOf(IllegalArgumentException.class);
    }
}