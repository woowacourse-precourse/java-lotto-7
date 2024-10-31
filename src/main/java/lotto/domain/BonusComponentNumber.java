package lotto.domain;

import lotto.constants.message.InputError;

public class BonusComponentNumber implements BonusComponent {


    private final ComponentNumber componentNumber;

    public BonusComponentNumber(Lotto winningNumber, ComponentNumber componentNumber) {
        validateDuplicateWithWinningComponent(winningNumber,componentNumber);
        this.componentNumber=componentNumber;
    }

    //implement된 매서드는 항상 public 입니다.
    @Override
    public void validateDuplicateWithWinningComponent(Lotto winningComponent, Component component) {
        if (winningComponent.getInstance().contains(component)){
            throw new IllegalArgumentException(InputError.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

}
