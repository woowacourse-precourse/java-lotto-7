package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("1,2를 ','로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    void split_했을_때_1과_2로_잘_분리되는지_확인하는_학습_테스트() {
        // given
        String input = "1,2";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("1을 ','로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    void splint_했을_때_1만을_포함하는_배열이_반환되는지에_대한_학습_테스트() {
        // given
        String input = "1";

        // when
        String[] result = input.split(",");

        // then
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 1,2를 반환하도록 구현한다.")
    void substring_메소드를_활용해_제거() {
        // given
        String input = "(1,2)";

        // when
        String result = input.substring(1, input.length() - 1);

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져오는 charAt() 메서드 테스트")
    void charAt_활용_테스트() {
        // given
        String input = "abc";

        // when
        char result = input.charAt(1);

        // then
        assertThat(result).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt() 메서드에서 인덱스 초과 시 예외 발생 테스트")
    void charAt_인덱스_초과_예외() {
        // given
        String input = "abc";

        // then
        assertThatThrownBy(() -> {

            // when
            input.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("Index 3 out of bounds for length 3");
    }
}
