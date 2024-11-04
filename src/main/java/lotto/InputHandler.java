package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public InputHandler() {

    }


    public List<Integer> integerInverter(String[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (String s : numbers) {
            try {
                int number = Integer.parseInt(s);
                result.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("입력 값은 숫자가 아닙니다.");
            }
        }

        return result;
    }


}
