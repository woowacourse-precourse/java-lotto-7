package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class ConsoleInput {
    public String getPurchasedAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readline();
    }

    public String getWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readline();
    }

    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readline();
    }

    public void close() {
        Console.close();
    }

    private String readline() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException | IllegalStateException error) {
            throw new IllegalArgumentException("입력을 받는데 실패했습니다.", error);
        }
    }
}
