package lotto.presentation.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printIssuedLottos(List<Lotto> issuedLottos) {
        System.out.println(issuedLottos.size() + "개를 구매했습니다.");
        for (Lotto issuedLotto : issuedLottos) {
            printIssuedLotto(issuedLotto);
        }
    }

    private void printIssuedLotto(Lotto issuedLotto) {
        List<String> toStringLottoNumber = issuedLotto.getNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber))
                .toList();
        System.out.println("[" + String.join(", ", toStringLottoNumber) + "]");
    }
}
