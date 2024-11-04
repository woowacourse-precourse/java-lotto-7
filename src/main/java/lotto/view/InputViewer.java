package lotto.view;
import java.util.List;

public interface InputViewer {
    int readPurchaseAmount();

    List<Integer> readUserLotto();

    int readBonusNumber();
}
