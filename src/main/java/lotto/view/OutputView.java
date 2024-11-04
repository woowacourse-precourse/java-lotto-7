package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.Match;

public class OutputView {

    public void print(String message) {
        System.out.println(message);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(String.join(", ", lotto.getLottoNumber()
                    .stream()
                    .map(number -> String.valueOf(number))
                    .toList()));
            sb.append("]");
            print(sb.toString());
        }
        print("");
    }

    public void printStatics(String message, List<Match> matches) {
        print(message);
        for (Match match : Match.values()) {
            StringBuilder sb = new StringBuilder();
            int count = getSize(matches, match);
            sb.append(match.getMatchCount()).append("개 일치");
            if (match.isBonusMatch()) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (");
            sb.append(getMoney(match)).append("원) - ").append(count).append("개");
            print(sb.toString());
        }
    }

    private static String getMoney(Match match) {
        return String.format("%,d", match.getMoney());
    }

    private static int getSize(List<Match> matches, Match match) {
        return matches.stream()
                .filter(match::equals)
                .toList()
                .size();
    }

}
