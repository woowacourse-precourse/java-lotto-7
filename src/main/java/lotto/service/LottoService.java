package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.validator.InputValidator;

import java.util.*;
import java.util.stream.Collectors;

public class LottoService {

    private List<Lotto> lottoList;
    private InputValidator inputValidator;
    private LottoWinningNumbers lottoWinning;
    private int lottoNum;

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
        LottoResult lottoResult = new LottoResult();
        for(int i=0; i<lottoNum; i++){
            int count = compareWinningLotto();
            lottoResult.getRankByMatchCount(count);
        }
    }

    private int compareWinningLotto() {
        Set<Integer> set1 = new HashSet<>(lottoList.get(i));
        Set<Integer> set2 = new HashSet<>(lottoWinning.getLottoWinningNumbers());

        set1.retainAll(set2);
        int count = set1.size();

        return count;
    }
}
