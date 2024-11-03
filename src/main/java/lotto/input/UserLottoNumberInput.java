package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;


public class UserLottoNumberInput {

    public Lotto validation() {
        while (true) {
            try {
                List<Integer> lottoNumbers = parsingLottoNumbers((createLottoNumberArray(getInput())));
                Lotto lotto = new Lotto(lottoNumbers);
                System.out.println();
                return lotto;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 당첨 번호는 쉼표(,)로 구분된 6개의 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String getInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    private List<String> createLottoNumberArray(String input) {
        return new ArrayList<>(Arrays.asList(input.trim().split("\\s*,\\s*")));
    }

    private List<Integer> parsingLottoNumbers(List<String> userLottoNumbers) {

        List<Integer> lottoNumbers = new ArrayList<>();

        for (String userNumber : userLottoNumbers) {
            lottoNumbers.add(Integer.parseInt(userNumber));
        }

        return lottoNumbers;
    }
}
