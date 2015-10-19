/**
 * @createdOn 28-Sep-2015 11:50:54 am
 * @qualifiedName GeekyAlgoJava/linkedlists.test/TestStrings.java
 * @author ketandikshit
 * @typeName TestStrings
 * @year 2015
 */
package linkedlists.test;

/**
 * @author ketandikshit
 * @createdOn 28-Sep-2015 11:50:54 am
 * @qualifiedName GeekyAlgoJava/linkedlists.test/TestStrings.java
 * @year 2015
 */
public class TestStrings {

	public void test(String str1) throws Exception {
		int[][] arr = new int[str1.length()][str1.length()];
		int maxSoFar = 0;
		for (int i = 0; i < str1.length(); i++) {
			for (int j = i + 1; j < str1.length(); j++) {
				System.out.println(i + "," + j);
				int numOfDistinctChars = str1.codePointCount(i, j);
				System.out.println(numOfDistinctChars);
				if (numOfDistinctChars > maxSoFar) {
					maxSoFar = numOfDistinctChars;
				}
				arr[i][j] = numOfDistinctChars;
			}
		}
	}

	/**
	 * @createdOn 28-Sep-2015 11:50:56 am
	 * @author ketandikshit
	 * @param args
	 */
	public static void main(String[] args) {
		TestStrings test = new TestStrings();
		try {
			test.test("abcddbcae");
		} catch (Exception ex) {
			System.err.println(ex);
			ex.printStackTrace();
		}

	}

}
