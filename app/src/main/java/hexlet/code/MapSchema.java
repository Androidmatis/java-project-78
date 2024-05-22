package hexlet.code;

import java.util.Map;

public class MapSchema<T, R> extends BaseSchema<Map<T, R>> {
    private Integer size;

    public MapSchema() {
        addPredicate(map -> requiredPredicate(map));
        addPredicate(map -> sizeofPredicate(map));
    }

    private boolean requiredPredicate(Map<T, R> element) {
        if (!(getIsRequired() == null)) {
            if (element == null) {
                return false;
            }
        }
        return true;
    }

    public MapSchema sizeof(int number) {
        this.size = number;
        return this;
    }

    private boolean sizeofPredicate(Map<T, R> element) {
        if (!(size == null) && !(element == null)) {
            if (element.size() < size) {
                return false;
            }
        }
        return true;
    }
}
