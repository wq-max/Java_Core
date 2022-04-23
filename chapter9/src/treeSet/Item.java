package treeSet;

import java.util.Objects;

public class Item implements Comparable<Item>{
    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[description=" + description + ", partNumber=" + partNumber + "]";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        var other = (Item) o;
        return Objects.equals(description, other.description) && partNumber == other.partNumber;
    }

    public int hashCode() {
        return Objects.hash(description, partNumber);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumber, o.partNumber);
        return diff != 0 ? diff : description.compareTo(o.description);
    }
}
