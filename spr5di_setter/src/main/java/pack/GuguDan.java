package pack;

public class GuguDan {
	public int[] numberCalc(int dan) {
		int[] result = new int[9]; //9개까지 나오게
		
		for (int i = 0; i < result.length; i++) {
			result[i] = dan * (i+1);
		}
		
		return result;
	}
}
