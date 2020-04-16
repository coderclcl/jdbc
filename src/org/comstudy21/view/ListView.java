package org.comstudy21.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.comstudy21.evt_handler.MouseEventHandler;
import org.comstudy21.resource.R;

public class ListView extends View implements R {
	
	DefaultTableModel dm;
	JTable table;
	
	public void setTableModel(DefaultTableModel dm) {
		this.dm = dm;
	}
	
	public ListView(DefaultTableModel dm, Object[] colNames) {
		this.dm = dm;
		for(int i=0; i<colNames.length; i++) {
			columnNames.add(colNames[i].toString());
		}
		dm.setColumnIdentifiers(colNames);
		init();
		start();
	}

	
	

	@Override
	public void init() {
		table = new JTable(dm);
		JScrollPane scrollPane = new JScrollPane(table);
		
		add(scrollPane);
		
		
	}
	@Override
	public void start() {
		MouseEventHandler handler = new MouseEventHandler();
		table.addMouseListener(handler);
	}
	
	
	
	
	
	

}
