package lotto.domain;

public class BonusNumber extends NumberImpl {

    final int bonusNumber;

    public BonusNumber(String rawBonusNumber) {
        String trimBonusNumber = rawBonusNumber.trim();
        validateBlank(trimBonusNumber, getDomain());
        validateNumber(trimBonusNumber, getDomain());
        Integer bonusNumber = Integer.parseInt(trimBonusNumber);
        validateRange(bonusNumber, getDomain());
        this.bonusNumber = Integer.parseInt(trimBonusNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public String getDomain() {
        return "보너스번호";
    }
}
