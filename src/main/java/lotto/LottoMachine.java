package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
    final int winnigNumberCount = 6;
    int inputprizeResult;
    int count;

    Set<Integer> winnigNumbers = new HashSet<>();
    Set<Integer> bonusNumber = new HashSet<>();
    ArrayList<Lotto> lottoNumbers = new ArrayList<>();
    Map<Ranking, Integer> prizeResult = new LinkedHashMap<>();

    public LottoMachine(int inputprizeResult) {
        this.inputprizeResult = inputprizeResult;
        this.count = this.inputprizeResult / 1000;
    }

    private boolean isDigit(String input) {
        char tmp;
        for (int i = 0; i < input.length(); i++) {
            tmp = input.charAt(i);
            if (!Character.isDigit(tmp)) {
                return false;
            }
        }
        return true;
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
            List<Integer> sortedNumber = lottoNumbers.get(i).getNumbers();
            Collections.sort(sortedNumber);
            System.out.println(sortedNumber);
        }
    }

    public void inputWinnigNumbers(String winnigNumbers) {

        int[] intNumbers = validateWinnigNumber(winnigNumbers);
        for (int i = 0; i < intNumbers.length; i++) {
            this.winnigNumbers.add(intNumbers[i]);
        }

    }

    public void inputBonusNumbers(String bonusNumber) {

        this.bonusNumber.add(Integer.parseInt(bonusNumber));

    }


    private int[] validateWinnigNumber(String winnigNumbers) {

        String[] splitedWinningNumber = winnigNumbers.split(",");
        if (splitedWinningNumber.length != winnigNumberCount) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요");
        }
        int[] convertedArr = new int[splitedWinningNumber.length];

        for (int i = 0; i < splitedWinningNumber.length; i++) {
            try {
                convertedArr[i] = Integer.parseInt(splitedWinningNumber[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자로 당첨번호를 입력하시오");
            }
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
        if (matchCount < 3) {
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
            if (entry.getKey().equals(Ranking.SECOND)) {
                System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"
                        , entry.getKey().getMatchCount(), entry.getKey().getPrice()
                        , entry.getValue()));
                continue;
            }
            System.out.println(String.format("%d개 일치 (%,d원) - %d개"
                    , entry.getKey().getMatchCount(), entry.getKey().getPrice()
                    , entry.getValue()));
        }
    }

    public void printProfit() {
        double sum = 0;
        double profit = 0;
        for (Map.Entry<Ranking, Integer> entry : prizeResult.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        profit = sum / inputprizeResult * 100;
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profit));
    }


}
