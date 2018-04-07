
public class HashingTool
{
	/**
	 * 
	 * Code from https://stackoverflow.com/questions/7700400/whats-a-good-hash-function-for-english-words
	 * and https://github.com/kfricilone/OpenRS/blob/master/source/net/openrs/util/crypto/Djb2.java
	 * 
	 */
	
	public int hashString(String str, double filesize, int seed)
	{
	    int hash = seed;
	    
	    //seed = 0.5*filesize;
	    
	    for(int i = 0; i < str.length(); i++)
	    {
	    	double correctionfactor = seed/filesize;
	    	//System.out.println(correctionfactor);
	        hash = (int) (str.charAt(i) + ((hash << 5) - hash)); 
	    }

	    if(hash < 0)
	    {
	    	//System.out.println("hash now is " + hash);
	    	hash = -hash;
	    	//System.out.println("hash now is " + hash);
	    }
	    
	    return hash % (int)filesize;
	}
	
	public int linearProbe(int hashCode)
	{
		return hashCode + 1;
	}
	
	
}
