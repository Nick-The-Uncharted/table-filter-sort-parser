package TableFilterTextParser.TableFilterTextParser;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.event.RowSorterEvent;
import javax.swing.table.TableModel;

public class TableSortTextParser {
	@SuppressWarnings("unchecked")
	public static void ParserText(JTable table,String sortText,SortOrder sortOrder){
		CustomRowSorter<TableModel> sorter;
		table.setRowSorter(null);
		RowSorter<? extends TableModel> temp = table.getRowSorter();
		if((temp != null)&&(temp instanceof CustomRowSorter<?> )){
			sorter = (CustomRowSorter<TableModel>)table.getRowSorter();
		}else{
			sorter = new CustomRowSorter<TableModel>(table.getModel());
		}
		ArrayList<CustomeRowSortKey> keyList = new ArrayList<CustomeRowSortKey>();
		sorter.setSortKeys(new ArrayList<SortKey>());
		keyList.add(new CustomeRowSortKey(sortText,sortOrder));
		sorter.setRowSortKeys(keyList);
		table.setRowSorter(sorter);
		sorter.sort();
		table.sorterChanged(new RowSorterEvent(sorter, RowSorterEvent.Type.SORT_ORDER_CHANGED, null));
	}
}
