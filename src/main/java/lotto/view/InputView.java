package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.NoSuchElementException;

public class InputView {
    private InputView() {
    }

    public static String readInput() {
        try {
            String purchaseAmount = readLine().trim();

            if (purchaseAmount.isEmpty()) {
                throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
            }

            return purchaseAmount;
        } catch (NoSuchElementException e) {
            // EOF에 도달했을 경우 예외 메시지를 명시하고 IllegalArgumentException으로 변환
            throw new NoSuchElementException("입력이 더 이상 존재하지 않습니다. (EOF)", e);
        }
    }
}
