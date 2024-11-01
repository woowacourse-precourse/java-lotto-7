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


    public static Lotto getRandom() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public static List<Lotto> getRandoms(int n) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lottos.add(getRandom());
        }
        return lottos;
    }



