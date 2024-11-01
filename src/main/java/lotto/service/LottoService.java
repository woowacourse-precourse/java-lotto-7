package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoDTO;
import lotto.domain.MoneyDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

//Enum은 1,2,3,4,5,6등 상금에 사용
public class LottoService {

    //LottoDTO만들어서 list Lotto관리
    public LottoDTO makeLottos(MoneyDTO moneyDTO) {
        List<Lotto> lottos = new ArrayList<>();
        try {
            for (int i = 0; i < moneyDTO.getTicketNumber(); i++) {
                List<Integer> lottoNumber = getRandomNumber();
                lottoNumber.sort(Integer::compareTo);
                Lotto lotto = new Lotto(lottoNumber);
                lottos.add(lotto);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return new LottoDTO(lottos);
    }

    private List<Integer> getRandomNumber() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }

}
