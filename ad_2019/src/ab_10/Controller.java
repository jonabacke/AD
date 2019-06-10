package ab_10;

import java.awt.Dialog.ModalExclusionType;
import java.math.BigInteger;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
import java.util.ResourceBundle;

import javax.xml.stream.events.StartDocument;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/*
 * https://github.com/eduardolundgren/rsa-prime-factorization/blob/master/src/RSA.java
 */

public class Controller implements Initializable {
	
	@FXML
	private Label lblP;
	@FXML
	private Label lblQ;
	@FXML
	private Label lblN;
	@FXML
	private Label lblPhi;
	@FXML
	private Label lblPublicKey;
	@FXML
	private Label lblPrivateKey;
	@FXML
	private Label lblPublicKeyIn;
	@FXML
	private Label lblModulus;
	@FXML
	private Label lblSessionKeyEncrypt;
	@FXML
	private Label lblSessionKeyDencrypt;
	
	@FXML
	private TextArea txtPublicKeyOut;
	@FXML
	private TextArea txtPublicKeyIn;
	@FXML
	private TextArea txtEncryptIn;
	@FXML
	private TextArea txtEncryptOut;
	@FXML
	private TextArea txtDecryptIn;
	@FXML
	private TextArea txtDecryptOut;
	
	@FXML
	private Button btnCreatePublicKey;
	@FXML
	private Button btnEncrypt;
	@FXML
	private Button btnActivatePublicKey;
	@FXML
	private Button btnDecrypt;
	
	private final static BigInteger one = new BigInteger("1");

	private final static SecureRandom random = new SecureRandom();

	public BigInteger privateKey;

	public BigInteger publicKey;

	public BigInteger n;
	
	BigInteger phi;
	
	BigInteger p;
	
	BigInteger q;
	
	private byte [] out;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	public static class Triple {
		
		public final BigInteger d;
		public final BigInteger s;
		public final BigInteger t;
		
		private Triple(final BigInteger d, final BigInteger s, final BigInteger t) {
			this.d = d; this.s = s; this.t = t;
		}
	}
	
	public static Triple extEuklid(final BigInteger a, final BigInteger b) {
		if (b.equals(BigInteger.ZERO)) {
			return new Triple(a, BigInteger.ONE, BigInteger.ZERO);
		} else {
			final Triple extension = extEuklid(b, a.mod(b));
			return new Triple(extension.d, extension.t, extension.s.subtract(a.divide(b).multiply(extension.t)));
		}
	}
	
	
	
	@FXML
	public void handleCreatePublicKeyAction(ActionEvent event) {
		BigInteger p = BigInteger.probablePrime(64, random); // generating a big prime number (bits)
		BigInteger q = BigInteger.probablePrime(64, random); // generating a big prime number (bits)
		BigInteger phi = ( p.subtract(one) ).multiply( q.subtract(one) ); // phi = (p - 1)*(q - 1)
		BigInteger n = p.multiply(q); // n = p*q
		//publicKey  = new BigInteger("65537"); // e = common prime = 2^16 + 1
		do {
			publicKey = findE(phi);
		} while((publicKey.bitLength()+1)/8 != 8);
		
		Triple triple = extEuklid(publicKey, phi);
		privateKey = triple.s;
		//privateKey = publicKey.modInverse(phi); // d = (publicKey^-1) * mod(phi)
		
//		lblP.setText("p = " + p);
//		lblQ.setText("q = " + q);
//		lblN.setText("N = " + n);
//		lblPhi.setText("phi = " + phi);
//		lblPublicKey.setText("public key = " + publicKey);
//		lblPrivateKey.setText("private key = " + privateKey);
		System.out.println("p = " + p);
		System.out.println("q = " + q);
		System.out.println("N = " + n);
		System.out.println("phi = " + phi);
		System.out.println("public key = " + publicKey);
		System.out.println("private key = " + privateKey);
		
		byte[] publicBase = new byte[24];
		byte[] pkByte = BigInt2Byte(publicKey, 8);
		byte[] mod = BigInt2Byte(n, 16);
		
		System.arraycopy(pkByte, 0, publicBase, 0, 8);
		for (int i = 0; i < 16; i++) {
			publicBase[i+8] = mod[i];
		}
		
//		txtPublicKeyOut.setText(Base64.getEncoder().encodeToString(publicBase));
	}
	
	public BigInteger findE(BigInteger phi) {
		BigInteger prime = BigInteger.probablePrime(64, random);
		
		do {
			prime = prime.add(new BigInteger("1"));
		} while(prime.gcd(phi).compareTo(new BigInteger("1")) == 0);
		
		return prime; 
	}
	
	@FXML
	public void handleActivateKeyAction(ActionEvent event) {
		byte[] array = Base64.getDecoder().decode(txtPublicKeyIn.getText());
		
		byte[] mod = new byte[16];
		byte[] pk =  new byte[8];
		
		for (int i = 0; i < 8; i++) {
			pk[i] = array[i];
		}
		for (int i = 0; i < 16; i++) {
			mod[i] = array[i+8];
		}
		
		lblPublicKeyIn.setText(Byte2BigInt(pk).toString());
		lblModulus.setText(Byte2BigInt(mod).toString());
		publicKey = Byte2BigInt(pk);
		n = Byte2BigInt(mod);
	}
	
