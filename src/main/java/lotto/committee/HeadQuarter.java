package lotto.committee;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.MessageCenter;

public class HeadQuarter {

    WonNumbers wonNumbers = new WonNumbers();

    public WonNumbers pickNumbers() {

        pickMainNumbers();
        pickBonusNumber();

        return wonNumbers;
    }

    void pickMainNumbers() {

        MessageCenter.NEW_LINE.print();
        MessageCenter.PICK_MAIN.print();

        while(wonNumbers.getLotto() == null) {
            String initialNums = read();
            loopMains(initialNums);
        }
    }

    void loopMains(String initialNums) {
        try {
            saveMains(initialNums);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(MessageCenter.ERROR_PICK.get());
        }
    }

    private List<Integer> parseMains(String[] initialMains) {
        List<Integer> parsedMains = new ArrayList<>();
        for (String initialMain : initialMains) {
            Integer parsedMain= parse(initialMain);
            validateUnique(parsedMains, parsedMain);
            validateRange(parsedMain);
            parsedMains.add(parsedMain);
        }
        return parsedMains;
    }

    private void saveMains(String initialNums) {
        String[] initialMains = initialNums.split(",");
        List<Integer> parsedMains = parseMains(initialMains);
        Lotto mainNumbers = new Lotto(parsedMains);
        wonNumbers.saveWonLotto(mainNumbers);
    }

    void pickBonusNumber() {

        MessageCenter.NEW_LINE.print();
        MessageCenter.PICK_BONUS.print();

        while(wonNumbers.getBonus() == null) {
            wonNumbers.cleanBonus();
            String initialNum = read();
            loopBonus(initialNum);
        }
    }

    void loopBonus(String initialNum) {
        try {
            saveBonus(initialNum);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(MessageCenter.ERROR_PICK.get());
        }
    }

    Integer parseBonus(String initialNum) {
        Integer parsedBonus= parse(initialNum);
        List<Integer> mainNumbers = wonNumbers.getLotto().getNumbers();
        validateUnique(mainNumbers, parsedBonus);
        validateRange(parsedBonus);
        return parsedBonus;
    }

    private void saveBonus(String initialNum) {
        Integer parsedBonus = parseBonus(initialNum);
        wonNumbers.saveWonBonus(parsedBonus);
    }

    private String read() {
        return Console.readLine();
    }

    private Integer parse(String textNum) {
        String trimmedNum = trim(textNum);
        return Integer.parseInt(trimmedNum);
    }

    private String trim(String text) {
        return text.trim();
    }

    private void validateRange(Integer parsedNum) {
        if (parsedNum <= 0 || parsedNum > 45) {
            throw new IllegalArgumentException(MessageCenter.ERROR_PICK.get());
        }
    }

    private void validateUnique(List<Integer> mainNumbers, Integer parsedNum) {
        if (mainNumbers.contains(parsedNum)) {
            throw new IllegalArgumentException(MessageCenter.ERROR_PICK.get());
        }
    }





}
