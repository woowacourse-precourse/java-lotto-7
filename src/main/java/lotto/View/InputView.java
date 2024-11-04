package lotto.View;

import lotto.Model.Exception;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public int getPurchaseCount() {

        int valid = 0;
        int amount = 0;

        while (valid == 0) {
            System.out.println("구입금액을 입력해 주세요.");
            String purNum = readLine();
            valid = totalPurNumValidate(purNum);
            if (valid == 1) {
                amount = Integer.parseInt(purNum);
                System.out.println(amount/1000 + "개를 구매했습니다.");
                return amount/1000;
            }
        }
        return amount;
    }


    public String[] getWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine().split(",");
    }

    public int getBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine());
    }

    private int totalPurNumValidate(String purNum) {
        int valid = purNumTypeValidate(purNum);
        int amount = 0;
        if (valid == 1) {
            amount = Integer.parseInt(purNum);
            valid = purNum1000Validate(amount);
        }
        if (valid == 2) {
            return 1;
        }
        return 0;
    }

    private int purNumTypeValidate(String purAmount) {

        try {
            Integer.parseInt(purAmount);
        } catch (NumberFormatException e) {
            System.out.println(Exception.MONEY_IS_NOT_INTEGER.getErrorMessage());
            return 0;
        }
        return 1;

    }

    private int purNum1000Validate(int purAmount) {
        try {
            check1000(purAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(Exception.MONEY_IS_NOT_1000UNIT.getErrorMessage());
            return 0;
        }
        return 2;
    }

    private void check1000(int purAmount) {
        if (purAmount != (purAmount / 1000) * 1000) {
            throw new IllegalArgumentException(Exception.MONEY_IS_NOT_1000UNIT.getErrorMessage());
        }
    }
}