	static byte[] BigInt2Byte (BigInteger src, int bytesize){
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
	
	static BigInteger Byte2BigInt(byte[] b){
		return new BigInteger ( 1 , b );
	}
	
	@FXML
	public void handleEncryptAction(ActionEvent event) {
		if (publicKey == null) {
			System.out.println("Kein Public Key!");
			return;
		}
		
//		byte[] in = txtEncryptIn.getText().getBytes();
		byte[] in = {1,2,3,4,5,6,7,8,9,0};
		System.err.println(in.length);
		
		int outLength = Math.abs(16 - (in.length % 16));
		byte[] füllung = {20,20,20,20,20,20,20,20,20,20,20,20,20,20,20};
		byte[] out = new byte[in.length + 16 + outLength];
		System.arraycopy(in, 0, out, 16, in.length);
		System.arraycopy(füllung, 0, out, in.length + 16, outLength);
		
		BigInteger sessionKeyBI = new BigInteger(8*8, new Random());
		BigInteger cipher = sessionKeyBI.modPow(publicKey, n);
		sessionKeyBI = cipher.modPow(privateKey, n);
		byte[] sessionKey = BigInt2Byte(sessionKeyBI, 16);
		lblSessionKeyEncrypt.setText("sesion key = " + sessionKeyBI.toString());
		
		
		// ich glaube dass hier an dem sessionkey was nicht stimmt weil bei der ausgabe die ersten stellen alle 0 sind
		// also ist der generierte vielleicht zu kurz 
		// sonst 
		
		
		for (int i = 1; i < (out.length / 16); i++) {
			out = feistelBlock(out, i * 16, sessionKeyBI, true).clone();
		}
		for (int i = 0; i < sessionKey.length; i++) {
			System.out.print(sessionKey[i]);
		}
		System.out.println();
		sessionKey = sessionKeyVerschlüsseln(sessionKey);
		for (int i = 0; i < sessionKey.length; i++) {
			System.out.print(sessionKey[i]);
		}
		System.out.println();
		sessionKey = sessionKeyEntschlüsseln(sessionKey);
		for (int i = 0; i < sessionKey.length; i++) {
			System.out.print(sessionKey[i]);
		}
		System.out.println();
		sessionKey = sessionKeyVerschlüsseln(sessionKey);
		for(int i = 0; i < 16; i++) {
			out[i] = sessionKey[i];
		}
		this.out = out.clone();
		System.out.println(out.length);
		
		
//		txtEncryptOut.setText(Base64.getEncoder().encodeToString(out));
		System.out.println("Test");
	}
	
	
	@FXML
	public void handleDecryptAction(ActionEvent event) {
		if (publicKey == null) {
			System.out.println("Kein Public Key!");
			return;
		}
		
//		byte[] in = txtDecryptIn.getText().getBytes();
		byte[] in = this.out.clone();
		System.err.println(in.length);
		
		byte[] out = new byte[in.length - 16];
		
		byte[] sessionKey = new byte[16];
		System.arraycopy(in, 0, sessionKey, 0, 16);
		sessionKey = sessionKeyEntschlüsseln(sessionKey);
		BigInteger sessionKeyBig = Byte2BigInt(sessionKey);
		lblSessionKeyDencrypt.setText("sesion key = " + sessionKeyBig.toString());
		
		for (int i = 1; i < (in.length / 16); i++) {
			in = feistelBlock(in, i * 16, sessionKeyBig, false).clone();
		}
		
		System.arraycopy(in, 16, out, 0, out.length);
		
		
//		txtDecryptOut.setText(Base64.getEncoder().encodeToString(out));
		System.out.println("Test2");
		
	}	
	
	
	public byte[] feistelBlock(byte [] block, int start, BigInteger sessionKey, boolean verschlüsseln) {
		byte [] right = new byte[8];
		byte [] left = new byte[8];
		byte [] temp = new byte[8];
		//get data
		if (!verschlüsseln) {
			//swap
			temp = right.clone();
			right = left.clone();
			left = temp.clone();
		}
		System.arraycopy(block, start, left, 0, 8);
		System.arraycopy(block, start + 8, right, 0, 8);
		for (int i = 0; i < 12; i++) {
			//swap
			temp = right.clone();
			right = left.clone();
			left = temp.clone();
			//feisteln
			temp = feisteln(right, sessionKey, block.length).clone();
			//xor
			for (int j = 0; j < temp.length; j++) {
				right[j] = (byte) (left[j] ^ temp[j]);
			}			
		}
		if (!verschlüsseln) {
			//swap
			temp = right.clone();
			right = left.clone();
			left = temp.clone();
		}
		System.arraycopy(left, 0, block, start, 8);
		System.arraycopy(right, 0, block, start + 8, 8);
		return block;
		
	}

	public byte[] feisteln(byte[] right, BigInteger sessionKey, int length) {
		length = 64;
		BigInteger lengthBig = BigInteger.valueOf((long)((length * 8) - 1));
		BigInteger temp = Byte2BigInt(right).pow(2);
		temp = temp.add(sessionKey);
		temp.mod(lengthBig);
		return BigInt2Byte(temp, 8);
	}
	
	private byte[] sessionKeyVerschlüsseln(byte[] sessionKey) {
		BigInteger session = new BigInteger(1, sessionKey);
		session = session.modPow(publicKey, n);
		return BigInt2Byte(session, 16);
	}
	
	private byte[] sessionKeyEntschlüsseln(byte[] sessionKey) {
		BigInteger session = new BigInteger(1, sessionKey);
		session = session.modPow(privateKey, n);
		return BigInt2Byte(session, 16);
	}

}
