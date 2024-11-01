package lotto.models;

import java.util.ArrayList;
import java.util.List;

public class StaticModel {

    private static final String DELIMITER = ",";

    public List<Integer> stringToList (String lottoNumberInput) {
        ArrayList<Integer> numbers = new ArrayList<>();
        String[] tokens = lottoNumberInput.split(DELIMITER);
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }


}
