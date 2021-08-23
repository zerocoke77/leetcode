package leet_191_number_of_one_bits;

public class Leet_191_number_of_one_bits_bitwise {
    public int hammingWeight(int n) {
    	int count = 0;
    	if(n > 0) {
        	while(n > 0) {
        		if(n%2 == 1) ++count;
        		n /= 2;       		
        	}
        } else if(n < 0) {
        	for(int i=0; i<32; ++i) {
        		if(((1 << i) & n) != 0) ++count;
        	}
        }
        
        return count;
    }
	
	public static void main(String args[]) {
		Leet_191_number_of_one_bits_bitwise inst = new Leet_191_number_of_one_bits_bitwise();
		int res = inst.hammingWeight(-3);
//		int res = inst.hammingWeight(3);
		System.out.println(res);
	}
}
