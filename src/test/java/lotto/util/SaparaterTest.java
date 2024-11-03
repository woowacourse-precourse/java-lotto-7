package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SaparaterTest {

    @DisplayName("Saparator 기능 테스트")
    @Test
    void split() {
        Saparater saparater = new Saparater(",");
        String string = "abc,test,123";
        String[] result = saparater.split(string);
        assertThat(result[0]).isEqualTo("abc");
        assertThat(result[1]).isEqualTo("test");
        assertThat(result[2]).isEqualTo("123");
    }

    @DisplayName("Saparator 예외 처리 테스트")
    @Test
    void splitException() {
        assertThatThrownBy(() -> new Saparater("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Saparater(null)).isInstanceOf(IllegalArgumentException.class);

        Saparater saparater = new Saparater(",");
        assertThrows(IllegalArgumentException.class, () -> saparater.split(""));
        assertThrows(IllegalArgumentException.class, () -> saparater.split(null));
    }
}