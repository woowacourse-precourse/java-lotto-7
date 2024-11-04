package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.User;
import lotto.message.LottoMessage;
import lotto.validate.LottosValidate;
import lotto.view.LottosView;

public class LottoService {
    private final User user;
    private final Lottos lottos;

    public LottoService(User user, Lottos lottos) {
        this.user = user;
        this.lottos = lottos;
    }

    public void run() {
        makeLottoNumber(user, lottos);
        loopLottos(lottos);
    }

    public static void makeLottoNumber(User user, Lottos lottos) {
        int lottoAmount = user.getNumOfLottos();

        for (int lotto = 0; lotto < lottoAmount; lotto++) {
            List<Integer> lottoNumbers = getRandomLottoNumber();

            Lotto newLotto = new Lotto(lottoNumbers);
            lottos.addLottoToList(newLotto);
        }
    }

    public static List<Integer> getRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static void sortAscending(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }

    public static void loopLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> lottoNumbers = lotto.getNumber();
            sortAscending(lottoNumbers);

            if (!LottosValidate.isAscendingNumber(lottoNumbers)) {
                System.out.println(LottoMessage.IS_NOT_ASCENDING_NUMBER.getMessage());
                sortAscending(lottoNumbers);
            }

            LottosView.displayLottoNumbers(lottoNumbers);
        }
    }
}
