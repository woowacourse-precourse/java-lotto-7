package study.string;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringStudyTest {

    /*
       split()의 기능을 요약하면 다음과 같다.
       - 주어진 정규식과 일치하는 문자열 을 기준으로 이 문자열을 분할
       - 기본 limit = 0, limit이 0 이면 패턴이 적용되는 횟수를 제한하지 않음
       - 후행 빈 문자열은 결과 배열에 포함되지 않습니다

       그렇다면 테스트를 했을 때 가치 있는 부분은?
       - join()은 String[] 타입의 값을 반환한다 -> 예상한 값이 정확히 모두 순서대로 존재하는지

       테스트를 했을 때 가치가 없는 부분은?
       - 배열의 크기 확인: 예상한 값이 정확히 모두 순서대로 존재하는지 확인했는데 크기를 확인할 필요가 있나?
    */
    @DisplayName("요구사항 1: split() 무엇을 검증하는 것이 가치가 있는가?")
    @Test
    void split_가치있는_검증() {
        String number = "1";
        String twoNumbers = "1,2";

        String[] splitNumber = number.split(",");
        String[] splitTwoNumbers = twoNumbers.split(",");

        // contains() 사용 1만 포함하는 배열인지 확인 불가
        assertThat(splitNumber).containsExactly("1");
        assertThat(splitTwoNumbers).containsExactly("1", "2");
    }

    @Test
    void split_가치낮은_검증() {
        String number = "1";
        String twoNumbers = "1,2";

        String[] splitNumber = number.split(",");
        String[] splitTwoNumbers = twoNumbers.split(",");

        // containsOnly()/Exactly() 검증 시 값의 개수와 순서를 확인할 수 있다, 길이를 검증하는 것이 가치가 있나?
        assertThat(splitNumber).hasSize(1);
        assertThat(splitTwoNumbers).hasSize(2);

        // 불필요한 검증
        assertThat(splitNumber).isNotNull();
        assertThat(splitNumber).isNotEmpty();
    }

    @DisplayName("요구사항 2: substring()로 ()을 제거하고 \"1,2\"를 반환")
    @Test
    void substring_가치있는_검증() {
        String input = "(1,2)";

        String removeBracket = input.substring(1, input.length() - 1);

        // 특정된 값을 반환하는지 확인하는 것이 가치가 있다
        assertThat(removeBracket).isEqualTo("1,2");
    }

    @Test
    void substring_가치낮은_검증() {
        String input = "(1,2)";

        String removeBracket = input.substring(1, input.length() - 1);

        // 값을 확인했는데 ()이 없는지 확인할 필요가 있나?
        assertThat(removeBracket).doesNotContain("(", ")");

        // 불필요한 검증
        assertThat(removeBracket).hasSize(3);
    }

    @DisplayName("요구사항 3: abc 문자열에 chatAt() 메서드를 활용해 특정 위치의 문자를 가져온다")
    @Test
    void charAt_가치있는_검증() {
        String abc = "abc";

        char a = abc.charAt(0);
        char b = abc.charAt(1);
        char c = abc.charAt(2);

        assertThat(a).isEqualTo('a');
        assertThat(b).isEqualTo('b');
        assertThat(c).isEqualTo('c');

        assertThatThrownBy(() -> abc.charAt(abc.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContainingAll("Index 3", "length 3");
    }

    @DisplayName("assertThatThrownBy() vs assertThatIllegalArgument(): 실패 메시지는 똑같음, 후자가 1줄이 더 줄어드는 이점")
    @Test
    void 자주_발생하는_예외_검증() {
        /*
         Expecting actual throwable to be an instance of:
            java.lang.IllegalArgumentException
         but was:
            java.lang.IllegalStateException
        */
        assertThatThrownBy(() -> {
            throw new IllegalArgumentException("[ERROR] : 2는 잘못된 인수");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageEndingWith("인수")
                .hasMessageMatching("\\[ERROR\\] : \\d+는 잘못된 인수");

        /*
        java.lang.AssertionError:
        Expecting actual throwable to be an instance of:
            java.lang.IllegalArgumentException
        but was:
            java.lang.IllegalStateException
        */
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    throw new IllegalArgumentException("[ERROR] : 2는 잘못된 인수");
                })
                .withMessageStartingWith("[ERROR]")
                .withMessageEndingWith("인수")
                .withMessageMatching("\\[ERROR\\] : \\d+는 잘못된 인수");
    }

}
