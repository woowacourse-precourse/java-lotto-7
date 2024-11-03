package lotto.view;

import java.util.List;

public interface InputViewer {
    public int readPurchaseAmount();

    public List<Integer> readUserLotto();

    public int readBonusNumber();
}
