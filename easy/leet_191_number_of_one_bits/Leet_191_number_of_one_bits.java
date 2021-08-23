package leet_191_number_of_one_bits;

public class Leet_191_number_of_one_bits {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
	
	public static void main(String args[]) {
		Leet_191_number_of_one_bits inst = new Leet_191_number_of_one_bits();
		int res = inst.hammingWeight(11);
//		int res = inst.hammingWeight(3);
		System.out.println(res);
	}
}
