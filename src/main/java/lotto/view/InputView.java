package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Converter;

public class InputView {
    private InputView() {
    }

    public static int getInteger() {
        return Converter.parseInt(Console.readLine());
    }

    public static List<Integer> getLottoNumberList() {
        return Converter.toLottoNumberList(Console.readLine());
    }

    public static int getLottoNumber() {
        return Converter.toLottoNumber(Console.readLine());
    }
}
