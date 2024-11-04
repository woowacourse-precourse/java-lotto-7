package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoBonus {
    public int bonusNum;

    public int inputBonusNum(List<Integer> lottoNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();

        int bonusNum = changeType(input);
        checkValidRange(bonusNum);
        checkDuplicate(bonusNum, lottoNumbers);
        this.bonusNum = bonusNum;
        return this.bonusNum;
    }

    // 문자열 정수형 변환
    private int changeType(String input) {
        try {
            int changetype = Integer.parseInt(input);
            return changetype;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 문자, 기호 없이 정수를 입력해 주세요.\n다시 입력해 주세요");
        }
    }

    // 숫자 범위 검증 메소드
    private void checkValidRange(int bonusNum) {
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이 숫자만 입력해 주세요.\n다시 입력해 주세요");
        }
    }

    // 당첨번호와 중복 검증 메소드
    private void checkDuplicate(int bonusNum, List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.\n다시 입력해 주세요");
        }
    }
}
