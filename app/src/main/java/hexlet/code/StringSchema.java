package hexlet.code;

public class StringSchema {

    private Boolean isRequired;
    private String subString;
    private Integer length;

    public StringSchema required() {
        this.isRequired = true;
        return  this;
    }

    private boolean getIsRequired(String element) {
        if (!(isRequired == null)) {
            if (element == null || element.isEmpty()) {
                return  false;
            }
        }
        return true;
    }

    public StringSchema contains(String element) {
        this.subString = element.toString();
        return  this;
    }

    private boolean getContains(String element) {
        if (!(subString == null)) {
            if (!element.contains(subString) && !subString.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public StringSchema minLength(int number) {
        this.length = number;
        return  this;
    }

    private boolean getMinLength(String element) {
        if (!(length == null)) {
            if (!(subString == null ||subString.isEmpty()) && !element.contains(subString)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(String element) {
        if (!getIsRequired(element)) {
            return false;
        }
        if (!getContains(element)) {
            return false;
        }
        if (!getMinLength(element)) {
            return false;
        }

        return true;
    }

}
