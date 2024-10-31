package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class LottoSystem {

    private Lotto winningLotto;
    private int bonusNum;

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }

    public void announceWinningLotto() {
        boolean initiatedWinningLotto = false;
        while (!initiatedWinningLotto) {
            initiatedWinningLotto = initWinningLotto();
        }

        boolean initiatedBonusNum = false;
        while (!initiatedBonusNum) {
            initiatedBonusNum = initBonusNum();
        }
    }

    private boolean initWinningLotto() {
        try {
            String inputNums = getInput("\n당첨 번호를 입력해 주세요.");
            List<Integer> numbers = Arrays.stream(inputNums.split(",")).mapToInt(Integer::parseInt).boxed().toList();
            validateLottoNumRange(numbers);
            winningLotto = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private boolean initBonusNum() {
        try {
            int num = Integer.parseInt(getInput("\n보너스 번호를 입력해 주세요."));
            validateBonusNum(num);
            this.bonusNum = num;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private String getInput(String output) {
        System.out.println(output);
        return Console.readLine();
    }

    private void validateBonusNum(int bonusNum) {
        validateDuplicate(bonusNum);
        validateLottoNumRange(bonusNum);
    }

    private void validateDuplicate(int bonusNum) {
        if (winningLotto.contains(bonusNum)) {
            throw new BusinessException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateLottoNumRange(List<Integer> numbers) {
        numbers.forEach(this::validateLottoNumRange);
    }

    private void validateLottoNumRange(int num) {
        if (num < 1 || num > 45) {
            throw new BusinessException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
