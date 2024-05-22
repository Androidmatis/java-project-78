package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private Boolean isRequired;
    private List<Predicate<T>> predicates = new ArrayList<>();

    public void addPredicate(Predicate<T> predicate) {
        this.predicates.add(predicate);
    }

    public BaseSchema required() {
        this.isRequired = true;
        return this;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public boolean isValid(T element) {
        for (var predicate : predicates) {
            if (!predicate.test(element)) {
                return false;
            }
        }
        return true;
    }
}
