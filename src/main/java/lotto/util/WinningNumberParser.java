package lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumberParser {
   public static List<Integer> parseWinningNumber(String[] winningNumbers){

       List<Integer> parsedWinningNumbers = Stream.of(winningNumbers)
               .map(Integer::parseInt)
               .toList();

       return Collections.unmodifiableList(parsedWinningNumbers);
   }

   public static int parseBonusNumber(String bonusNumber) {
       return Integer.parseInt(bonusNumber) ;
   }
}
