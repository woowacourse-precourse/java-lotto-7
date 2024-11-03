package lotto.domain;

import lotto.constants.string.InputError;

public class BonusComponentNumber implements BonusComponent {


    private final ComponentNumber componentNumber;

    public BonusComponentNumber(Lotto winningNumber, ComponentNumber componentNumber) {
        validateDuplicateWithWinningComponent(winningNumber, componentNumber);
        this.componentNumber = componentNumber;
    }

    @Override
    public void validateDuplicateWithWinningComponent(Lotto winningLotto, Component component) {
        if (winningLotto.getComponents().contains(component)) {
            throw new IllegalArgumentException(InputError.DUPLICATE_BONUS_NUMBER.getInstance());
        }
    }

}
