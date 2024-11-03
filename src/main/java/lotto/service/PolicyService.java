package lotto.service;

import java.util.List;
import lotto.policy.LottoNumberPolicy;
import lotto.policy.LottoPricePolicy;
import lotto.policy.PrizeMoneyPolicy;

public class PolicyService {

//    public PrizeMoneyPolicy getRankAndPrizeMoney(int matchedNumberCount, boolean bonusMatched){
////        List<PrizeMoneyPolicy> rankAndMoney = getPrizeMoney(matchedNumberCount);
//
//        if(isFiveNumberMatched(rankAndMoney)){
//            return secondOrThirdRank(rankAndMoney, bonusMatched);
//        }
//        return rankAndMoney.getFirst();
//    }

//    private List<PrizeMoneyPolicy> getPrizeMoney(int matchedNumberCount){
//        return PrizeMoneyPolicy.getPrizeMoney(matchedNumberCount);
//    }

    private boolean isFiveNumberMatched(List<PrizeMoneyPolicy> rankAndMoney){
        return rankAndMoney.size() == 2;
    }

    private PrizeMoneyPolicy secondOrThirdRank(List<PrizeMoneyPolicy> rankAndMoney, boolean bonusMatch) {
        if(bonusMatch){
            return rankAndMoney.getFirst();
        }
        return rankAndMoney.getLast();
    }

//    public int getLottoNumberScale(){
//        return LottoNumberScalePolicy.LOTTO_NUMBER_SCALE.getNumberScale();
//    }

    public int getLottoMaxNumber(){
        return LottoNumberPolicy.MAX_NUMBER.number();
    }

    public int getLottoMinNumber(){
        return LottoNumberPolicy.MIN_NUMBER.number();
    }

    public int getLottoTicketPrice(){
        return LottoPricePolicy.LOTTO_TICKET_PRICE.price();
    }
}
