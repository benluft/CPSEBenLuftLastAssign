


public class Assign5 
{

	public static void main(String[] args)
	{
		HashingTool hashingTool = new HashingTool();
		
		FileReading reader = new FileReading("inputA5.txt");
		System.out.println("Length of file is "+ reader.getListLength());
		
		String[] inputWords = reader.getWordList();
		
		FileWriting writer = new FileWriting("outputA5.txt");
		
		double percentFull = 0.69;
		
		String[] outputWords = new String[(int) (11134/percentFull)];
		
		for(int j = 0; j < outputWords.length; j++)
		{
			outputWords[j] = "";
		}
		
		System.out.println("Output len " + outputWords.length);
		
		int collisionsCount[] = new int[outputWords.length];
		
		for(int j = 0; j < outputWords.length; j++)
		{
			
			System.out.println("j is "+ j);
			
			int currentCollisions = 0;
			for(int i = 0; i < inputWords.length; i++)
			{
				int hashCode = hashingTool.hashString(inputWords[i], outputWords.length, j);
				
				if(hashCode < 0)
				{
					hashCode = -hashCode;
				}
								
				while(!outputWords[hashCode].equals(""))
				{
					currentCollisions++;

					if(hashCode < (outputWords.length-1))
						hashCode = hashingTool.linearProbe(hashCode);
					else
						hashCode = 0;
				}
				
				//System.out.println("Hashcode is " + hashCode);
				
				outputWords[hashCode] = inputWords[i];
					
			}
			
			
			for(int p = 0; p < outputWords.length; p++)
			{
				//System.out.println("DID WE GET HERE");
				outputWords[p] = "";
			}
			
			collisionsCount[j] = currentCollisions;
			
		}
		
		int minCollisions = 10000000;
		int minCollisionSeed = 0;
		
		for(int k = 0; k < outputWords.length; k++)
		{
			if(collisionsCount[k] < minCollisions)
			{
				minCollisions = collisionsCount[k];
				minCollisionSeed = k;
			}
		}
		
		System.out.println("Collisons Count is "+ minCollisions + " at " + minCollisionSeed);
		
		double loadFactor = ((double)inputWords.length/(double)outputWords.length);
		double averageNumReadsPerRecord = ((double)minCollisions + reader.getListLength())/(double)reader.getListLength();
		double hashEfficiency = (loadFactor/averageNumReadsPerRecord);
		
		System.out.println("Load factor is " + loadFactor);
		System.out.println("Hashing efficiency is " + hashEfficiency);
		
		for(int i = 0; i < inputWords.length; i++)
		{
			writer.writeToFile(inputWords[i]);
		}
		
		writer.closePrintWriter();
	}
	
	
}
