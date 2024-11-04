package lotto.controller.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import lotto.controller.LottoPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    public InputStream generateInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @ValueSource(strings = {"asda","-123000","123002","0","123000"})
    @DisplayName("입력값이 잘못되었으면 input값을 다시 받는다.")
    void inputAmount(String input) {
        //given
        InputStream in = generateInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        InputView inputView = new InputView(Validator.newInstance(new LottoPolicy()));
        //when
        while (scanner.hasNextLine()) {
            int i = inputView.inputAmount();
        }
        //then

    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7","-1,2,3,4,5,6","q,1,2,3,4,5","0;1;2;3;4;5","1,2,3,3,4,5","1,2,3,0,4,5","1,2,3,4,5,6"})
    @DisplayName("입력값이 잘못되었으면 input값을 다시 받는다.")
    void inputWinningNumber(String input) {
        //given
        InputStream in = generateInput(input);
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        InputView inputView = new InputView(Validator.newInstance(new LottoPolicy()));

        //when
        while (scanner.hasNextLine()) {
            List<Integer> integers = inputView.inputWinningNumber();
        }

        //then
    }



}