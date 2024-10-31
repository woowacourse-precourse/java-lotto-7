package lotto.View;

import lotto.Model.Exception;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public int getPurchaseAmount() {

        while (true) {
            System.out.println("구입금액을 입력해 주세요.");

            int result = purNumValidate(readLine());
            if (result != 0) {
                return result;
            }
        }

    }

    public int purNumValidate(String purAmount) {
        int result = 0;
        try {
            result = Integer.parseInt(purAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(Exception.MONEY_IS_NOT_INTEGER.getErrorMessage());
        }
        return result;


    }

}
