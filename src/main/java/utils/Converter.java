package utils;

import java.util.List;
import validator.Validator;

public class Converter {
    public static List<Integer> convertStringToNumber(List<String> elements) {
        List<Integer> convertedContainer;
        for (String element : elements) {
            Validator.validateNumber(element);
            convertedContainer.add(Integer.parseInt(element));
        }
        return convertedContainer;
    }
}
