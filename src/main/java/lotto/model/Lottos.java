package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.dto.CreateLottoInfo;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> userLottos;

    public Lottos(long lottoNum) {
        userLottos = new ArrayList<>();

        for (int i = 0; i < lottoNum; i++) {
            userLottos.add(new Lotto(createRandomLotto()));
        }
    }

    public CreateLottoInfo getUserLottos() {
        StringBuilder userLottoNumbers = new StringBuilder();
        userLottos.forEach(lotto -> userLottoNumbers.append(lotto.getLottoNumbers()));

        return new CreateLottoInfo(getUserLottoCount(), userLottoNumbers.toString());
    }

    public long getUserLottoCount() {
        return userLottos.size();
    }

    private List<Integer> createRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
