package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Input {
    public String readCashAmount() {
        while (true) {
            try {
               return Console.readLine();
            } catch (NoSuchElementException e) {
                System.out.println("[ERROR] 입력값이 없습니다.");
            }
        }
    }

    public void close() {
        Console.close();
    }
}
