package lotto.woowaLotto.common.adapter.parser;

import java.util.ArrayList;
import java.util.List;
import lotto.woowaLotto.lottoPlayer.woowaLotto.autoLotto.handler.domain.Lotto;

public class LottoParser {

    public Lotto parse(String input) {
        List<Integer> parsedList = parseInput(input);

        return new Lotto(parsedList);
    }

    private List<Integer> parseInput(String input) {
        List<Integer> parsedList = new ArrayList<>();
        try {
            for (String lottoWord : input.split(",")) {
                parsedList.add(Integer.parseInt(lottoWord.trim()));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 정수여야합니다.");
        }
        return parsedList;
    }
}
