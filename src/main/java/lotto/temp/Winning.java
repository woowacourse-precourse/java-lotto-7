package lotto.temp;

import lotto.util.CommonIo;

import java.util.Arrays;
import java.util.List;

public class Winning {

    private final CommonIo io;

    public Winning(CommonIo io) {
        this.io = io;
    }

    public void printRequestWinningNumbers(){
        io.printMessage("당첨 번호를 입력해 주세요.");
    }

    public String inputWinningNumbers() {
        return io.receiveInput();
    }

    // TODO: 문자열 분리와 정수 리스트 변경을 한번에 하고 있음. 수정 필요
    public List<Integer> createWinningNumbers(String rawWinningNumbers) {
        String[] numbers = rawWinningNumbers.split(",");

        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .toList();
    }

    public void printRequestBonusNumber(){
        io.printMessage("보너스 번호를 입력해 주세요.");
    }

    public String inputBonusNumber() {
        return io.receiveInput();
    }
}
