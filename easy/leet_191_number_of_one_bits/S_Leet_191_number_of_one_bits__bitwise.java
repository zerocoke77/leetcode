package leet_191_number_of_one_bits;

public class S_Leet_191_number_of_one_bits__bitwise {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    
	public static void main(String args[]) {
		S_Leet_191_number_of_one_bits__bitwise inst = new S_Leet_191_number_of_one_bits__bitwise();
		int res = inst.hammingWeight(-3);
//		int res = inst.hammingWeight(3);
		System.out.println(res);
	}
}
