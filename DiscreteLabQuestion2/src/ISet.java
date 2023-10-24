public interface ISet {
    public int union(Set other);
    public int intersection(Set other);
    public int complement();
    public int difference(Set other);
    public int cardinality();
    public void print();

}
