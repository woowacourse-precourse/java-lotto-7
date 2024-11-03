package lotto.model.exception;

import java.util.Arrays;
import java.util.List;
import lotto.model.Answer;
import lotto.model.BonusNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerTest {

    @Test
    @DisplayName("Answer 객체를 생성할 수 있다.")
    void should_CreateAnswer_WhenGivenNumbers() {
        // given
        List<Integer> answerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        BonusNumber bonusNumber = new BonusNumber("7");
        // when
        Answer answer = new Answer(answerNumbers, bonusNumber);
        // then
        Assertions.assertThat(answer).isNotNull();
    }

}