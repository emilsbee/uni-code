package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;


public class DictionaryAttack {
	private Map<String, String> passwordMap = new HashMap<>();
	private Map<String, String> hashDictionary = new HashMap<>();

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename the full path to the file
	 * @throws IOException
	 */
	public void readPasswords(String filename) throws IOException {
		// Initialises the file reader
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String str = reader.readLine(); // Reads first line in file

		while(str != null) { // As long as there is a line to read
			String[] splitString = str.split(": ");
			String username = splitString[0];
			String hashedPassword = splitString[1];

			passwordMap.put(username, hashedPassword);

			str = reader.readLine();
		}
		reader.close();
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password String
	 * @return MD5 hash of given password
	 * @throws NoSuchAlgorithmException
	 */
	public String getPasswordHash(String password) throws NoSuchAlgorithmException {
		
			MessageDigest md = MessageDigest.getInstance("MD5"); // Initialise the md5 algorithm

			md.update(password.getBytes()); // Update the algorithm with input bytes 

			byte[] digest = md.digest(); // Creates the hashed bytes

    		return Hex.encodeHexString(digest); // Returns HEX encoded string of the hashed bytes
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 * @throws NoSuchAlgorithmException
	 */
	public boolean checkPassword(String user, String password) throws NoSuchAlgorithmException {

		String hashedPassword = getPasswordHash(password);
		
		return passwordMap.containsKey(user) && passwordMap.get(user).equals(hashedPassword);
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary (full path)
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
    public void addToHashDictionary(String filename) throws IOException, NoSuchAlgorithmException {
        // Initialises the file reader
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		String str = reader.readLine(); // Reads first line in file

		while(str != null) { // As long as there is a line to read
			hashDictionary.put(getPasswordHash(str), str);

			str = reader.readLine();
		}
		
		reader.close();
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		
		for (Map.Entry<String, String> entry : passwordMap.entrySet()) {
			
			if (hashDictionary.containsKey(entry.getValue())) {
				System.out.println(entry.getKey() + ":" + hashDictionary.get(entry.getValue()));
			}
		}
	}

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		DictionaryAttack da = new DictionaryAttack();
		
		da.readPasswords("/home/emils/Documents/Code/uni-code/src/ss/week6/test/LeakedPasswords.txt");
		da.addToHashDictionary("/home/emils/Documents/Code/uni-code/src/ss/week6/dictionaryattack/dictionary.txt");
		da.doDictionaryAttack();
	}

}
