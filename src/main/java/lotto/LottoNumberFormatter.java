package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumberFormatter {

    public List<Integer> convertToNums(String inputWinningNums) {
        String[] inputNums = inputWinningNums.split(",");

        validateWinningNums(inputNums);

        List<Integer> winningNums = new ArrayList<>();
        try {
            for (int i = 0; i < inputNums.length; i++) {
                inputNums[i] = inputNums[i].trim();
                int winningNum = Integer.parseInt(inputNums[i]);
                winningNums.add(winningNum);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 입력이 감지되었습니다.");
        }

        return winningNums;
    }

    public int convertToBonusNum(String bonus) {
        try {
            return Integer.parseInt(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 입력이 감지되었습니다.");
        }
    }

    public void validateWinningNums(String[] winningNums) {
        if (winningNums.length != 6) {
            throw new IllegalArgumentException("[ERROR] 입력된 당첨 번호가 6개가 아닙니다.");
        }
    }

    public void hasDuplicateNum(List<Integer> winningNums, int bonusNum) {
        if (winningNums.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 겹칩니다.");
        }

        Set<Integer> uniqueWinningNums = new HashSet<>(winningNums);

        if (winningNums.size() != uniqueWinningNums.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 당첨 번호가 있습니다.");
        }
    }
}
