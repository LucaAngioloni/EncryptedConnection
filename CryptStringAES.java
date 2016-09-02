/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
/**
 *
 * @author LucaAngioloni
 */
public class CryptStringAES {
    private final Key AESKey;
    private final Cipher cipher;
    
    public CryptStringAES() throws NoSuchAlgorithmException, NoSuchPaddingException{
        RandomString rndStr = new RandomString();
        AESKey = new SecretKeySpec(rndStr.generateString().getBytes(), "AES");
        cipher = Cipher.getInstance("AES");
        
    }
    
    public CryptStringAES(String Key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
        if(Key.length() == 16){
        AESKey = new SecretKeySpec(Key.getBytes(), "AES");
        cipher = Cipher.getInstance("AES");
        }
        else{
            throw new InvalidKeyException();
        }
    }
    
    public byte [] encryptStringToByte(String msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
       cipher.init(Cipher.ENCRYPT_MODE, AESKey);
       return cipher.doFinal(msg.getBytes());
    }
    
    public byte [] encryptStringToByte(byte [] msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
       cipher.init(Cipher.ENCRYPT_MODE, AESKey);
       return cipher.doFinal(msg);
    }
    
    public String encryptString(String msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        cipher.init(Cipher.ENCRYPT_MODE, AESKey);
        byte[] array = cipher.doFinal(msg.getBytes());
        return new String(array);
    }
    
    public String encryptString(byte [] msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
        cipher.init(Cipher.ENCRYPT_MODE, AESKey);
        byte[] array = cipher.doFinal(msg);
        return new String(array);
    }
    
    public String decrtyptString(byte [] encrypted) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        cipher.init(Cipher.DECRYPT_MODE, AESKey);
        return new String(cipher.doFinal(encrypted));
    }
    
    public byte[] decrtyptStringToByte(byte [] encrypted) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        cipher.init(Cipher.DECRYPT_MODE, AESKey);
        return cipher.doFinal(encrypted);
    }
    
    public String decrtyptString(String msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        cipher.init(Cipher.DECRYPT_MODE, AESKey);
        return new String(cipher.doFinal(msg.getBytes()));
    }
    
    public byte [] decrtyptStringToByte(String msg) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        cipher.init(Cipher.DECRYPT_MODE, AESKey);
        return cipher.doFinal(msg.getBytes());
    }
}
