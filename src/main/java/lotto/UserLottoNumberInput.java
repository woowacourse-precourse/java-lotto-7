package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserLottoNumberInput {
    private String lottoNumberInput;
    private List<String> userLottoNumbers;
    private List<Integer> lottoNumbers;

    public void userLottoNumberInput() {
        while (true) {
            try {
                userInput();
                validation();
                Lotto lotto = new Lotto(lottoNumbers);
                break;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다. 당첨 번호는 숫자여야 합니다");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void userInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        lottoNumberInput = Console.readLine();
    }

    private void validation() {
        userLottoNumbers = new ArrayList<>(Arrays.asList(lottoNumberInput.trim().split("\\s*,\\s*")));
        lottoNumbers = new ArrayList<>();

        for (String userNumber : userLottoNumbers) {
            lottoNumbers.add(Integer.parseInt(userNumber));
        }
    }
}
