package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.validator.InputValidator;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private List<Lotto> lottoList = new ArrayList<>();
    private InputValidator inputValidator;
    private LottoWinningNumbers lottoWinning;

    public LottoService() {
        inputValidator = new InputValidator();
    }

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

    public LottoResult resultWinningLotto(int lottoNum) {
        Map<LottoRank, Integer> lottoResults = new HashMap<>();
        LottoResult lottoResult = new LottoResult(lottoResults, 0);
        lottoResult.init();

        for(int i=0; i<lottoNum; i++){
            int count = compareWinningLotto(i);
            //System.out.println("count = " + count);
            LottoRank rankByMatchCount = LottoRank.getRankByMatchCount(count);
            //System.out.println("rankByMatchCount = " + rankByMatchCount);;
            // lottoRank를 가지고 있는 (키) list를 찾아서 value를 count를 한다
            if(rankByMatchCount != null){
                lottoResults.put(rankByMatchCount, lottoResults.getOrDefault(rankByMatchCount, 0) + 1);
            }
        }

        return lottoResult;
    }

    private int compareWinningLotto(int i) {
        Set<Integer> set1 = new HashSet<>(lottoList.get(i).getNumbers());
        Set<Integer> set2 = new HashSet<>(lottoWinning.getLottoWinningNumbers());

        set1.retainAll(set2);
        int count = set1.size(); // 중복

        return count;
    }

    public LottoResult calculateRate(LottoResult result, int lottoPriceInt) {
        int amount = sumAmount(result.getLottoResult());
        double rate = (amount / lottoPriceInt) * 100.0;
        rate = Math.round(rate * 100) / 100.0;

        result.setRate(rate);

        return result;
    }

    private int sumAmount(Map<LottoRank, Integer> lottoResults) {
        int amount = 0;
        for(LottoRank lottoRank: lottoResults.keySet()){
            int price = convertToInt(lottoRank.getPrice());
            amount += price * lottoResults.get(lottoRank);
        }

        return amount;
    }

    public static int convertToInt(String str) {
        // 쉼표를 모두 제거하고 int로 변환
        String noCommaStr = str.replace(",", "");
        return Integer.parseInt(noCommaStr);
    }

    public void winningLotto(List<Integer> winningNumbers, int bonusNumber) {
        lottoWinning = new LottoWinningNumbers(winningNumbers, bonusNumber);
    }
}
