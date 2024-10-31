package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputModelTest {

    @Test
    void getInput_정상_작동한다() {
        // given
        String input = "입력";
        InputModel inputModel = new InputModel(input);

        // when
        String result = inputModel.getInput();

        // then
        Assertions.assertThat(result).isEqualTo(input);
    }
}