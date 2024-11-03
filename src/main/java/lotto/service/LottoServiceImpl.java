package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.*;
import lotto.util.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class LottoServiceImpl implements LottoService {

    private List<Lotto> lottoList = new ArrayList<>();
    private LottoResult lottoResult;

    public LottoServiceImpl() {
        lottoResult = new LottoResult();
    }

    public int toInt(String lottoCost) {
        return Integer.parseInt(lottoCost);
    }

    public int purchaseLottoCount(int lottoCost) {
        int ticketCount = lottoCost / Constants.PURCHASE_FORM;

        return ticketCount;
    }

    public List<Lotto> generateRandomLottoNumbers(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = sortRandomLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private static List<Integer> sortRandomLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }

    public List<String> splitWinningNumbers(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(Constants.SEPARATOR));
    }

    public List<Integer> convertToInt(List<String> trimWinningNumbers) {
        return trimWinningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<String> trimWinningNumbers(List<String> splitWinningNumbers) {
        return splitWinningNumbers.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public LottoWinningNumbers winningLotto(List<Integer> winningNumbers, int bonusNumber) {
        LottoWinningNumbers lottoWinning = new LottoWinningNumbers(winningNumbers, bonusNumber);

        return lottoWinning;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public Map<LottoRank, Integer> getResult() {
        return lottoResult.getResult();
    }

    public void putLottoResult(Map<LottoRank, Integer> lottoResultMap) {
        lottoResult.setResult(lottoResultMap);
    }

    public void putLottoResultMap(LottoRank rankByMatchCount, Map<LottoRank, Integer> lottoResultMap) {
        lottoResultMap.put(rankByMatchCount, lottoResultMap.getOrDefault(rankByMatchCount, 0) + 1);
    }

    public LottoRank compareBonusNumber(LottoRank rankByMatchCount, int bonusNumber) {
        if (rankByMatchCount.getMatchCount() == Constants.BONUS_MATCH_COUNT) {
            if (lottoList.contains(bonusNumber)) {
                return LottoRank.SECOND;
            }
        }
        return rankByMatchCount;
    }

    public int checkWinningNumbers(LottoWinningNumbers lottoWinning, int i) {
        Set<Integer> lottoSet = new HashSet<>(lottoList.get(i).getNumbers());
        Set<Integer> winSet = new HashSet<>(lottoWinning.getLottoWinningNumbers());

        lottoSet.retainAll(winSet);
        int count = lottoSet.size();

        return count;
    }

    public void setLottoRate(double rate) {
        lottoResult.setRate(rate);
    }

    public double calculateRate(int amount, int lottoCost) {
        double rate = ((double) amount / lottoCost) * 100.0;
        rate = Math.round(rate * 100) / 100.0;

        return rate;
    }

    public int sumAmount(Map<LottoRank, Integer> lottoResultMap) {
        int amount = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            int price = lottoRank.getPrice();
            amount += price * lottoResultMap.get(lottoRank);
        }

        return amount;
    }
}
