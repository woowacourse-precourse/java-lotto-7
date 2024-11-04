package lotto.service;

import java.util.HashSet;
import java.util.List;

public class ValidService {

    public void checkBig(String money) {
        if (money.length() >= 9) {
            throw new IllegalArgumentException("[ERROR] 9글자 이상 입력하실 수 없습니다");
        }
    }


    public void checkNull(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력에 빈 값이 들어갈 수는 없습니다.");
        }
    }

    public void checkNum(String money) {
        boolean notNumber = !money.matches("\\d+");
        if (notNumber) {
            throw new IllegalArgumentException("[ERROR] 입력에는 숫자만 들어가야 합니다");
        }
    }

    public void check1000s(String money) {
        boolean not1000s = (Integer.parseInt(money) % 1000 != 0 && Integer.parseInt(money) != 0);
        if (not1000s) {
            throw new IllegalArgumentException("[ERROR] 입력에는 1000원 단위에 금액만 들어가야합니다.");
        }
    }

    public void checkLottoNumbers(String stringNumbers) {
        String[] parts = stringNumbers.split(",");
        if (parts.length != 6) {
            throw new IllegalArgumentException("6개의 숫자를 입력해주세요");
        }
        for (String part : parts) {
            tryValid(part);
        }
    }

    public void checkDuplicatedLottoNumbers(List<Integer> winningNumbers) {
        HashSet<Integer> winningNumberSet = new HashSet<>();
        for (Integer winningNumber : winningNumbers) {
            if (winningNumberSet.contains(winningNumber)) {
                winningNumberSet.clear();
                throw new IllegalArgumentException("중복된 숫자를 입력하실 수는 없습니다");
            }
            winningNumberSet.add(winningNumber);
        }
    }


    public void checkBonusNumber(String stringBonusNumber) {
        tryValid(stringBonusNumber);
    }

    public void checkDuplicatedBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber == bonusNumber) throw new IllegalArgumentException("보너스 번호에 중복된 숫자가 들어갈 수 없습니다");
        }
    }

    private void tryValid(String part) {
        try {
            int num = Integer.parseInt(part);
            if (num > 45 || num < 1) {
                throw new IllegalArgumentException("1부터45까지의 숫자만 입력해주세요");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요");
        }
    }


}