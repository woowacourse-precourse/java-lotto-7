package lotto.model;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public int purchaseValue() {
        String value = Console.readLine();
        return Integer.parseInt(value);
    }
}
