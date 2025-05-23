package hw7;
public class HW07_4108042003_1 extends LLK{
	int[][] array;
	volatile boolean ans;
	int tNum = 32;
	int len;
	int hashCap;
	Thread[] t = new Thread[tNum];
	
	@Override
	public boolean checkLLK(int[][] array) 
	{
		sort(array);	// merge sort: O(NlogN)
		
		ans = false;
		this.array = array;
		len = array.length;
		hashCap = 1 << ((int) Math.ceil(Math.log10((double) len) / 0.3010));
		
		if (len > tNum*2) 
		{
			MultiThread[] mt = new MultiThread[tNum];
			
			for(int tr=0; tr<tNum; tr++) 
			{
				mt[tr] = new MultiThread(tr);
				mt[tr].start();
			}
			
			try
			{
	            for(int tr=0; tr<tNum; tr++) 
	            {
	                mt[tr].join();
	            }
	        }
			catch(InterruptedException e) {}

			return ans;
		} 
		else 
		{
			int deltaX, deltaY,gcd;
			HashMap m = new HashMap(hashCap);
			
	        for(int i=0; i<len; i++)
	        {
	            for(int j=i+1; j<len; j++)
	            {
	                deltaX = array[i][0] - array[j][0];
	                deltaY = array[i][1] - array[j][1];

	                gcd = gcd(deltaY, deltaX);

	                
	                deltaX = (deltaX / gcd);
	                deltaY = (deltaY / gcd);
	                if(deltaX < 0)	// we prefer that x is positive
	                {
	                    deltaX = ~deltaX + 1;
	                    deltaY = ~deltaY + 1;
	                }

	                if(m.containOrPut(deltaX, deltaY))	// if it is already store in hashmap, return true.
	                {
	                    return true;
	                }
	            }
	            m.reset();
	        }

	        return false;
		}
	}
	
	class MultiThread extends Thread 
	{
    	int tr;
    	
    	public MultiThread(int tr) 
    	{
    		this.tr = tr;
    	}
    	
    	public void run()
    	{
    		int start = len * tr / tNum;
			int end = len * (tr + 1) / tNum;
			HashMap m = new HashMap(hashCap);

			int deltaX, deltaY,gcd;
			for (int i = start; i < end && !ans; i++) 
			{
//				System.out.println("point "+i);
				for (int j = i + 1; j < len && !ans; j++) 
				{
					deltaX = array[i][0] - array[j][0];
	                deltaY = array[i][1] - array[j][1];

	                // get fraction in lowest term of deltaX / deltaY 
	                gcd = gcd(deltaY, deltaX);
	                deltaX = (deltaX / gcd);
	                deltaY = (deltaY / gcd);
	                
	                if(deltaX < 0)	// we prefer that x is positive
	                {
	                    deltaX = ~deltaX + 1;
	                    deltaY = ~deltaY + 1;
	                }

	                if(m.containOrPut(deltaX, deltaY))	// if it is already store in hashmap, return true.
	                {
	                    ans = true;
	                }
				}
				m.reset();	// reset hashmap when one point is end;
			}
			
//			System.out.println("thread "+tr+" end!");
    	}
    }

	private class HashMap
    {
        class Entry
        {
            public int key1;
            public int key2;
            public Entry next;
        }

        private int cap;
        private Entry[] list;

        HashMap(int size)
        {
            this.cap = size;
            Entry[] newEntry = new Entry[this.cap];
            this.list = newEntry;
        }

        final public void reset()
        {
            Entry[] newEntry = new Entry[this.cap];
            this.list = newEntry;
        }

        final public boolean containOrPut(int key1, int key2)
        {
            // & (this.cap - 1) is equivalent to % this.cap when base of this.cap is 2
            int index = ((key1 + key2) & 0x7fffffff) & (this.cap -1);
            for(Entry current = list[index]; current!=null; current=current.next)
            {
                if(current.key1 == key1 && current.key2 == key2)
                {
                    return true;
                }
            }
            Entry newEntry = new Entry();
            newEntry.key1  = key1;
            newEntry.key2  = key2;
            newEntry.next = list[index];
            list[index] = newEntry;
            return false;
        }
    }
	
	public int gcd(int a, int b)
    {
        return b==0 ? a : gcd(b, a%b);
    }
	
	public static void sort(int[][] a)
	{
		int[][] aux = new int[a.length][2];
		sort(a, aux, 0, a.length-1);
	}
    
    private static void sort(int[][] a, int[][] aux, int lo, int hi)
	{
		if(hi <= lo) return;
		int mid = lo + (hi-lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
    
    private static void merge(int[][] a, int[][] aux, int lo, int mid, int hi)
	{
		for(int k = lo; k <= hi; k++) aux[k] = a[k];
		
		int i = lo, j = mid+1;
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid) a[k] = aux[j++];
			else if(j > hi) a[k] = aux[i++];
			else if(less(aux[i], aux[j])) a[k] = aux[i++];
			else a[k] = aux[j++];
		}
	}
    
    private static boolean less(int[] i, int[] j)
	{
		if(i[0] < j[0]) return true;
		else if(i[0] > j[0]) return false;
		else
			if(i[1] < j[1]) return true;
			else if(i[1] > j[1]) return false;
			else return true;
	}
}
