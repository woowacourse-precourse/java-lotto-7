package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        // TODO: 추후 예외처리 구현 후 수정
        return readLine();
    }

    public static String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        // TODO: 추후 예외처리 구현 후 수정
        return readLine();
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        // TODO: 추후 예외처리 구현 후 수정
        return readLine();
    }
}
