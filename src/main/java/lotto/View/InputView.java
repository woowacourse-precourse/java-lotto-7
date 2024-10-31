package lotto.View;

import lotto.Model.Exception;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public int getPurchaseCount() {

        while (true) {
            System.out.println("구입금액을 입력해 주세요.");

            String purNum = readLine();
            int rstType = purNumTypeValidate(purNum);
            int amount = Integer.parseInt(purNum);
            int rst1000 = purNum1000Validate(amount);

            if (rstType + rst1000 == 2) {
                return amount/1000;
            }
        }
    }

    public int purNumTypeValidate(String purAmount) {

        try {
            Integer.parseInt(purAmount);
        } catch (NumberFormatException e) {
            System.out.println(Exception.MONEY_IS_NOT_INTEGER.getErrorMessage());
            return 0;
        }
        return 1;

    }

    public int purNum1000Validate(int purAmount) {
        try {
            check1000(purAmount);
        } catch (IllegalArgumentException e) {
            return 0;
        }
        return 1;
    }

    public void check1000(int purAmount) {
        if (purAmount != (purAmount / 1000) * 1000) {
            throw new IllegalArgumentException(Exception.MONEY_IS_NOT_1000UNIT.getErrorMessage());
        }
    }

}
