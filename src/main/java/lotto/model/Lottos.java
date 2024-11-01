package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoDto;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lotto createLotto() {
        List<Integer> randomNumbers = getRandomNumbers();
        return new Lotto(randomNumbers);
    }

    public void saveLotto(final Lotto lotto) {
        lottos.add(lotto);
    }

    public List<LottoDto> getLottoDtos() {
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoDto lottoDto = LottoDto.from(lotto);
            lottoDtos.add(lottoDto);
        }
        return lottoDtos;
    }

    private List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
