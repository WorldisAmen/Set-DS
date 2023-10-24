public interface IBitOperations {
    public int getBit(int number, int position);
    public int setBit(int number, int position);
    public int clearBit(int number, int position);
    public int updateBit(int number, int position, boolean value) ;
}
