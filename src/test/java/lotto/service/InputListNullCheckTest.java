package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class InputListNullCheckTest {

    @DisplayName("리스트 형태의 빈 문자열일 때 예외가 발생한다.")
    @Test
    void 리스트_형태의_빈_문자열일_때_예외가_발생한다() {
        Assertions.assertThatThrownBy(() -> new InputListNullCheck(List.of(""))).isInstanceOf(IllegalArgumentException.class);
    }

}