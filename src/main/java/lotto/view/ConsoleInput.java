package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorMessage;

public class ConsoleInput {
        public String inputString() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.unknownError);
        }
    }

}
