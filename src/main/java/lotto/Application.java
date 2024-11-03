package lotto;

import lotto.enums.ErrorCode;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String money = readLine();
        lottoMachine.buyLotto(parseMoney(money));
        String winningNumbers = readLine();
        String bonusNumber = readLine();
    }

    public static Long parseMoney(String money) {
        try {
            return Long.parseLong(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.MONEY_TYPE_ERROR.getMessage());
        }
    }
}
