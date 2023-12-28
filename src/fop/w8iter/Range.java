package fop.w8iter;

import java.util.Iterator;

public class Range implements Iterable<Integer>
{
	private final int begin;
	private final int end ;
	private final int stride;
	private int current;
	
	 public Range(final int _begin,final int _end,final int _stride)
	 {
		 begin = _begin;
		 end = _end;
		 if(_stride <= 0 )
		 {
			 Util.badArgument("Stride can not be negative or 0");			 
		 }
		 
		 if(begin > end)
		 {
			 stride = - _stride;
		 }
		 else if(begin < end)
		 {
			 stride = _stride; 
		 }
		 else
		 {
			 stride = 0;
		 }
			 
			 current = _begin;
			 
	 }
	 
	 public Range(int _begin, int _end)
	 {
		 begin = _begin;
		 end = _end;
		 
		 if(begin > end)
		 {
			 stride = - 1;
		 }
		 else if(begin < end)
		 {
			 stride = 1; 
		 }
		 else
		 {
			 stride = 0;
		 }
		 
		 current = _begin;
		 
	 }
	 

	@Override
	public Iterator<Integer> iterator() {
		 
		return new Iterator<Integer>() {
			
			 public Integer next()
			 {
				 if(hasNext())
				 {
					 int temp = current;
					 current += stride;
					 return temp;

				 }
				 else
				 {
					 Util.noSuchElement("There are no more Integers in the Range");
					 return 0;
				 }
			 }
			 
			 public boolean hasNext()
			 {
				 if(stride > 0)
				 {
					 if(current> end)
					 {
						 return false;
					 }
				 }
				 else if(stride < 0)
				 {
					 if(current < end)
					 {
						 return false;
					 }
				 }
				 else
				 {
					 return false;
				 }
				 
				 return true;
			 }
			
		};
		 
	}
	 	
}
