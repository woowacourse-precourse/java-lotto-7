package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class BonusNumberInputConsoleHandler {
    public void showBonusNumberGuideMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public int askBonusNumber() {
        String rawBonusNumber = Console.readLine();

        try {
            return Integer.parseInt(rawBonusNumber);
        } catch (NumberFormatException | NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 형식이 잘못되었습니다.");
        }
    }
}
