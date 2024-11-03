package lotto.parser;

import java.util.List;

public interface InputParser {
    int parseMoney(String money);

    List<Integer> parseNumbers(String input);

    int parseBonus(String bonus);
    
}
