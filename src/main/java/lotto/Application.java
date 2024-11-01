package lotto;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        MakeLottoNumbers makeLottoNumbers = new MakeLottoNumbers();

        System.out.println("구입 금액을 입력해주세요.");
        makeLottoNumbers.makeLottoNumber();
    }
}
