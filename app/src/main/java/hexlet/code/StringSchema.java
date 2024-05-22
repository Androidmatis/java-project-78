package hexlet.code;

public class StringSchema extends BaseSchema<String> {
    private String subString;
    private Integer length;

    public StringSchema() {
        addPredicate(str -> requiredPredicate(str));
        addPredicate(str -> containsPredicate(str));
        addPredicate(str -> minLengthPredicate(str));
    }

    private boolean requiredPredicate(String element) {
        if (!(getIsRequired() == null)) {
            if (element == null || element.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public StringSchema contains(String element) {
        this.subString = element.toString();
        return this;
    }

    private boolean containsPredicate(String element) {
        if (!(subString == null)) {
            if (!element.contains(subString) && !subString.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public StringSchema minLength(int number) {
        this.length = number;
        return this;
    }

    private boolean minLengthPredicate(String element) {
        if (!(length == null)) {
            if (!(subString == null || subString.isEmpty()) && !element.contains(subString)) {
                return false;
            }
        }
        return true;
    }

}
