package lotto.model.winningNumber;

public interface NumberGenerator<T, U> {
    WinningNumber registerWinningNumber(T input);

    BonusNumber registerBonusNumber(U input);
}
