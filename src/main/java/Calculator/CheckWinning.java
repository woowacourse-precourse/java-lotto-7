package Calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import print.InputRequest;

public class CheckWinning {
    InputRequest inputRequest = new InputRequest();
    Set<Integer> winningNumbers = new HashSet<>();

    //로또 당첨을 확인하는 메서드
    public List<Integer> checkWinLottoTotal(List<List<Integer>> myLottos) {
        String userInputWinningNumbers = inputRequest.winningNumbersRequest();
        String userInputBonusNumber = inputRequest.bonusNumberRequest();

        HashSet<Integer> winningNumbers = strToSet(userInputWinningNumbers);
        int bonusNumber = Integer.parseInt(userInputBonusNumber);

        List<Integer> result = check(myLottos, winningNumbers, bonusNumber);

        return result;
    }

    //보너스 번호 없이 확인하는 경우 1 ~ 5등까지 확인
    //단 2등의 경우 보너스 확인까지 필요.
    public List<Integer> check(List<List<Integer>> myLottos, HashSet<Integer> winningNumbers, int bonusNumber) {
        List<Integer> localResult = new ArrayList<>(7);
        for (List<Integer> myLotto : myLottos) {
            int rank = checkDetail(myLotto, winningNumbers, bonusNumber);
            localResult.add(rank, localResult.get(rank) + 1);
        }
        return localResult;
    }

    public int checkDetail(List<Integer> myLotto, HashSet<Integer> winningNumbers, int bonusNumber) {
        int rank = compare(winningNumbers, myLotto);
        if (rank == 2) {
            if (!myLotto.contains(bonusNumber)) {
                return 3;
            }
        }
        return rank;
    }

    public int compare(HashSet<Integer> winningNumbers, List<Integer> singleLotto) {
        HashSet<Integer> myLotto = new HashSet<>(singleLotto);

        winningNumbers.removeAll(myLotto);

        return winningNumbers.size() + 1;
    }

    private HashSet<Integer> strToSet(String str) {
        String[] winningNumbersArray = str.split(",");

        HashSet<Integer> winningNumbers = new HashSet<>();
        for (String winningNumber : winningNumbersArray) {
            winningNumbers.add(Integer.parseInt(winningNumber));
        }

        return winningNumbers;
    }
}
