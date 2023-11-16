
public class EncryptionTester {
	
	public static void main(String[] args) throws Exception {
		
        String encryptedFilePath = "/Users/sharrellgreene/Desktop/CS 203-1F203L-QF Object-Oriented Programming/CS203_Lab/Lab09/Lab12/FA23-CS203-Lab11/src/encrypted.txt";
        String decryptedFilePath = "/Users/sharrellgreene/Desktop/CS 203-1F203L-QF Object-Oriented Programming/CS203_Lab/Lab09/Lab12/FA23-CS203-Lab11/src/decrypted.txt";
        String inputFilePath = "/Users/sharrellgreene/Desktop/CS 203-1F203L-QF Object-Oriented Programming/CS203_Lab/Lab09/Lab12/FA23-CS203-Lab11/src/encryptMe.txt";
        String outputFilePath = "/Users/sharrellgreene/Desktop/CS 203-1F203L-QF Object-Oriented Programming/CS203_Lab/Lab09/Lab12/FA23-CS203-Lab11/src/newEncrypted.txt";

        int shift = 4; // Says how much you would like to shift

        Encrypter enc = new Encrypter(shift);

		enc.encrypt(inputFilePath, outputFilePath);
		enc.decrypt(encryptedFilePath, decryptedFilePath);


	}


}
