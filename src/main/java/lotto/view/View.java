package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.dto.PaperDto;

public class View {


    public String input() {
        return Console.readLine();
    }

    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return input();
    }

    public String inputWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return input();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return input();
    }

    public void printPaperStatus(List<PaperDto> paperDto) {
        int size = paperDto.size();
        System.out.printf("%d개를 구매했습니다.%n", size);
        String paperStatus = makePaperToString(paperDto);
        System.out.println(paperStatus);
    }

    private String makePaperToString(List<PaperDto> paperDto) {
        StringBuilder sb = new StringBuilder();

        for (var paper : paperDto) {
            sb.append(paper).append("\n");
        }
        return sb.toString().trim();
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
