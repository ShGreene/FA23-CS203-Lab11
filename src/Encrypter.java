import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
        //TODO: Call the read method, encrypt the file contents, and then write to new file
    	
        try {
            String content = readFile(inputFilePath);
            String encryptedContent = encryptText(content);
            writeFile(encryptedContent, encryptedFilePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }
    }
    

    private String encryptText(String text) {
		// TODO Auto-generated method stub
    	
    	StringBuilder encryptedText = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                encryptedText.append((char) ((ch - base + shift) % 26 + base));
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }
	
	/**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param encryptedFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void decrypt(String encryptedFilePath, String decryptedFilePath) throws Exception {
        //TODO: Call the read method, decrypt the file contents, and then write to new file
    	
        try {
            String encryptedContent = readFile(encryptedFilePath);
            String decryptedContent = decryptText(encryptedContent);
            writeFile(decryptedContent, decryptedFilePath);
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }
    }
    
    private String decryptText(String text) {
        StringBuilder decryptedText = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                decryptedText.append((char) ((ch - base - shift + 26) % 26 + base));
            } else {
                decryptedText.append(ch);
            }
        }

        return decryptedText.toString();
    }


    

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
    	StringBuilder message = new StringBuilder();
        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            while (scanner.hasNextLine()) {
                message.append(scanner.nextLine()).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.toString());
        }
        return message.toString();
    }
    

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     */
    private static void writeFile(String data, String filePath) {
        //TODO: Write to filePath
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.print(data);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.toString());
        }
    }
    

    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}
