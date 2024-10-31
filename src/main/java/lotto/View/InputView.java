package lotto.View;

import lotto.Model.Exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private List<Integer> winNumbers;

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

    public List<Integer> getWinNumber() {
        List<Integer> winNumber = new ArrayList<Integer>();
        int validWinNum = 0;
        while (validWinNum == 0) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String[] winNumInput = readLine().split(",");
            validWinNum = winNumTypeValidate(winNumInput);
            if (validWinNum == 1) {
                validWinNum = dupValidate(winNumInput);
            }
            if (validWinNum == 2) {
                winNumber = makeWinNums(winNumInput);
            }
        }
        this.winNumbers = winNumber;
        return winNumber;
    }

    public int getBonusNum() {
        int validBonusNum = 0;
        int bonusNumber = 0;
        while (validBonusNum == 0) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNum = readLine();

            validBonusNum = generalBonusValidate(bonusNum);

            if (validBonusNum != 0) {
                bonusNumber = Integer.parseInt(bonusNum);
            }
        }
        return bonusNumber;
    }

    private int generalBonusValidate(String bonusNum) {
        int validBonusNum = bonusNumTypeValidate(bonusNum);
        if (validBonusNum == 1) {
            validBonusNum = bonusNum1to45Validate(Integer.parseInt(bonusNum));
        }
        if (validBonusNum == 2) {
            validBonusNum = bonusNumDupValidate(Integer.parseInt(bonusNum));
        }
        return validBonusNum;
    }

    private int bonusNumTypeValidate(String bonusNum) {
        try {
            Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            System.out.println(Exception.INVALID_NUMBER_TYPE.getErrorMessage());
            return 0;
        }
        return 1;
    }

    private int bonusNum1to45Validate(int bonusNum) {
        if (bonusNum <= 45 && bonusNum >= 1) {
            return 2;
        }
        System.out.println(Exception.INVALID_NUMBER_RANGE.getErrorMessage());
        return 0;
    }

    private int bonusNumDupValidate(int bonusNum) {
        if (this.winNumbers.contains(bonusNum)) {
            System.out.println(Exception.EXIST_BONUS_NUMBER.getErrorMessage());
            return 0;
        }
        return 3;
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
        return 1;
    }

    private void check1000(int purAmount) {
        if (purAmount != (purAmount / 1000) * 1000) {
            throw new IllegalArgumentException(Exception.MONEY_IS_NOT_1000UNIT.getErrorMessage());
        }
    }

    private int dupValidate(String[] winNums) {
        List<Integer> winTemp = new ArrayList<Integer>();
        for (String winNum : winNums) {
            if (winTemp.contains(Integer.parseInt(winNum))) {
                System.out.println(Exception.DUPLICATE_NUMBER.getErrorMessage());
                return 0;
            }
            winTemp.add(Integer.parseInt(winNum));
        }
        return 2;
    }

    private List<Integer> makeWinNums(String[] winNums) {
        List<Integer> winNumList = new ArrayList<Integer>();
        for (String winNum : winNums) {
            winNumList.add(Integer.parseInt(winNum));
        }
        Collections.sort(winNumList);
        return winNumList;
    }

    private int winNumTypeValidate(String[] winNumInput) {

        try {
            Integer.parseInt(String.join("", winNumInput));
        } catch (NumberFormatException e) {
            System.out.println(Exception.INVALID_NUMBER_TYPE.getErrorMessage());
            return 0;
        }
        return 1;

    }
}
