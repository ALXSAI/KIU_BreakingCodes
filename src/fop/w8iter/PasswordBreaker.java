package fop.w8iter;

import java.util.function.Function;

public class PasswordBreaker {

    public static String findPassword(Function<String, Integer> hashFunction, int passwordLength,
            String salt, int saltedPasswordHashValue) {
    	
    	
    	if(salt == null || hashFunction == null)
    	{
    		Util.badArgument("salt or hashFunction can not be null");
    	}
    	int[] possible = new int[passwordLength];
    	boolean found = false;
    	int sherlok = 1;
    	
    	while(!found)
    	{
    		String answer = "";
    		if(possible[passwordLength-sherlok] != 9)
    		{
    			possible[passwordLength-sherlok]++;
    			sherlok = 1;
    		}
    		else
    		{
    			possible[passwordLength-sherlok] = 0;
    			sherlok ++;
    		}
    		if(sherlok == passwordLength + 1)
    		{
    			return null;
    		}
    		
    		for(int i = 0; i < passwordLength; i++)
    		{
    			answer += possible[i];
    		}
    		
    		if((answer + salt).hashCode() == saltedPasswordHashValue)
    		{
    			found = true;
    			return answer;
    		}
    	}
    	

        return null;
    }

}
