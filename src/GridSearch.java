import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class GridSearch {

	public static void main(String[] args) {
		try {
			setTestInput();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int numberOfTestCases = Integer.valueOf(br.readLine());

			int linesOfG = 0;
			int columnsOfG = 0;
			int linesOfP = 0;
			int columnsOfP = 0;

			for (int testCaseIndex = 0; testCaseIndex < numberOfTestCases; testCaseIndex++) {
				String[] sizeOfG = br.readLine().split(" ");
				linesOfG = Integer.valueOf(sizeOfG[0]);
				columnsOfG = Integer.valueOf(sizeOfG[1]);

				String[] g = new String[linesOfG];
				for (int i = 0; i < linesOfG; i++) {
					g[i] = br.readLine();
				}

				String[] sizeOfP = br.readLine().split(" ");
				linesOfP = Integer.valueOf(sizeOfP[0]);
				columnsOfP = Integer.valueOf(sizeOfP[1]);

				String[] p = new String[linesOfP];
				for (int i = 0; i < linesOfP; i++) {
					p[i] = br.readLine();
				}

				gridSearch(g, p, columnsOfG, columnsOfP);
			}
		} catch(IOException io) {
			io.printStackTrace();
		}
	}

	private static void gridSearch(String[] g, String[] p, int columnsOfG, int columnsOfP) {
		int topLeftNumber = Character.getNumericValue(p[0].charAt(0));
		for (int i = 0; i < g.length-p.length+1; i++) {
			for (int j = 0; j < columnsOfG-columnsOfP+1; j++) {
				if (Character.getNumericValue(g[i].charAt(j)) == topLeftNumber) {
					boolean differentValue = false;
					int currentLineOfG = i;
					int currentColumnOfG = j;
					for (int l = 0; l < p.length; l++) {
						for (int c = 0; c < columnsOfP; c++) {
							if (Character.getNumericValue(p[l].charAt(c)) != Character.getNumericValue(g[currentLineOfG].charAt(currentColumnOfG++))) {
								differentValue = true;
								break;
							}
						}

						if (differentValue) {
							break;
						} else if (l == p.length-1) {
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

	private static void setTestInput() throws UnsupportedEncodingException {
		String quebraLinha = System.getProperty("line.separator");

		StringBuffer buffer = new StringBuffer();
		buffer.append("2").append(quebraLinha)
		.append("10 10").append(quebraLinha)
		.append("7283455864").append(quebraLinha)
		.append("6731158619").append(quebraLinha)
		.append("8988242643").append(quebraLinha)
		.append("3830589324").append(quebraLinha)
		.append("2229505813").append(quebraLinha)
		.append("5633845374").append(quebraLinha)
		.append("6473530293").append(quebraLinha)
		.append("7053106601").append(quebraLinha)
		.append("0834282956").append(quebraLinha)
		.append("4607924137").append(quebraLinha)
		.append("3 4").append(quebraLinha)
		.append("9505").append(quebraLinha)
		.append("3845").append(quebraLinha)
		.append("3530").append(quebraLinha)
		.append("15 15").append(quebraLinha)
		.append("400453592126560").append(quebraLinha)
		.append("114213133098692").append(quebraLinha)
		.append("474386082879648").append(quebraLinha)
		.append("522356951189169").append(quebraLinha)
		.append("887109450487496").append(quebraLinha)
		.append("252802633388782").append(quebraLinha)
		.append("502771484966748").append(quebraLinha)
		.append("075975207693780").append(quebraLinha)
		.append("511799789562806").append(quebraLinha)
		.append("404007454272504").append(quebraLinha)
		.append("549043809916080").append(quebraLinha)
		.append("962410809534811").append(quebraLinha)
		.append("445893523733475").append(quebraLinha)
		.append("768705303214174").append(quebraLinha)
		.append("650629270887160").append(quebraLinha)
		.append("2 2").append(quebraLinha)
		.append("99").append(quebraLinha)
		.append("99");
		
		ByteArrayInputStream bais = new ByteArrayInputStream(buffer.toString().getBytes("UTF-8"));
		System.setIn(bais);
	}

}
