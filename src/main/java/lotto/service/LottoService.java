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

    public int validateLottoPrice(String lottoPrice) {
        inputValidator.validateEmpty(lottoPrice);
        int lottoPriceInt = inputValidator.validateNumber(lottoPrice);
        inputValidator.validatePriceForm(lottoPriceInt);

        return lottoPriceInt;
    }

    public void validateWinningNumbers(String lottoWinningNumbers) {
        inputValidator.validateEmpty(lottoWinningNumbers);
        inputValidator.validateNumbersForm(lottoWinningNumbers);
    }

    public void validateBonusNumbers(String lottoBonusNumber) {
        inputValidator.validateEmpty(lottoBonusNumber);
        inputValidator.validateNumber(lottoBonusNumber);
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
    
    

    public Map<LottoRank, Integer> resultWinningLotto(int lottoNum) {
        Map<LottoRank, Integer> lottoResults = new HashMap<>();
        for(int i=0; i<lottoNum; i++){
            int count = compareWinningLotto(i);
            LottoRank rankByMatchCount = LottoRank.getRankByMatchCount(count);
            // lottoRank를 가지고 있는 (키) list를 찾아서 count를 한다
            lottoResults.put(rankByMatchCount, lottoResults.getOrDefault(rankByMatchCount, 0) + 1);
        }

        return lottoResults;
    }

    private int compareWinningLotto(int i) {
        Set<Integer> set1 = new HashSet<>(lottoList.get(i).getNumbers());
        Set<Integer> set2 = new HashSet<>(lottoWinning.getLottoWinningNumbers());

        set1.retainAll(set2);
        int count = set1.size(); // 중복

        return count;
    }

    public double calculateRate(Map<LottoRank, Integer> lottoResult, int lottoPriceInt) {
        // 일치한 것에 대한 돈을 다 더한다
        // 해당 돈 / 구입 금액 * 100
        // 소수점 둘째자리까지 표현한다
        int amount = sumAmount(lottoResult);
        double rate = (amount / lottoPriceInt) * 100.0;
        rate = Math.round(rate * 100) / 100.0;

        return rate;
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

    public int convertBonusNumberInt(String lottoBonusNumber) {
        return Integer.parseInt(lottoBonusNumber);
    }

    public void winningLotto(List<Integer> winningNumbers, int bonusNumber) {
        lottoWinning = new LottoWinningNumbers(winningNumbers, bonusNumber);
    }
}
