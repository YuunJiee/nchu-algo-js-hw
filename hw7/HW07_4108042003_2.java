package hw7;

public class HW07_4108042003_2 extends LLK{

	class Entry  // class for hashmap entry
	{
		final double slope;
		final Entry next;

		public Entry(final double slope, final Entry next) 
		{
			this.slope = slope;
			this.next = next;
		}
	}

	final byte log_tNum = 5;
	final Entry[][] HashTable = new Entry[1 << log_tNum][];
	final Thread[] T = new Thread[HashTable.length - 1];
	volatile boolean result;

	public boolean checkLLK(int[][] array) 
	{
		result = false;

		final int end = array.length - 1, tLen = T.length, freq = HashTable.length, bNum = 1 << 32 - Integer.numberOfLeadingZeros(end), B = bNum - 1;

		for (byte ti = 0; ti < tLen; ++ti) 
		{
			final byte t = ti;
			T[t] = new Thread(() -> {
				for (int i = end - t, j, bucket; i > -1; i -= freq) 
				{
					for (HashTable[t] = new Entry[bNum], j = i - 1; j > -1;) 
					{
						final double slope = (array[i][1] - array[j][1]) / (double) (array[i][0] - array[j--][0]);

						bucket = Double.hashCode(slope) & B & 0x7fff_ffff;

						for (Entry Pivot = HashTable[t][bucket]; Pivot != null; Pivot = Pivot.next) 
						{
							if (Pivot.slope == slope)
								result = true;
							if (result)
								return;
						}

						HashTable[t][bucket] = new Entry(slope, HashTable[t][bucket]);

						if (result)
							return;
					}
					if (result)
						return;
				}
			});
			T[t].setDaemon(true);
			T[t].start();
			if (result)
				return true;
		}

		for (int i = end - tLen, j, bucket; i > -1; i -= freq) 
		{
			for (HashTable[tLen] = new Entry[bNum], j = i - 1; j > -1;) 
			{
				final double slope = (array[i][1] - array[j][1]) / (double) (array[i][0] - array[j--][0]);
				bucket = Double.hashCode(slope) & B & 0x7fff_ffff;
				for (Entry Pivot = HashTable[tLen][bucket]; Pivot != null; Pivot = Pivot.next)
					if (Pivot.slope == slope || result)
						return true;
				HashTable[tLen][bucket] = new Entry(slope, HashTable[tLen][bucket]);
			}
			if (result)
				return true;
		}

		try 
		{
			for (final Thread t : T) 
			{
				if (result)
					return true;
				t.join();
			}
		} 
		catch (final InterruptedException e) {}
		return result;
	}
}
