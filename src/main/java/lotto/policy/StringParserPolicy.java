package lotto.policy;

import lotto.validator.Validator;

public class StringParserPolicy {
    public void checkStringParserPolicy(String string) {
        Validator.shouldBeOnlyNumber(string);
        Validator.shouldNotBeTooBig(string);
        Validator.shouldBeOnlyNumber(string);
    }
}
