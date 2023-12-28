package fop.w8iter;

import java.util.Iterator;

public class PasswordIterator implements Iterator<String> {
	int length;
	char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
	String result = "";
	boolean sameforgood = true;
	boolean acendingforgood = true;
	boolean decendingforgood = true;

    public PasswordIterator(int passwordLength) {
    	if(passwordLength > 9 || passwordLength < 1)
    	{
    		Util.badArgument("Invalid Length Given");
        	length = 0;
    	}
    	else
    	{
        	length = passwordLength;
    	}
    }

    public boolean hasNext() {
        for(int i = 0; i < length; i++)
        {
        	if(length == 1 && result != "" && result.toCharArray()[i] == digits[9])
        	{
        		return false;
        	}
        	if(!sameforgood && length ==1)
        	{
        		return false;
        	}
        	if(result == null ||result == ""|| result.toCharArray()[i] != digits[9]|| sameforgood )
        	{
        		return true;
        	}
        }
        return false;
    }

    public String next() {
    	
    	if(hasNext() == false)
    	{
    		 Util.noSuchElement("There are no more numbers to enumerate");
    		return null;
    	}
    	
        char x;
        int y = 0;
        char[] tempo = new char[length];
    	if(result == "" || result == null)
    	{
            for(int i = 0; i < length; i++)
            {
            	tempo[i] = digits[0];
            	result += tempo[i];
            }
            return result;
    	}
    	else
    	{
    		tempo = result.toCharArray();
    		x = result.toCharArray()[0];    		
    		boolean same = true;
    		boolean acending = true;
    		boolean decending = true;
    		result = "";
    		
    		for(int i = 0; i < 10; i++)
    		{
    			if(x == digits[i])
    			{
    				y = i;
    			}
    		}
    		
    		for(int i = 0; i < length; i++)
    		{
    			if(tempo[i] == x && same)
    			{
    				same = true;
    			}
    			else
    			{
    				same = false;
    			}
    			
    			if(y+i <= 9 && tempo[i] == digits[y+i] && acending )
    			{
    				acending = true;
    			}
    			else
    			{
    				acending = false;
    			}
    			
    			if(y-i >= 0 && tempo[i] == digits[y-i] && decending )
    			{
    				decending = true;
    			}
    			else
    			{
    				decending = false;
    			}
    		}
    		
    		if(same && sameforgood)
    		{
    			if(y + 1 <= 9)
    			{
    	            for(int i = 0; i < length; i++)
    	            {
    	            	tempo[i] = digits[y+1];
    	            	result += tempo[i];
    	            }

    	            return result;
    			}
    			else
    			{
    	            for(int i = 0; i < length; i++)
    	            {
    	            	tempo[i] = digits[i];
    	            	result += tempo[i];
    	            }
    	            same = false;
    	            sameforgood = false;
    	            return result;
    			}
    			
    		}
    		else if(acending && acendingforgood)
    		{
    			if(y + length <= 9)
    			{
    				y++;
    	            for(int i = 0; i < length; i++)
    	            {
    	            	tempo[i] = digits[y+i];
    	            	result += tempo[i];
    	            }
    	            return result;
    			}
    			else
    			{
    				y = 0;
        	            for(int i = 0; i < length; i++)
        	            {
        	            	tempo[length - 1 -i] = digits[y+i];
        	            }
        	            for(int i = 0; i < length; i++)
        	            {
        	            	result += tempo[i];
        	            }
        	            acending = false;
        	            acendingforgood = false;
        	            return result;
    			}
    			
    		}
    		else if(decending && decendingforgood)
    		{

    			if(y != 9)
    			{
        			x = tempo[length - 1];
            		for(int i = 0; i < 10; i++)
            		{
            			if(x == digits[i])
            			{
            				y = i;
            			}
            		}
            		y++;
    	            for(int i = 0; i < length; i++)
    	            {
    	            	tempo[length - 1 -i] = digits[y+i];
    	            }
    	            for(int i = 0; i < length; i++)
    	            {
    	            	result += tempo[i];
    	            }
    	            return result;
    			}
    			else
    			{
    	            for(int i = 0; i < length-1; i++)
    	            {
    	            	tempo[i] = digits[0];
    	            	result += tempo[i];
    	            }
    	            tempo[length-1] = digits[1];
    	            result +=tempo[length-1];
    	            decending = false;
    	            decendingforgood = false;
    	            return result;
    			}
    		}
    		else
    		{
    			boolean repeating = true;
    			boolean accept = false;
    			int z = length -1;
    			int temp = 0;
    			while(repeating)
    			{
        			while(!accept)
        			{
            			if(tempo[z] != digits[9])
            			{
            				for(int i =0; i <= 9; i++)
            				{
            					if(tempo[z] == digits[i])
            					{
            						temp = i;
            					}
            				}
            				tempo[z] = digits[temp +1];
            				accept = true;
            			}
            			else
            			{
            				tempo[z] = digits[0];
            				z = z-1;
            			}
        			}
        			
        			same = true;
        			acending = true;
        			decending = true;
        			
            		for(int i = 0; i < length; i++)
            		{
            			if(tempo[i] == x && same)
            			{
            				same = true;
            			}
            			else
            			{
            				same = false;
            			}
            			
            			if(y+i <= 9 && tempo[i] == digits[y+i] && acending )
            			{
            				acending = true;
            			}
            			else
            			{
            				acending = false;
            			}
            			
            			if(y-i >= 0 && tempo[i] == digits[y-i] && decending)
            			{
            				decending = true;
            			}
            			else
            			{
            				decending = false;
            			}
            			
            			
            			if(same||acending||decending)
            			{
            				repeating = true;
            				accept = false;
            			}
            			else
            			{
            				repeating = false;
            				accept = true;
            			}
          
            		}
            			
            			
            		
        			
    			}
    			for(int i = 0; i < length ; i++)
    			{
    				result += tempo[i];
    			}
    			return result;

    		}
    		
    	}
    }

}
