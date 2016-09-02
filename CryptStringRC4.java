/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author LucaAngioloni
 */
public class CryptStringRC4 {
    private final Key RC4Key;
    private final Cipher cipher;
    
    public CryptStringRC4() throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException{
        RandomString rndStr = new RandomString();
        RC4Key = new SecretKeySpec(rndStr.generateString().getBytes("ASCII"), "RC4");
        cipher = Cipher.getInstance("RC4");
    }
    
    public CryptStringRC4(String Key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException{
        if(Key.length() == 16){
        RC4Key = new SecretKeySpec(Key.getBytes("ASCII"), "RC4");
        cipher = Cipher.getInstance("RC4");
        }
        else{
            throw new InvalidKeyException();
        }
    }
    
    public byte [] encryptStringToByte(String msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
       cipher.init(Cipher.ENCRYPT_MODE, RC4Key);
       return cipher.doFinal(msg.getBytes("ASCII"));
    }
    
    public byte [] encryptByte(byte [] msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
       cipher.init(Cipher.ENCRYPT_MODE, RC4Key);
       return cipher.doFinal(msg);
    }
    
    public String encryptString(String msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        cipher.init(Cipher.ENCRYPT_MODE, RC4Key);
        byte[] array = cipher.doFinal(msg.getBytes("ASCII"));
        return new String(array, "ASCII");
    }
    
    public String encryptByteToString(byte [] msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        cipher.init(Cipher.ENCRYPT_MODE, RC4Key);
        byte[] array = cipher.doFinal(msg);
        return new String(array, "ASCII");
    }
    
    public String decrtyptByteToString(byte [] encrypted) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        cipher.init(Cipher.DECRYPT_MODE, RC4Key);
        return new String(cipher.doFinal(encrypted), "ASCII");
    }
    
    public byte[] decrtyptByte(byte [] encrypted) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        cipher.init(Cipher.DECRYPT_MODE, RC4Key);
        return cipher.doFinal(encrypted);
    }
    
    public String decrtyptString(String msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        cipher.init(Cipher.DECRYPT_MODE, RC4Key);
        return new String(cipher.doFinal(msg.getBytes("ASCII")));
    }
    
    public byte [] decrtyptStringToByte(String msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        cipher.init(Cipher.DECRYPT_MODE, RC4Key);
        return cipher.doFinal(msg.getBytes("ASCII"));
    }
}
