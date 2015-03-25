package TableFilterTextParser.TableFilterTextParser;

import javax.swing.SortOrder;

public class CustomeRowSortKey {
	private String expression;
	private SortOrder sortOrder;
	public CustomeRowSortKey(String expression,SortOrder sortOrder){
		this.expression = expression;
		this.sortOrder = sortOrder;
	}
	public String getExpression() {
		return expression;
	}
	public SortOrder getSortOrder() {
		return sortOrder;
	}
}
