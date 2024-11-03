package lotto.Service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.UserNumber;
import lotto.model.UserNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private UserNumbers userNumbers;
    private Lotto lotto;
    private BonusNumber bonusNumber;
    private List<Integer> results;


    public void generateUserNumbers(int purchaseAmount) {
        userNumbers = new UserNumbers(purchaseAmount);
    }

    public List<UserNumber> getUserNumbers() {
        return userNumbers.getUserNumbers();
    }

    public void generateLotto(String inputValue) {
        String[] lottoNumber = inputValue.split(",");
        List<Integer> lottoNumberList = Arrays.stream(lottoNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        lotto = new Lotto(lottoNumberList);
    }

    public void generateBonusNumber(int number) {
        bonusNumber = new BonusNumber(number, lotto);
    }

    public List<Integer> calculateResult() {
        results = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

        for (UserNumber userNumber : userNumbers.getUserNumbers()) { //이 로직은 UserNumbers에서 실행되는 것보다 여기가 좋겠지?
            long matchingCount = userNumber.getUserNumber().stream()
                    .filter(lotto.getNumbers()::contains)
                    .count();
            
        }
        return results;
    }
}
