package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.dto.PaperDto;
import lotto.dto.ResultDto;
import lotto.rank.Rank;

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

    public void printResult(ResultDto resultDto) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (var result : resultDto.getResults()) {
            Rank rank = result.getRank();
            int count = result.getCount();
            System.out.printf(String.format(rank.getRankFormat(), count));
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", resultDto.getYield());
    }
}
