package TableFilterTextParser.TableFilterTextParser;


import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.mvel2.MVEL;

public class TableFilterTextParser {
	public static void parseText(final JTable table,final String filterText){
		@SuppressWarnings("unchecked")
		TableRowSorter<TableModel> sorter  = (TableRowSorter<TableModel>) table.getRowSorter();
		if(sorter == null){
			sorter = new TableRowSorter<TableModel>(table.getModel());
		}
		sorter.setRowFilter(new RowFilter<TableModel,Integer>() {
			@Override
			public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
				Map<Object,Object> variables = new HashMap<Object, Object>();
				int numcol = table.getColumnCount();
				for(int i = 0 ; i < numcol ; ++ i ){
					variables.put(table.getColumnName(i), entry.getValue(i));
				}
				try{
					return MVEL.evalToBoolean(filterText, variables);
				}catch(Exception pae){
					return false;
				}
			}
		});
		table.setRowSorter(sorter);
		sorter.sort();
		if (table.getRowCount() == 0) {
			sorter.setRowFilter(null);
			table.setRowSorter(sorter);
		}
	}
}
