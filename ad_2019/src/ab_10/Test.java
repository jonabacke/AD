package ab_10;

import java.math.BigInteger;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		byte [] array = new byte[20];
		for (int i = 0; i < array.length; i++) {
			array[i] =  (byte) i;
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println();
		BigInteger arrayBig = test.Byte2BigInt(array);
		byte [] array2 = test.BigInt2Byte(arrayBig, 20);

		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i]);
		}
		System.out.println();
		Controller controller = new Controller();
		controller.handleCreatePublicKeyAction(null);
		controller.handleEncryptAction(null);

		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i]);
		}
		System.out.println();
	}
	
	public byte[] BigInt2Byte (BigInteger src, int bytesize){
		byte[] out = new byte[bytesize];
		BigInteger mod = new BigInteger("2");
		mod = mod.pow(bytesize*8);
		src = src.mod(mod); 
		int startdst = bytesize - src.toByteArray().length ;
		int cpylength = src.toByteArray().length;
		if((src.bitLength() % 8) != 0){
			System.arraycopy(src.toByteArray(),0,out,startdst,cpylength);
		}
		else {
			System.arraycopy(src.toByteArray(),1,out,startdst+1,cpylength-1);
		}
		return out;
	}
	
	public BigInteger Byte2BigInt(byte[] b){
		return new BigInteger ( 1 , b );
	}
	
	

}
