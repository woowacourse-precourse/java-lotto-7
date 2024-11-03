package lotto;

import lotto.domain.exception.LottoException;

public class Loop {
    interface Func {
        void exec();
    }

    static void executeUntilSuccess(Func func) {
        while (true) {
            try {
                func.exec();
                break;
            } catch (RuntimeException e) {
                if (e instanceof IllegalArgumentException) {
                    System.out.println("[ERROR] " + e.getMessage());
                    continue;
                }
                throw e;
            }
        }
    }
}
