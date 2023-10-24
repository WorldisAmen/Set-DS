public class BitOperations implements IBitOperations {
    @Override
    public int getBit(int number, int position) {return (number >> position) & 1;}
    @Override
    public int setBit(int number, int position) {return number | (1 << position);}
    @Override
    public int clearBit(int number, int position) {return number & ~(1 << position);}
    @Override
    public int updateBit(int number, int position, boolean value) {return (value) ? setBit(number, position) : clearBit(number, position);}
}
