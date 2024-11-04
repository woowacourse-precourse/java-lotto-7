package lotto.service;

import lotto.domain.*;
import lotto.view.LottoView;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

//Enum은 1,2,3,4,5,6등 상금에 사용
public class LottoService {


    //랜덤으로 뽑은 값도 새로운 클래스를 만들지 않고 Lotto를 그대로 사용
    public LottoDTO makeLottos(MoneyDTO moneyDTO) {
        List<Lotto> lottos = new ArrayList<>();
        try {
            for (int i = 0; i < moneyDTO.getTicketNumber(); i++) {
                List<Integer> lottoNumber = new ArrayList<>(getRandomNumber());
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


    public void countMatchingNumbers(CorrectDTO correctDTO, LottoDTO lottoDTO) {
        Set<Integer> correctSet = new HashSet<>(correctDTO.getCorrects().getLotto());
        LottoRank.resetCounts();
        for (Lotto lotto : lottoDTO.getLottos()) {
            Set<Integer> madeSet = new HashSet<>(lotto.getLotto());
            //일치하는 개수 구하기
            Set<Integer> tempCorrectSet = new HashSet<>(correctSet);
            tempCorrectSet.retainAll(madeSet);
            //구한 조건에 맞는 rank를 enum에서 불러서 해당 rank의 개수를 증가
            LottoRank rank = LottoRank.valueOfMatch(tempCorrectSet.size(), madeSet.contains(correctDTO.getBonus()));
            if (rank != null) {
                rank.incrementCount();
            }
        }
    }

    public RateOfReturnDTO calculateRateOfReturn(MoneyDTO moneyDTO) {
        int moneySum = 0;
        for (LottoRank rank : LottoRank.values()) {
            moneySum += (rank.getPrize() * rank.getCount());
        }
        double rateOfReturn = (double) moneySum / moneyDTO.getMoney() * 100;
        return new RateOfReturnDTO(
                Math.round(rateOfReturn * 100) / 100.0);
    }

}
