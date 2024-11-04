package Calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;
import print.InputRequest;

public class CheckWinning {
    InputRequest inputRequest = new InputRequest();
    Set<Integer> winningNumbers = new HashSet<>();

    //로또 당첨을 확인하는 메서드
    public List<Integer> checkWinLottoTotal(List<Lotto> myLottos) {
        String userInputWinningNumbers = inputRequest.winningNumbersRequest();
        String userInputBonusNumber = inputRequest.bonusNumberRequest();

        HashSet<Integer> parsedWinningNumbers = strToSet(userInputWinningNumbers);
        int bonusNumber = Integer.parseInt(userInputBonusNumber);

        return check(myLottos, parsedWinningNumbers, bonusNumber);
    }

    // 보너스 번호 없이 확인하는 경우 1 ~ 5등까지 확인
    public List<Integer> check(List<Lotto> myLottos, HashSet<Integer> winningNumbers, int bonusNumber) {
        List<Integer> localResult = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            localResult.add(0);
        }

        for (Lotto myLotto : myLottos) {
            int rank = checkDetail(myLotto.getNumbers(), winningNumbers, bonusNumber);
            localResult.set(rank, localResult.get(rank) + 1);
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
        myLotto.retainAll(winningNumbers); // 교집합 구하기
        return 7 - myLotto.size(); // 일치하는 숫자에 따라 순위 반환
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
