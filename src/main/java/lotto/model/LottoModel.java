package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.constant.PrizeTier;
import lotto.utils.NumberList;

public class LottoModel {

    private List<Lotto> lottoRepository;
    private Lotto winLotto;
    private int bonusNumber;

    public LottoModel(){
        this.lottoRepository = new ArrayList<Lotto>();
    }

    public List<Lotto> createLotto(int count){
        List<Lotto> createdLottos = new ArrayList<Lotto>();

        for(int i = 0; i < count; ++i){
            Lotto newLotto = this.createLotto();
            this.lottoRepository.add(newLotto);
            createdLottos.add(newLotto);
        }

        return createdLottos;
    }



    public void setWinLottoWithBonusNumber(List<Integer> winLottoNumbers, int bonusNumber){

        NumberList newNumberList = new NumberList();
        newNumberList.addAll(winLottoNumbers);

        this.winLotto = new Lotto(newNumberList);
        this.bonusNumber = bonusNumber;


    }

    public Lotto getWinLotto(){

        return new Lotto(this.winLotto.getNumbers());
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }

    public Map<PrizeTier,Integer> getWinningInfo(){

        Map<PrizeTier,Integer> winningInfo = this.initWinningInfo();

        for(Lotto lotto : this.lottoRepository){
            PrizeTier result = lotto.checkPrizeTier(this.winLotto,this.bonusNumber);
            int count = winningInfo.get(result);

            winningInfo.replace(result,++count);
        }

        return winningInfo;
    }

    public double calculateRateOfReturn(int LottoPrice ) {
        long lottoCount = lottoRepository.size();
        long totalExpense = lottoCount* LottoPrice;
        long totalReturn = 0;
        int rate = 100;

        Map<PrizeTier,Integer> winningInfo = this.getWinningInfo();

        PrizeTier[] winningPrizes = PrizeTier.getWinningPrizeTierValues();

        for(PrizeTier prize : winningPrizes){
            int prizeCount = winningInfo.get(prize);
            totalReturn +=  prizeCount * (long) prize.getPrizeMoney();
        }

        return totalReturn/(double) totalExpense * rate;
    }

    private Lotto createLotto(){
        NumberList numberList = new NumberList();
        numberList.generateRandomNumberList();

        Lotto newLotto = new Lotto(numberList);

        return newLotto;
    }


    private Map<PrizeTier,Integer> initWinningInfo(){
        Map<PrizeTier,Integer> prizeTierMap = new EnumMap<>(PrizeTier.class);

        for(PrizeTier prizeTier : PrizeTier.values()){
            int count = 0;
            prizeTierMap.put(prizeTier,count);
        }

        return prizeTierMap;
    }

}
