package lotto.view;

public interface View {
    void displayException(String message);

    String promptPurchaseAmount();

    String promptWinningNumbers();

    String promptBonusNumber();
}
