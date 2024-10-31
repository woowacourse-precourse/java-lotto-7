package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;
import lotto.global.ErrorCode;

public class InputView {

    int money;
    int count;

    public void buyMoney() {
        int m = -1;
        System.out.println("구입금액을 입력해 주세요.");
        try {
            m = Integer.parseInt(Console.readLine());
            if (m <= 0) {
                throw new InputException(ErrorCode.MINUS_NUMBER_ERROR);
            }
            if (m % 1000 != 0) {
                throw new InputException(ErrorCode.DIVISION_ERROR);
            }
        } catch (InputException e) {
            buyMoney();
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력 해 주세요");
            buyMoney();
        }
        this.money = m;
        this.count = m / 1000;
    }
    
    @Override
    public String toString() {
        return "InputView{" +
                "money=" + money +
                ", count=" + count +
                '}';
    }
}
