package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private List<Lotto> lottoList = new ArrayList<>();

    public int purchaseLotto(int lottoPrice) {
        int lottoNum = lottoPrice / Constants.PURCHASE_FORM;

        return lottoNum;
    }

    public List<Lotto> randomLottoNum(int lottoNum) {
        for(int i=0; i<lottoNum; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public List<Integer> splitLottoWinningNumbers(String lottoWinningNumbers) {
        String[] lottoArray = lottoWinningNumbers.split(Constants.SEPARATOR);
        trimLottoWinningNumbers(lottoArray);
        List<Integer> lottoWinningNumbersIntList = convertLottoWinningNumbers(lottoArray);

        return lottoWinningNumbersIntList;
    }

    private List<Integer> convertLottoWinningNumbers(String[] lottoArray) {
        List<String> lottoWinningNumbersList = Arrays.asList(lottoArray);
        List<Integer> lottoWinningNumbersIntList = lottoWinningNumbersList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return lottoWinningNumbersIntList;
    }

    private void trimLottoWinningNumbers(String[] lottoArray) {
        for (int i = 0; i < lottoArray.length; i++) {
            lottoArray[i] = lottoArray[i].trim();
        }
    }

    public LottoWinningNumbers winningLotto(List<Integer> winningNumbers, int bonusNumber) {
        LottoWinningNumbers lottoWinning = new LottoWinningNumbers(winningNumbers, bonusNumber);

        return lottoWinning;
    }

    public LottoResult resultWinningLotto(LottoWinningNumbers lottoWinning, int lottoNum) {
        Map<LottoRank, Integer> lottoResults = new HashMap<>();
        LottoResult lottoResult = new LottoResult(lottoResults, 0);
        lottoResult.init();
        int bonusNumber = lottoWinning.getBonusNumber();

        for(int i=0; i<lottoNum; i++){
            int count = compareWinningLotto(i, lottoWinning);
            LottoRank rankByMatchCount = LottoRank.getRankByMatchCount(count);
            
            if(rankByMatchCount != null){
                rankByMatchCount = compareBonusNumber(rankByMatchCount, bonusNumber);
                lottoResults.put(rankByMatchCount, lottoResults.getOrDefault(rankByMatchCount, 0) + 1);
            }
        }

        return lottoResult;
    }

    private LottoRank compareBonusNumber(LottoRank rankByMatchCount, int bonusNumber) {
        if(rankByMatchCount.getMatchCount() == Constants.BONUS_MATCH_COUNT){
            if(lottoList.contains(bonusNumber)){
                return LottoRank.SECOND;
            }
        }
        return rankByMatchCount;
    }

    private int compareWinningLotto(int i, LottoWinningNumbers lottoWinning) {
        Set<Integer> lottoSet = new HashSet<>(lottoList.get(i).getNumbers());
        Set<Integer> winSet = new HashSet<>(lottoWinning.getLottoWinningNumbers());

        lottoSet.retainAll(winSet);
        int count = lottoSet.size(); // 중복

        return count;
    }

    public LottoResult calculateRate(LottoResult result, int lottoPriceInt) {
        int amount = sumAmount(result.getLottoResult());
        double rate = ((double) amount / lottoPriceInt) * 100.0;
        rate = Math.round(rate * 100) / 100.0;
        result.setRate(rate);

        return result;
    }

    private int sumAmount(Map<LottoRank, Integer> lottoResults) {
        int amount = 0;
        for(LottoRank lottoRank : LottoRank.values()){
            int price = lottoRank.getPrice();
            amount += price * lottoResults.get(lottoRank);
        }

        return amount;
    }
}
