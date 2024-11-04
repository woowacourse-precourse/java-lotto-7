package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private List<Lotto> myLottos;

    public LottoMachine() {
        this.myLottos = new ArrayList<>();
    }

    public void generateLottos(int purchaseAmount){
        int numLottos = purchaseAmount / LOTTO_PRICE;

        for (int i = 0; i < numLottos; i++) {
            List<Integer> lottoNumbers = generateLottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            myLottos.add(lotto);
        }
    }

    private List<Integer> generateLottoNumbers(){
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT));
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Lotto> getMyLottos(){
        return myLottos;
    }

    public List<Prize> calculateStatistics(List<Lotto> myLottos, List<Integer> winningNumbers, int bonusNumber){
        return myLottos.stream()
                .map(lotto ->{
                    int matchCount = lotto.countMatches(winningNumbers);
                    boolean matchBonus = lotto.contains(bonusNumber);
                    return Prize.valueOf(matchCount, matchBonus);
                })
                .collect(Collectors.toList());
    }

    public double calculateProfitRate(List<Prize> results, int purchaseAmount){
        int totalPrize = results.stream()
                .mapToInt(Prize::getPrize)
                .sum();

        return ((double) totalPrize / purchaseAmount * 100);
    }
}
