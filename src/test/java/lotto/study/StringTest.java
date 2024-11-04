package lotto.study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName("1,2를 콤마(,)로 분리했을 때, 1과 2로 분리되는지 확인")
	void 문자열_분리한결과_1과2() {
		String[] result = "1,2".split(",");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName("1을 콤마(,)로 분리했을 때, 1만 포함되는지 확인")
	void 문자열_분리한결과_1() {
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName("(1,2)에서 괄호를 제거했을 때, '1,2' 반환되는지 확인")
	void 문자열_괄호_제거결과_1과2() {
		String input = "(1,2)";
		String result = input.substring(1, input.length() - 1);
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("abc에서 특정 위치의 문자 가져오기")
	void 특정_위치_문자_가져오기() {
		String input = "abc";
		char result = input.charAt(1);
		assertThat(result).isEqualTo('b');
	}

	@Test
	@DisplayName("위치 값 벗어나 예외 발생")
	void 위치_값_벗어나면_예외발생() {
		String input = "abc";
		assertThatThrownBy(() -> input.charAt(5))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("Index 5 out of bounds for length 3");
	}
}
