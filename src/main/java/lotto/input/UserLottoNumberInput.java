package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class UserLottoNumberInput {
    private String lottoNumberInput;
    private List<Integer> lottoNumbers;

    public void userLottoNumberInput() {
        while (true) {
            try {
                userInput();
                validation(); // 1차 Input 검증
                break;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 입력이 잘못되었습니다. 당첨 번호는 숫자여야 합니다");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Lotto saveLottoNumber() {
        return new Lotto(lottoNumbers); // Lotto에서 2차 Input 검증 및 로또 번호 저장
    }

    private void userInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        lottoNumberInput = Console.readLine();
    }

    private void validation() {
        List<String> userLottoNumbers = new ArrayList<>(Arrays.asList(lottoNumberInput.trim().split("\\s*,\\s*")));
        lottoNumbers = new ArrayList<>();

        for (String userNumber : userLottoNumbers) {
            lottoNumbers.add(Integer.parseInt(userNumber));
        }
    }
}
