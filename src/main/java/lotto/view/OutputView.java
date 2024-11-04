package lotto.view;

import java.util.List;
import lotto.enums.UserInterfaceMessage;
import lotto.repository.Lotto;

public class OutputView {
    public void printPublishCount(int size) {
        System.out.printf(UserInterfaceMessage.COUNT_BOUGHT.getValue() + "\n", size);
    }

    public void printPublishedLottoNumbers(List<Lotto> publishedLottoNumbers) {
        for (Lotto publishedLotto : publishedLottoNumbers) {
            System.out.println(publishedLotto.getNumbers());
        }
    }
}