package sample;

public class StringRenderer {
	private static final String NL = System.getProperty("line.separator");
	private StringBuilder bldr = new StringBuilder();
	private Boolean isCreateNewRowActive = Boolean.FALSE;

	public String asString() {
		return bldr.toString();
	}

	public void addCell(String text) {
		if (isCreateNewRowActive) {
			bldr.append(NL);
			isCreateNewRowActive = Boolean.FALSE;
		}
		bldr.append(text);
	}

	public void nextRow() {
		isCreateNewRowActive = Boolean.TRUE;
	}

}
