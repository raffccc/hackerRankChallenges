package amazon;

public class Solution {
	
	public static void main(String[] args) {
		int numberOfTestCases = Integer.valueOf(args[0]);
		
		int linesOfG = 0;
		int columnsOfG = 0;
		int linesOfP = 0;
		int columnsOfP = 0;
		
		int indexBeginningTestCase = 1;
		for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; testCaseIndex++) {
			indexBeginningTestCase += linesOfG + 1 + linesOfP;
			
			String[] sizeOfG = args[indexBeginningTestCase].split("  ");
			linesOfG = Integer.valueOf(sizeOfG[0]);
			columnsOfG = Integer.valueOf(sizeOfG[1]);
			
			String[] sizeOfP = args[indexBeginningTestCase+linesOfG].split("  ");
			linesOfP = Integer.valueOf(sizeOfP[0]);
			columnsOfP = Integer.valueOf(sizeOfP[1]);
			
			int firstLineOfP = indexBeginningTestCase+linesOfG+1;
			int lastLineOfP = firstLineOfP+linesOfP;
			
			int topLeftNumber = Integer.valueOf(args[firstLineOfP].charAt(0));
			for (int i = indexBeginningTestCase+1; i <= linesOfG-linesOfP+1; i++) {
				for (int j = 0; j <= columnsOfG-columnsOfP; j++) {
					if (Integer.valueOf(args[i].charAt(j)) == topLeftNumber) {
						boolean differentValue = false;
						int currentLineOfG = i;
						int currentColumnOfG = j;
						for (int l = firstLineOfP; l <= lastLineOfP; l++) {
							for (int c = 0; c < columnsOfP; c++) {
								if (Integer.valueOf(args[l].charAt(c)) != Integer.valueOf(args[currentLineOfG].charAt(currentColumnOfG++))) {
									differentValue = true;
									break;
								}
							}
							
							if (differentValue) {
								break;
							} else if (l == lastLineOfP) {
								System.out.println("YES");
								return;
							} else {
								currentColumnOfG = j;
								currentLineOfG++;
							}
						}
					}
				}
			}
			
			System.out.println("NO");
		}
		
		
	}

}
