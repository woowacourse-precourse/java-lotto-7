package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputProcessor {
    private int tryCount;
    private List<Integer> victoryNumbers;
    private int bonusNumber;

    public InputProcessor() {
        this.tryCount = 0;
    }

    public void processPrice(String readLine) {
        try {
            Integer.parseInt(readLine);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자를 입력해주세요.");
        }
        int tmpPrice = Integer.parseInt(readLine.trim());
        validatePrice(tmpPrice);
        this.tryCount = tmpPrice / 1000;
    }

    public void processVictoryNumber(String readLine) {
        String[] split = readLine.split(",");
        arrayToList(split);
        validateVictoryNumbers(victoryNumbers);
        victoryNumbers.sort(Integer::compareTo);
    }

    public void processBonusNumber(String readLine) {
        try {
            Integer.parseInt(readLine);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자를 입력해주세요.");
        }
        int tmpBonus = Integer.parseInt(readLine.trim());
        validateBonus(tmpBonus);
        this.bonusNumber = tmpBonus;
    }

    private void validateBonus(int tmpBonus) {
        validateBonusRange(tmpBonus);
        validateDuplicate(tmpBonus, victoryNumbers);
    }

    private void validateDuplicate(int tmpBonus, List<Integer> victoryNumbers) {
        for (int i : victoryNumbers) {
            if (tmpBonus == i) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복되어서 안됩니다.");
            }
        }
    }

    private void validateBonusRange(int tmpBonus) {
        if (tmpBonus < 1 || tmpBonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45사이의 숫자여야 합니다.");
        }
    }

    private void validateVictoryNumbers(List<Integer> victoryNumbers) {
        validateSize(victoryNumbers);
        validateRange(victoryNumbers);
        validateDuplicate(victoryNumbers);
    }

    private void validateDuplicate(List<Integer> victoryNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(victoryNumbers);
        if (uniqueNumbers.size() != victoryNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되어서는 안됩니다.");
        }
    }

    private void validateRange(List<Integer> victoryNumbers) {
        for (int i : victoryNumbers) {
            if (i < 1 || i > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateSize(List<Integer> victoryNumbers) {
        if (victoryNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validatePrice(int tmpPrice) {
        priceUnitValidate(tmpPrice);
        validateRange(tmpPrice);
    }


    private void validateRange(int param) {
        if (param < 0) {
            throw new IllegalArgumentException("[ERROR] 음수를 입력할 수 없습니다.");
        }
    }

    private void priceUnitValidate(int tmpPrice) {
        if (tmpPrice % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액의 단위는 1000입니다.");
        }
    }

    private void arrayToList(String[] split) {
        victoryNumbers = new ArrayList<>();
        try {
            for (String s : split) {
                victoryNumbers.add(Integer.parseInt(s));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 ','로 구분된 숫자여야 합니다.");
        }
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<Integer> getVictoryNumbers() {
        return new ArrayList<>(victoryNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
