package lotto.controller;

import lotto.model.*;
import lotto.utils;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {
    private static final List<Lotto> lottos = new ArrayList<>();
    private static final RandomLotto randomLotto = new RandomLotto();
    private static List<Integer> numbers;

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        // Amount 설정
        int amount = inputAmount();
        OutputView.printAmount(amount);

        // 갯수만큼의 랜덤 복권 생성
        setLottoNumbers(amount);
        OutputView.printLottoNumbers(lottos);

        // WinningNumbers 입력
        Lotto winningNumbers = inputWinningNum();

        // BonusNumber 입력
        int bonusNumber = inputBonusNumber();

        // LottoGame 시작
        gameStart(lottos, winningNumbers, bonusNumber);
    }

    private int inputAmount() {
        try {
            LottoAmount lottoAmount = new LottoAmount(InputView.inputAmount());
            return lottoAmount.getAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputAmount();
        }
    }

    private void setLottoNumbers(int amount) {
        for (int i = 0; i < amount; i++) {
            numbers = randomLotto.setRandNumbers();
            lottos.add(new Lotto(numbers));
        }
    }
    private Lotto inputWinningNum(){
        try {
            String str = InputView.inputWinningNum();
            numbers = utils.StringToList(str);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputWinningNum();
        }
    }

    private int inputBonusNumber(){
        try {
            BonusNumber bonusNumber = new BonusNumber(InputView.inputBonusNum());
            return bonusNumber.getNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private static void gameStart(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> result = setResult();
        int sum = 0;
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto, winningNumbers);
            boolean isBonusMatched = isBonusMatched(lotto, bonusNumber);
            LottoRank rank = LottoRank.getRank(matchCount, isBonusMatched);
            result.put(rank, result.get(rank)+1);
        }
        OutputView.printResults(result);
        OutputView.printRevenue(sum, lottos.size()*1000);
    }

    private static int getMatchCount(Lotto lotto, Lotto winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    private static boolean isBonusMatched(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private static Map<LottoRank, Integer> setResult(){
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for(LottoRank rank : LottoRank.values()){
            result.put(rank, 0);
        }
        return result;
    }
}