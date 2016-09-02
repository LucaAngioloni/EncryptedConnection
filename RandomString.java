/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.security.SecureRandom;
/**
 *
 * @author LucaAngioloni
 */
public class RandomString {
    
    private SecureRandom randomGen;
    
    public String generateString(){
        randomGen = new SecureRandom();
        String result = new BigInteger(130, randomGen).toString(32);
        return result.substring(0, 16);
    }
}
