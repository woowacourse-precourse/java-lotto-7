package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.WinningResult;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.Exception;

public class LottoController {

    private static List<Lotto> lottoList;
    private static int lottoPrice;
    private static int lottoCount;
    private static WinningResult winningResult;
    private static List<Integer> lotto = new ArrayList<>();
    private static final int PERCENTAGE = 100;

    public void start(){
        lottoPrice = inputPriceWithValidation();
        lottoCount = makeLottoCount(lottoPrice);
        OutputView.printLottoCount(lottoCount);
        lottoList = makeLottoList(lottoCount);

        List<Integer> winningNumbers = new InputView().winningNumbers();
        int bonusNumber = new InputView().bonusNumber();
        winningResult = new WinningResult(new Lotto(winningNumbers), bonusNumber);

        lottoResult(lottoList, winningResult, lottoCount);
    }

    private int inputPriceWithValidation() {
        String input = InputView.inputPrice();
        int price = validateNumber(input);
        validateAmount(price);
        return price;
    }

    private static int validateNumber(String amount){
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            Exception.numberException();
            throw new IllegalArgumentException();
        }
    }

    private void validateAmount(int amount) {
        validateNatural(amount);
        validateDivisible(amount);
    }

    private void validateNatural(int amount) {
        if (amount <= 0) {
            Exception.naturalException();
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisible(int amount) {
        if (amount % 1000 != 0) {
            Exception.divisibleException();
            throw new IllegalArgumentException();
        }
    }

    public static List<Lotto> makeLottoList(int lottoCount){
        lottoList = new ArrayList<>();
        for(int i=0;i<lottoCount;i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    public static int makeLottoCount(int lottoPrice){
        return lottoPrice /1000;
    }

    public static Lotto makeLotto(){
        lotto = new ArrayList<>();
        lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private void lottoResult(List<Lotto> lottoList, WinningResult winningLotto, int amount) {
        Map<LottoRanking, Integer> result = setResult();
        LottoRanking rank;

        OutputView.printSuccessResult();
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private void printResult(Map<LottoRanking, Integer> result) {
        for (int i = LottoRanking.values().length - 1; i >= 0; i--) {
            LottoRanking.values()[i].printMessage(result.get(LottoRanking.values()[i]));
        }
    }

    private void printEarningRate(Map<LottoRanking, Integer> result, int lottoAmount) {
        double earningRate = 0;
        for (LottoRanking rank : result.keySet()) {
            earningRate =
                    earningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * 1000) * (result.get(
                            rank)) * (PERCENTAGE));

        }
        OutputView.printRevenueRate(earningRate);
    }


    private Map<LottoRanking, Integer> setResult() {
        Map<LottoRanking, Integer> result = new LinkedHashMap<>();

        for (LottoRanking rank : LottoRanking.values()) {
            result.put(rank, 0);
        }
        return result;
    }


}
