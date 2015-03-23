package page2.segmentTree;

public class GSS1 {

	public static void main(String[] args) {
		int[] arr = { 1, -3, 5, 7, 9, -1 };
		CustomizedSegmentTree segmentTree = new CustomizedSegmentTree(6);
		segmentTree.constructSegmentTree(arr);
		
		
		int num = segmentTree.getMaxSumInRange(1,4);
		
		System.out.println(num);
		
	//	segmentTree.update(21,5,arr);
		
	//	num = segmentTree.getMaxSumInRange(0, 5);
	//	System.out.println(num);

	}
}


class CustomizedSegmentTree {

	int[] tree;
	int maxsize;
	int height;

	final int STARTINDEX = 0;
	final int ENDINDEX;
	final int ROOT = 0;

	public CustomizedSegmentTree(int size) {

		height = (int) (Math.ceil(Math.log(size) / Math.log(2)));
		maxsize = 2 * (int) Math.pow(2, height);
		tree = new int[maxsize];
		ENDINDEX = size - 1;
	}

	private int leftchild(int pos) {
		return 2 * pos + 1;
	}

	private int rightchild(int pos) {
		return 2 * pos + 2;
	}

	private int mid(int start, int end) {
		
		return (start + end)/2;
	}

	private int getSumUtil(int startIndex, int endIndex, int quertStart,
			int queryEnd, int current) {
		
		if(quertStart <= startIndex && queryEnd >= endIndex) {
			return tree[current];
		}
		
		if( endIndex < quertStart || startIndex > queryEnd) {
			return 0;
		}
		
		int mid = mid(startIndex, endIndex);
		return getSumUtil(startIndex, mid, quertStart, queryEnd, leftchild(current))
				 + getSumUtil(mid +1, endIndex, quertStart, queryEnd, rightchild(current));
	}
	
	
	private int getMaxSumInRangeUtil(int startIndex, int endIndex, int quertStart,
			int queryEnd, int current) {
		
		int mid= mid(startIndex,endIndex);
		
		if(startIndex == endIndex) {
			return tree[current];
		}
		
		if(quertStart <= startIndex && queryEnd >= endIndex) {
				
			if( tree[leftchild(current)] >= 0 && tree[rightchild(current)] >= 0) {
				return tree[current];
				
			} else if( tree[leftchild(current)] < 0 && tree[rightchild(current)] < 0) {
				return Math.max(getMaxSumInRangeUtil(startIndex, mid, quertStart, queryEnd, leftchild(current)) 
								, getMaxSumInRangeUtil(startIndex, mid, quertStart, queryEnd, leftchild(current)));				
			
			} else if(  tree[leftchild(current)] < 0 ) {
				return getMaxSumInRangeUtil(mid+1, endIndex, quertStart, queryEnd, rightchild(current));
			
			} else {
				return getMaxSumInRangeUtil(startIndex, mid, quertStart, queryEnd, leftchild(current));
						
			}
			
		}
		
		if( endIndex < quertStart || startIndex > queryEnd) {
			return 0;
		}
		int l=0,r=0;
		if(queryEnd <= mid) {
			return getMaxSumInRangeUtil(startIndex, mid, quertStart, queryEnd, leftchild(current));
		}else if(quertStart >= mid+1) {
			return getMaxSumInRangeUtil(mid +1, endIndex, quertStart, queryEnd, rightchild(current));
		}else {
			// here we have to merge the two parts getting
			// best at left
			// best at right
			// suffix from left
			// prefix from right
			return -1;
		}
	}
	
	
	int getMaxSumInRange(int quertStart, int queryEnd) {
		
		if( quertStart < 0 || quertStart > tree.length) {
			return -1;
		}
		
		return getMaxSumInRangeUtil(STARTINDEX, ENDINDEX, quertStart, queryEnd, ROOT);
		
	}

	private int constructSegmentTreeUtil(int[] arr, int startIndex,
			int endIndex, int current) {
		
		if(startIndex == endIndex) {
			tree[current] = arr[startIndex];
			return tree[current];
		}
		
		int mid = mid(startIndex, endIndex);
		tree[current] = constructSegmentTreeUtil(arr, startIndex, mid, leftchild(current))
						    + constructSegmentTreeUtil(arr, mid +1, endIndex, rightchild(current));
		return tree[current];		
		
	}

	void constructSegmentTree(int[] arr) {

		constructSegmentTreeUtil(arr, STARTINDEX, ENDINDEX, ROOT);
	}


	private void updateUtil(int startIndex, int endIndex, int updateDiff,
			int updatePos, int current) {

		if( updatePos < startIndex || updatePos > endIndex) {
			return;
		}
		
		tree[current] += updateDiff;
		
		if(startIndex != endIndex) {
			int mid = mid(startIndex,endIndex);
			updateUtil(startIndex,mid, updateDiff, updatePos, leftchild(current));
			updateUtil(mid+1,endIndex, updateDiff, updatePos, rightchild(current));
		}
	}


	void update(int update, int updatePos, int[] arr) {
		
		int updateDiff = update - arr[updatePos];
		arr[updatePos] = update;
		updateUtil(STARTINDEX,ENDINDEX,updateDiff,updatePos,ROOT);
	}
}
