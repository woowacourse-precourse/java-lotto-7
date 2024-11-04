package lotto;

import java.util.ArrayList;
import java.util.List;

public class PrizeCheck {
    private final String comma =",";
    private List<Integer> prizeNum;
    private int bonus;

    public void checkAndChangePrizeNum(String prizeNum) {
        validatePrizeNum(prizeNum);
        ArrayList<Integer> prizeNum1 = getPrizeNum(prizeNum);
        repeatValidate(prizeNum1);
        negativeValidate(prizeNum1);
        this.prizeNum = prizeNum1;
    }

    public void checkAndChangeBonusNum(String bonusNum) {
        int bonus = getBonusNum(bonusNum);
        repeatValidate(prizeNum, bonus);
        negativeValidate(bonus);
        this.bonus = bonus;
    }

    private int getBonusNum(String bonusNum) {
        int bonus;
        try {
            bonus = Integer.parseInt(bonusNum);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 보너스 번호가 숫자 형식이 아닙니다.");
        }
        return bonus;
    }

    private void repeatValidate(List<Integer> numbers, int bonusNum) {
        numbers.add(bonusNum);
        if (repetition(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호랑 보너스 번호는 중복되면 안됩니다.");
        }
    }

    private void validatePrizeNum(String prizeNum) {
        if (splitString(prizeNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨 숫자가 6개가 아닙니다.");
        }
    }

    // 중복 값
    private void repeatValidate(List<Integer> numbers) {
        if (repetition(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되면 안됩니다.");
        }
    }

    private void negativeValidate(ArrayList<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 0보다 작으면 안됩니다.");
            }
        }
    }

    private void negativeValidate(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 0보다 작으면 안됩니다.");
        }
    }

    private boolean repetition(List<Integer> numbers) {
        ArrayList<Integer> previousValue = new ArrayList<>();

        for (Integer number : numbers) {
            if (previousValue.contains(number)) {
                return true;
            }
            previousValue.add(number);
        }
        return false;
    }

    private boolean splitString(String prizeNum) {
        String[] prizeNums = getSplitPrizeNum(prizeNum);
        if (prizeNums.length != 6) {
            return true;
        }
        return false;
    }

    private String[] getSplitPrizeNum(String prizeNum) {
        if (!prizeNum.contains(comma)) {
            throw new IllegalArgumentException("[Error] 당첨 번호 입력이 잘 못 되었습니다. 다시 입력해주세요.");
        }
        String[] prizeNums = prizeNum.split(comma);
        return prizeNums;
    }

    private ArrayList<Integer> getPrizeNum(String prizeNum) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (String s : getSplitPrizeNum(prizeNum)) {
            try {
                int num = Integer.parseInt(s);
                nums.add(num);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("[ERROR] 당첨 번호가 숫자 형식이 아닙니다.");
            }
        }
        return nums;
    }

    public ArrayList<>
    // int match count ,boolean bonus match
}
