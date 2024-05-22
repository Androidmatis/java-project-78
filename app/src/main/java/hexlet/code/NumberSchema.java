package hexlet.code;

public class NumberSchema extends BaseSchema<Integer> {
    private Boolean isPositive;
    private Boolean isRange;
    private int minRange;
    private int maxRange;

    public NumberSchema() {
        addPredicate(num -> requiredPredicate(num));
        addPredicate(num -> positivePredicate(num));
        addPredicate(num -> rangePredicate(num));
    }

    private boolean requiredPredicate(Integer element) {
        if (!(getIsRequired() == null)) {
            if (element == null) {
                return false;
            }
        }
        return true;
    }

    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    private boolean positivePredicate(Integer element) {
        if (!(element == null) && !(isPositive == null)) {
            if (element < 1) {
                return false;
            }
        }
        return true;
    }

    public NumberSchema range(int min, int max) {
        this.minRange = min;
        this.maxRange = max;
        this.isRange = true;
        return this;
    }

    private boolean rangePredicate(Integer element) {
        if (!(isRange == null) && !(element == null)) {
            if (element < minRange || element > maxRange) {
                return false;
            }
        }
        return true;
    }

}
