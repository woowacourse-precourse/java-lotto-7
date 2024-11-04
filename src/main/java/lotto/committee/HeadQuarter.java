package lotto.committee;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.MessageCenter;

public class HeadQuarter {

    WonNumbers wonNumbers;

    public WonNumbers pickNumbers() {

        MessageCenter.PICK_MAIN.print();
        pickMainNumbers();
        MessageCenter.PICK_BONUS.print();
        pickBonusNumber();


        return wonNumbers;
    }

    private void pickBonusNumber() {
        boolean result = false;
        while(result == true) {
            wonNumbers.cleanBonus();
            loopBonus();
            result = true;
        }
    }

    private void loopBonus() {
        try {
            String initialNums = read();
            saveMains(initialNums);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(MessageCenter.ERROR_PICK.get());
        }
    }


    private void pickMainNumbers() {
        boolean result = false;
        while(result == true) {
            wonNumbers.cleanAll();
            loopMains();
            result = true;
        }
    }

    private void loopMains() {
        try {
            String initialNum = read();
            saveBonus(initialNum);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(MessageCenter.ERROR_PICK.get());
        }
    }

    private void saveBonus(String initialNum) {
        Integer parsedBonus = parseBonus(initialNum);
        wonNumbers.saveWonBonus(parsedBonus);
    }

    private Integer parseBonus(String initialNum) {
        Integer parsedBonus= parse(initialNum);
        List<Integer> mainNumbers = wonNumbers.getLotto().getNumbers();
        validateUnique(mainNumbers, parsedBonus);
        validateRange(parsedBonus);
        return parsedBonus;
    }

    ;

    private void saveMains(String initialNums) {
        String[] initialMains = initialNums.split(",");
        List<Integer> parsedMains = parseMains(initialMains);
        Lotto mainNumbers = new Lotto(parsedMains);
        wonNumbers.saveWonLotto(mainNumbers);
    }

    private String read() {
        return Console.readLine();
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
