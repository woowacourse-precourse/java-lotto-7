package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBERS = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final int lottoSetCount;
    private Map<String, Integer> matchResults;
    private final int lottoMoney;
    List<List<Integer>> lottoSets = new ArrayList<>();

    public LottoController(int lottoMoney){
        this.lottoMoney = lottoMoney;
        this.lottoSetCount = calculateLottoSetCount();
        initializeMatchResults();
    }
    public void startLotto() {
        generateRandomLottoNumbers();
        generateLottoSet();
        compareWinningNumbers(lottoSets);
        printMatchResult(matchResults);

    }

    private void initializeMatchResults() {
        matchResults = new HashMap<>();
        matchResults.put("3", 0);
        matchResults.put("4", 0);
        matchResults.put("5", 0);
        matchResults.put("5+Bonus", 0);
        matchResults.put("6", 0);
    }


    public List<Integer> generateRandomLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBERS, LOTTO_NUMBER_COUNT);
    }

    public void generateLottoSet(){
        printLottoSetCount(lottoSetCount);

        for (int i=0; i<lottoSetCount; i++){
            List<Integer> lottoNumber = generateRandomLottoNumbers();
            Collections.sort(lottoNumber);
            printLottoNumbers(lottoNumber);
            lottoSets.add(lottoNumber);
        }

    }

    public void compareWinningNumbers(List<List<Integer>> lottoSets) {
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();
        Lotto lotto = new Lotto(winningNumbers);

        for (List<Integer> lottoNumber : lottoSets) {
            int matchCount = lotto.countMatchingNumbers(lottoNumber);
            boolean bonusMatch = lotto.containsBonusNumber(bonusNumber ,lottoNumber);

            updateMatchResults(matchCount, bonusMatch);
        }
    }

    public void updateMatchResults(int matchCount, boolean bonusMatch) {
        if (matchCount == 5 && bonusMatch) {
            matchResults.put("5+Bonus", matchResults.get("5+Bonus") + 1);
        } else if (matchCount >= 3) {
            matchResults.put(matchCount + "", matchResults.get(matchCount + "") + 1);
        }
    }

    public int calculateLottoSetCount(){
        return lottoMoney / 1000;
    }

    public void printLottoSetCount(int lottoSetCount) {
        ResultView.printLottoSetCount(lottoSetCount);
    }

    public void printLottoNumbers(List<Integer> lottoNumber){
        ResultView.printLottoNumbers(lottoNumber);
    }

    public void printMatchResult(Map<String, Integer> matchResults){
        ResultView.printMatchResult(matchResults);
    }

}