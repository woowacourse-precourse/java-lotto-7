package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import lotto.EnumManagement.ExceptionEnum;
import lotto.EnumManagement.LottoEnum;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers.sort(Integer::compareTo); // 오름차순 정렬
        this.numbers = numbers;
    }

    public void start(OutputView outputView, InputView inputView) {
        List<Integer> lottoMatchTable = lottoNumberCheck(outputView.getBoughtLottoNumbers(), inputView.getBonusNumber());
        outputView.lottoWinOutput(lottoMatchTable);
        double lottoReturnRate = calLottoReturnRate(lottoMatchTable, inputView.getLottoPurchase());
        outputView.lottoReturnRateOutput(lottoReturnRate);
    }

    public List<Integer> makeWinLottoPrice(List<Integer> lottoWinPrice) {
        int size = 0;
        for (LottoEnum lottoPrice : LottoEnum.values()) {
            if (size < LottoEnum.LOTTO_WINNING_SIZE.getNumber())
                lottoWinPrice.add(lottoPrice.getNumber());
            ++size;
        }
        return lottoWinPrice;
    }

    public double calLottoReturnRate(List<Integer> lottoMatchTable, int lottoPurchase) {
        int totalLottoWinPrice = 0;
        List<Integer> lottoWinPrice = new ArrayList<>();
        lottoWinPrice = makeWinLottoPrice(lottoWinPrice);
        for (int i = 0; i < lottoMatchTable.size(); i++) {
            totalLottoWinPrice += lottoMatchTable.get(i) * lottoWinPrice.get(i);
        }
        return (double) (totalLottoWinPrice - lottoPurchase) / lottoPurchase * LottoEnum.DIVIDE_100.getNumber();
    }

    public List<Integer> pushNumberTable(List<Integer> equalNumberTable, int equalNumberCount, boolean bonusNumber) {
        int[] countToIndex = {0, 0, 0, 0, 1, 2, 4};

        if (equalNumberCount == LottoEnum.EQUAL_LOTTO_NUMBER_5.getNumber() && bonusNumber) {
            equalNumberTable.set(LottoEnum.NUMBER_TABLE_INDEX_3.getNumber(), equalNumberTable.get(LottoEnum.NUMBER_TABLE_INDEX_3.getNumber()) + LottoEnum.LOTTO_WINNING.getNumber());
            return equalNumberTable;
        }

        for(int i = LottoEnum.NUMBER_TABLE_INDEX_3.getNumber(); i <= LottoEnum.NUMBER_TABLE_INDEX_6.getNumber() ; i++){
            if(equalNumberCount == i){
                equalNumberTable.set(countToIndex[i], equalNumberTable.get(countToIndex[i]) + LottoEnum.LOTTO_WINNING.getNumber());
                break;
            }
        }

        return equalNumberTable;
    }

    public List<Integer> lottoNumberCheck(List<List<Integer>> boughtLottoNumbers, int bonusNumber) {
        List<Integer> equalNumberTable = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (List<Integer> boughtLottoNumber : boughtLottoNumbers) {
            int equalNumberCount = 0;
            boolean equalBonusNumber = false;
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.contains(boughtLottoNumber.get(i))) {
                    equalNumberCount++;
                }
                if (boughtLottoNumber.get(i).equals(bonusNumber)) {
                    equalBonusNumber = true;
                }
            }
            if (3 <= equalNumberCount)
                equalNumberTable = pushNumberTable(equalNumberTable, equalNumberCount, equalBonusNumber);
        }
        return equalNumberTable;
    }
}


