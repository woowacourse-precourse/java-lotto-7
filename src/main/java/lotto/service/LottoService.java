package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.validator.InputValidator;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private List<Lotto> lottoList;
    private Map<LottoRank, Integer> lottoResults;
    private InputValidator inputValidator;
    private LottoWinningNumbers lottoWinning;
    private int lottoNum;

    private int lottoPriceInt;

    public LottoService() {
        inputValidator = new InputValidator();
    }

    public int purchaseLotto(int lottoPrice) {
        lottoNum = lottoPrice / Constants.PURCHASE_FORM;

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
        lottoPriceInt = inputValidator.validateNumber(lottoPrice);
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
        lottoTrim(lottoArray); // 함수 이름 바꾸기

        List<String> lottoWinningNumbersList = Arrays.asList(lottoArray);
        List<Integer> lottoWinningNumbersIntList = lottoWinningNumbersList.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return lottoWinningNumbersIntList;
    }

    private void lottoTrim(String[] lottoArray) {
        for (int i = 0; i < lottoArray.length; i++) {
            lottoArray[i] = lottoArray[i].trim();
        }
    }

    public void winningLotto(String lottoWinningNumbers, String lottoBonusNumber) {
        List<Integer> winNumbers = splitLottoWinningNumbers(lottoWinningNumbers);
        int bonusNumber = Integer.parseInt(lottoBonusNumber); // 따로 빼기
        LottoWinningNumbers lottoWinning = new LottoWinningNumbers(winNumbers, bonusNumber);
    }

    public Map<LottoRank, Integer> resultWinningLotto() {
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
        int count = set1.size();

        return count;
    }

    public double resultRate() {
        // 일치한 것에 대한 돈을 다 더한다
        // 해당 돈 / 구입 금액 * 100
        // 소수점 둘째자리까지 표현한다
        int amount = 0;
        for(LottoRank lottoRank: lottoResults.keySet()){
            amount += convertToInt(lottoRank.getPrice()) * lottoResults.get(lottoRank);
        }

        double rate = (amount / lottoPriceInt) * 100.0;
        rate = Math.round(rate * 100) / 100.0;

        return rate;
    }

    public static int convertToInt(String str) {
        // 쉼표를 모두 제거하고 int로 변환
        String noCommaStr = str.replace(",", "");
        return Integer.parseInt(noCommaStr);
    }
}
