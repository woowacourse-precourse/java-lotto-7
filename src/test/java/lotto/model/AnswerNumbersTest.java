package lotto.model;

import java.util.Arrays;
import java.util.List;
import lotto.model.AnswerNumbers;
import lotto.model.exception.DomainExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AnswerNumbersTest {

    @ParameterizedTest
    @DisplayName("Answer 객체를 생성할 수 있다.")
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6"})
    void should_CreateAnswer_WhenGivenNumbers(String input) {
        // when
        AnswerNumbers answer = AnswerNumbers.from(input);
        // then
        Assertions.assertThat(answer).isNotNull();
    }

    @Test
    @DisplayName("정답 번호를 반환 받을 수 있다.")
    void should_GetAnswerNumbers() {
        // given
        String input = "1,2,3,4,5,6";
        // when
        AnswerNumbers answer = AnswerNumbers.from(input);
        List<LottoNumber> answerNumbers = answer.getAnswerNumbers();
        // then
        Assertions.assertThat(answerNumbers).contains(
                new LottoNumber("1"),
                new LottoNumber("2"),
                new LottoNumber("3"),
                new LottoNumber("4"),
                new LottoNumber("5"),
                new LottoNumber("6")
        );
    }

    @Test
    @DisplayName("반환 받은 정답 번호를 변경하면 예외가 발생한다.")
    void should_ThrowException_When_ModifyAnswerNumbers() {
        // given
        String input = "1,2,3,4,5,6";
        // when
        AnswerNumbers answer = AnswerNumbers.from(input);
        // when, then
        Assertions.assertThatThrownBy(() -> answer.getAnswerNumbers().add(new LottoNumber("7")))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("정답 번호가 6개가 아닌 경우 예외를 발생한다.")
    void should_ThrowException_When_AnswerNumbersSizeIsNotSix() {
        // given
        String input = "1,2,3,4,5";
        // when, then
        Assertions.assertThatThrownBy(() -> AnswerNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainExceptionMessage.INVALID_ANSWER_SIZE.getMessage());
    }

    @Test
    @DisplayName("정답 번호가 중복된 경우 예외를 발생한다.")
    void should_ThrowException_When_AnswerNumbersHasDuplicatedNumbers() {
        // given
        String input = "1,2,3,4,5,5";
        // when, then
        Assertions.assertThatThrownBy(() -> AnswerNumbers.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DomainExceptionMessage.DUPLICATED_ANSWER_NUMBER.getMessage());
    }
}