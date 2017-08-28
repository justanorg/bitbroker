package justanorg.bitbroker.model;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Market {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("name", getName())
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Market)) return false;
        Market market = (Market) o;
        return Objects.equals(id, market.id) &&
                Objects.equals(name, market.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
