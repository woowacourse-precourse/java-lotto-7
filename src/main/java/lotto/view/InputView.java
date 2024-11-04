package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.Converter;

public class InputView {
    public int getInteger() {
        return Converter.parseInt(Console.readLine());
    }

    public List<Integer> getLottoNumberList() {
        return Converter.toLottoNumberList(Console.readLine());
    }

    public int getLottoNumber() {
        return Converter.toLottoNumber(Console.readLine());
    }
}
