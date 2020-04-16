package org.comstudy21.controller;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ListController implements Controller {

	public ListController() {
	}

	@Override
	public void service() {
		Vector dataList = dao.selectAll();
		
		if(dataList != null) {
			dm.setDataVector(dataList, columnNames);
		} else {
			System.out.println("출력할 데이터가 없습니다!");
		}
		
		dm.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				
			}
		});
		
	}
	
	
	
	
}
