package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    int inputMoney;
    int count;

    Set<Integer> winnigNumbers = new HashSet<>();
    Set<Integer> bonusNumber = new HashSet<>();
    ArrayList<Lotto> lottoNumbers = new ArrayList<>();
    Map<Ranking, Integer> prizeResult = new LinkedHashMap<>();

    public LottoMachine(int inputMoney) {

        this.inputMoney = inputMoney;

        this.count = this.inputMoney / 1000;

    }

    public void makeLottos() {

        for (int i = 0; i < this.count; i++) {

            this.lottoNumbers.add(new Lotto(Randoms.

                    pickUniqueNumbersInRange(1, 45, 6)));
        }

    }

    public void printLottos() {
        System.out.println(String.format("%d개를 구매했습니다.", this.count));
        for (int i = 0; i < this.count; i++) {
            System.out.println(lottoNumbers.get(i).getNumbers());
        }
    }

    public void inputWinnigNumbers(String winnigNumbers) {

        int[] intNumbers = covertToInt(winnigNumbers.split(","));
        for (int i = 0; i < intNumbers.length; i++) {
            this.winnigNumbers.add(intNumbers[i]);
        }

    }

    public void inputBonusNumbers(String bonusNumber) {

        this.bonusNumber.add(Integer.parseInt(bonusNumber));

    }


    private int[] covertToInt(String[] strArr) {
        int[] convertedArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            convertedArr[i] = Integer.parseInt(strArr[i]);
        }
        return convertedArr;
    }

    public Ranking getRanking(List<Integer> lottoNumbers) {
        int matchCount = 0;
        boolean isBonus = false;
        for (int number : lottoNumbers) {
            if (winnigNumbers.contains(number)) {
                matchCount++;
            } else if (bonusNumber.contains(number)) {
                matchCount++;
                isBonus = true;
            }
        }
        if(matchCount<3){
            return Ranking.NOLUCK;
        }
        if (matchCount == 3) {
            return Ranking.FIFTH;
        }
        if (matchCount == 4) {
            return Ranking.FOURTH;
        }
        if (matchCount == 5) {
            return Ranking.THIRD;
        }
        if (matchCount == 6 && isBonus == true) {
            return Ranking.SECOND;
        }
        if (matchCount == 6 && isBonus == false) {
            return Ranking.FIRST;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    public void initPrizeMap() {
        for (Ranking ranking : Ranking.values()) {
            prizeResult.put(ranking, 0);
        }
    }

    public void makePrizeMap() {
        for (Lotto lotto : lottoNumbers) {
            Ranking ranking = getRanking(lotto.getNumbers());
            prizeResult.put(ranking, prizeResult.get(ranking) + 1);
        }
    }

    public void printPrize() {
        for (Map.Entry<Ranking, Integer> entry : prizeResult.entrySet()) {
            System.out.println(String.format("%d개 일치 (%d원) - %d개"
                    , entry.getKey().getMatchCount(), entry.getKey().getPrice()
                    , entry.getValue()));
        }
    }


}
