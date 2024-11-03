package utils;

import java.util.List;
import validator.Validator;

public class Converter {
    public static List<Integer> convertStringToNumber(List<String> elements) {
        Integer[] convertedContainer = new Integer[elements.size()];
        for (int i = 0; i < elements.size(); i++) {
            Validator.validateNumber(elements.get(i));
            convertedContainer[i] = Integer.parseInt(elements.get(i));
        }
        return List.of(convertedContainer);
    }
}
