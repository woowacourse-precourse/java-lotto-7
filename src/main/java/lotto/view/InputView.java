package lotto.view;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(readLine());
    }
    // TODO: 당첨 번호 입력받기
    // TODO: 보너스 번호 입력받기
}


