package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.view.InputLottoView;
import lotto.view.OutputLottoView;

import java.util.*;

public class LottoService {
    private InputLottoView inputLottoView;
    private OutputLottoView outputLottoView;

    public LottoService(OutputLottoView outputLottoView, InputLottoView inputLottoView) {
        this.inputLottoView = inputLottoView;
        this.outputLottoView = outputLottoView;
    }


    //로또 발행
    public Set<Lotto> createLottoList(int publishNum) {
        Set<Lotto>lottoList = new HashSet<>();
        for (int i = 0; i < publishNum; i++) {
            lottoList.add(new Lotto());
        }
        outputLottoView.printLottoNumber(lottoList);
        return lottoList;
    }


    //당첨 번호+보너스 번호 입력
    public LottoResult getLottoResult() {
        List<Integer> lottoWinList=inputLottoView.printLottoMainNumber();
        int bonusNumber= inputLottoView.printBonusNumber();

        return new LottoResult(lottoWinList,bonusNumber);
    }

    //matchCount 계산
    public void calcMatchCount(Set<Lotto> lottoSet, LottoResult lottoResult) {

        for (Lotto lotto : lottoSet) {
            LottoRank rank=lottoResult.campareLotto(lotto);
            if(rank!=null) {
                rank.incrementCount();
            }
        }
    }

    public double calcEarningsRate(int lottoPurchasePrice) {
        int earningAmount=0;
        for (LottoRank rank:LottoRank.values()){
            earningAmount+= rank.getPrize() * rank.getCount();
        }
        return (double)earningAmount/lottoPurchasePrice * 100;

    }


}
