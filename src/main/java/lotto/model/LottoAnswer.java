package lotto.model;

import java.util.List;

public class LottoAnswer {

    private final List<Integer> lottoAnswer;
    private final Integer bonusNumber;

    public LottoAnswer(List<Integer> lottoAnswer, Integer bonusNumber) {
        this.lottoAnswer = lottoAnswer;
        this.bonusNumber = bonusNumber;
    }

    public Rank getLottoRank(Lotto lotto){
        int answerMatchingNumber = getMatchingNumbersWithAnswer(lotto.getLottoNumbers());
        int bonusMatchingNumber = getMatchingNumbersWithBonus(lotto.getLottoNumbers());
        return Rank.findRank(answerMatchingNumber, bonusMatchingNumber);
    }

    private int getMatchingNumbersWithBonus(List<Integer> lottoNumbers) {
        if(lottoNumbers.contains(bonusNumber)){
            return 1;
        }

        return 0;
    }

    private int getMatchingNumbersWithAnswer(List<Integer> lottoNumbers){
        return (int) lottoNumbers.stream()
                .filter(lottoAnswer::contains)
                .count();
    }
}
