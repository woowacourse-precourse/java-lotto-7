package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class OutputView {
    public void outputExceptionMessage(String message) {
        System.out.println(message);
    }

    public void outputIssuedLottos(Lottos lottos) {
        outputLottoAmount(lottos);
        for (Lotto lotto : lottos.getLottos()) {
            StringBuilder issuedLotto = Messages.ISSUED_LOTTO(lotto);
            System.out.println(issuedLotto);
        }
    }

    private void outputLottoAmount(Lottos lottos) {
        System.out.println(System.lineSeparator() +
                String.format("%d개를 구매했습니다.", lottos.getLottos().size()));
    }
}
