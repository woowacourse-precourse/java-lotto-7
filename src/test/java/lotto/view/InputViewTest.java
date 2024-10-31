package lotto.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void testInputNumber() {
        //given
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        new Scanner(System.in);
        //when
        String result = InputView.getInput(input);
        //then
        assertThat(result).isEqualTo(input);
    }
}