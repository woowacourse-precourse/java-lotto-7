package lotto.model;

import java.util.regex.Pattern;

public class BonusNumbers {
    private Integer bonusPrizeNumber;

    public BonusNumbers(String bonusPrizeNumber) {
        bonusValidation(bonusPrizeNumber);
        this.bonusPrizeNumber = Integer.parseInt(bonusPrizeNumber.replaceAll("\\s", ""));
        bonusSizeCheck();
    }

    /**
     * 보너스 번호는 단일 숫자여야한다.
     * 때문에 정규식에서 숫자값이 아니면 죄다 예외를 던져야한다.
     *
     * @param bonusPrizeNumber
     */
    private void bonusValidation(String bonusPrizeNumber) {
        bonusPrizeNumber = bonusPrizeNumber.replaceAll("\\s", "");
        Pattern bonusPattern = Pattern.compile("[\\D]");
        if (bonusPattern.matcher(bonusPrizeNumber).find()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자값만 입력해야합니다.");
        }
    }


    private void bonusSizeCheck() {
        if (this.bonusPrizeNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 45를 넘을 수 없습니다.");
        }
    }

    public Integer getBonusPrizeNumber() {
        return bonusPrizeNumber;
    }
}
