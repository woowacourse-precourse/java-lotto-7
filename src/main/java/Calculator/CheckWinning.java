package Calculator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import print.InputRequest;

public class CheckWinning {
    InputRequest inputRequest = new InputRequest();

    //로또 당첨을 확인하는 메서드
    public Map<Integer, Integer> checkWinLottoTotal(List<Lotto> myLottos) {
        String userInputWinningNumbers = inputRequest.winningNumbersRequest();
        String userInputBonusNumber = inputRequest.bonusNumberRequest();

        HashSet<Integer> parsedWinningNumbers = strToSet(userInputWinningNumbers);
        int bonusNumber = Integer.parseInt(userInputBonusNumber);

        return check(myLottos, parsedWinningNumbers, bonusNumber);
    }

    // 보너스 번호 없이 확인하는 경우 1 ~ 5등까지 확인
    public Map<Integer, Integer> check(List<Lotto> myLottos, HashSet<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> localResult = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            localResult.put(i, 0);
        }

        for (Lotto myLotto : myLottos) {
            int rank = checkDetail(myLotto.getNumbers(), winningNumbers, bonusNumber);
            localResult.replace(rank, localResult.get(rank) + 1);
        }

        return localResult;
    }

    public int checkDetail(List<Integer> myLotto, HashSet<Integer> winningNumbers, int bonusNumber) {
        int rank = compare(winningNumbers, myLotto);
        if (rank == 2 && !myLotto.contains(bonusNumber)) {
            return 3;
        }
        return rank;
    }

    public int compare(HashSet<Integer> winningNumbers, List<Integer> singleLotto) {
        HashSet<Integer> myLotto = new HashSet<>(singleLotto);

        myLotto.retainAll(winningNumbers);
        return myLotto.size(); // 일치하는 숫자 개수 반환
    }

    private HashSet<Integer> strToSet(String str) {
        String[] winningNumbersArray = str.split(",");

        HashSet<Integer> parsedWinningNumbers = new HashSet<>();
        for (String winningNumber : winningNumbersArray) {
            parsedWinningNumbers.add(Integer.parseInt(winningNumber));
        }

        return parsedWinningNumbers;
    }
}
