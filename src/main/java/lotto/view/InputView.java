package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int inputMoney() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 확인해주세요.");
        }
    }

    public static String inputLottoNumbers() {
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 확인해주세요.");
        }
    }
}
