package lotto.model.exception;

import java.util.Arrays;
import java.util.List;
import lotto.model.AnswerNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerNumbersTest {

    @Test
    @DisplayName("Answer 객체를 생성할 수 있다.")
    void should_CreateAnswer_WhenGivenNumbers() {
        // given
        List<Integer> answerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        AnswerNumbers answer = new AnswerNumbers(answerNumbers);
        // then
        Assertions.assertThat(answer).isNotNull();
    }

    @Test
    @DisplayName("정답 번호를 반환 받을 수 있다.")
    void should_GetAnswerNumbers() {
        // given
        List<Integer> answerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        AnswerNumbers answer = new AnswerNumbers(answerNumbers);
        // when
        List<Integer> actual = answer.getAnswerNumbers();
        // then
        Assertions.assertThat(actual).isEqualTo(answerNumbers);
    }

    @Test
    @DisplayName("반환 받은 정답 번호는 원본 번호와 동일성을 보장 받지 않는다.")
    void should_NotBeSameInstance_When_GetAnswerNumbers() {
        // given
        List<Integer> answerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        AnswerNumbers answer = new AnswerNumbers(answerNumbers);
        // when
        List<Integer> actual = answer.getAnswerNumbers();
        // then
        Assertions.assertThat(actual).isNotSameAs(answerNumbers);
    }

    @Test
    @DisplayName("반환 받은 정답 번호를 변경하면 예외가 발생한다.")
    void should_ThrowException_When_ModifyAnswerNumbers() {
        // given
        List<Integer> answerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        AnswerNumbers answer = new AnswerNumbers(answerNumbers);
        // when, then
        Assertions.assertThatThrownBy(() -> answer.getAnswerNumbers().add(7))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}