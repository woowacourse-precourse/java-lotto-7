package input;

import constant.InputNotice;
import validation.BonusNumberValidator;

public class BonusNumberInputProcessor implements InputProcessor<Integer> {

    private final BonusNumberValidator bonusNumberValidator;

    public BonusNumberInputProcessor(BonusNumberValidator bonusNumberValidator) {
        this.bonusNumberValidator = bonusNumberValidator;
    }

    @Override
    public Integer putValue() {
        while (true) {
            String inputBonusNumber = receiveInput(InputNotice.BONUS_NUMBER);
            try {
                Integer bonusNumber = changeInteger(inputBonusNumber);
                bonusNumberValidator.validate(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
