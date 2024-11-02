package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    private static final DecimalFormat formatter = new DecimalFormat("###,###");

    public Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<Lotto> createLottos(int n) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public List<String> getLottoStatus(List<Lotto> lottos) {
        List<String> status = new ArrayList<>();

        status.add(String.format("%d개를 구매했습니다.", lottos.size()));
        status.addAll(lottosToString(lottos));
        return status;
    }

    public List<String> getWinningDetails(LottoRankGroups groups) {
        List<String> winningDetails = new ArrayList<>();
        for (LottoRank rank : LottoRank.values()) {
            winningDetails.add(String.format("%s (%s원) - %s개",
                    getRankCondition(rank), getRankPrice(rank), getRankCount(groups, rank)));
        }
        return winningDetails;
    }

    private List<String> lottosToString(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::numbersToString)
                .toList();
    }

    private String getRankCondition(LottoRank rank) {
        return rank.getCondition();
    }

    private String getRankPrice(LottoRank rank) {
        return formatter.format(rank.getPrice());
    }

    private String getRankCount(LottoRankGroups groups, LottoRank targetRank) {
        return groups.getCount(targetRank).toString();
    }


}


