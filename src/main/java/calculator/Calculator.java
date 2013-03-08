package calculator;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
	int count = 0;
	
	public String divide(String a, String b, Integer... precision) {
		int countNegative = 0;
		int aInt = Integer.parseInt(a);
		int bInt = Integer.parseInt(b);
		twoNeg(a, b, countNegative);
		int p = (precision.length == 0) ? 10 : precision[0];
		if(bInt==0)throw new DivideByZeroException("You can't  divide by zero!");
		return encodeToString(countSubstraction(aInt, bInt, p));
		
	}

	List<Integer> countSubstraction(int a, int b, int precision) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int whole = 0;
		int rest = a;
		while ((rest != 0) && (precision != (ar.size() - 1))) {
			while (rest >= b) {
				rest = rest - b;
				whole++;
			}
			ar.add(whole);
			whole = 0;
			rest = rest * 10;
		}
		return ar;
	}

	String encodeToString(List<Integer> ar) {
		String s = "";
		for (int i = 0; i < ar.size(); i++) {
			s = s + ar.get(i);
			if (i == 0)
				s = s + ".";
		}
		return s;
	}

	public int divideInt(String a, String b) {
		int countNegative = 0;
		int aInt;
		int bInt;
		if (a.contains("-") && b.contains("-")) {
			aInt = Integer
					.parseInt(a.substring(a.indexOf("-") + 1, a.length()));
			bInt = Integer
					.parseInt(b.substring(a.indexOf("-") + 1, b.length()));
			countNegative = 2;

			div(aInt, bInt);

		}

		if (!a.contains("-") && b.contains("-")) {
			aInt = Integer.parseInt(a);
			bInt = Integer
					.parseInt(b.substring(b.indexOf("-") + 1, b.length()));
			countNegative = 1;

			div(aInt, bInt);

		}

		if (a.contains("-") && !b.contains("-")) {
			aInt = Integer
					.parseInt(a.substring(a.indexOf("-") + 1, a.length()));
			bInt = Integer.parseInt(b);
			countNegative = 1;

			div(aInt, bInt);

		}

		if (!a.contains("-") && !b.contains("-")) {
			aInt = Integer.parseInt(a);
			bInt = Integer.parseInt(b);
			countNegative = 2;

			div(aInt, bInt);

		}

		int neg = -count;
		if (countNegative % 2 == 0) {
			return count;
		} else {
			System.out.println(neg);
			return neg;
		}

	}
	
	
	public int twoNeg(String a, String b, int countNegative) {
		if (a.contains("-") && b.contains("-")) {
			int aInt = Integer
					.parseInt(a.substring(a.indexOf("-") + 1, a.length()));
			int bInt = Integer
					.parseInt(b.substring(a.indexOf("-") + 1, b.length()));
			countNegative = 2;


		} 
		return countNegative;

	}

	public void div(int aInt, int bInt) {
		while (aInt != 0) {
			aInt = aInt - bInt;
			if (aInt < bInt) {
				count++;
				break;
			}
			count++;
		}
	}

	public String divideS(String a, String b) {
		int aInt = Integer.parseInt(a);
		int bInt = Integer.parseInt(b);
		int count = 0;
		int left = 0;
		while (aInt != 0) {
			aInt = aInt - bInt;
			if (aInt < bInt) {
				count++;
				left = aInt;
				break;
			}
			count++;
		}
		String s = "";
		if (left > 0) {
			s = count + "(" + left + ")";
		} else {
			s = count + "";
		}
		return s;
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int add(String a, String b) {
		int aAdd = Integer.parseInt(a);
		int bAdd = Integer.parseInt(b);
		int c = aAdd + bAdd;
		return c;
	}

	public int sub(String a, String b) {
		int aAdd = Integer.parseInt(a);
		int bAdd = Integer.parseInt(b);
		int c = aAdd - bAdd;
		return c;
	}

	public int mult(String a, String b) {
		int am = Integer.parseInt(a);
		int bm = Integer.parseInt(b);
		for (int i = 0; i < bm-1; i++) {
			am += am;
		}
		return am;
	}
}
