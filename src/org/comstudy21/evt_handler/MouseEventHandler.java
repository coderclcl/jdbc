package org.comstudy21.evt_handler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTable;

import org.comstudy21.resource.R;
import org.comstudy21.view.ListView;

public class MouseEventHandler implements MouseListener, R {

	ListView target = null;
	public MouseEventHandler(ListView target) {
		this.target = target;
	}
	
	public MouseEventHandler() {
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(e.getSource() instanceof JTable) {
			JTable table = (JTable)e.getSource();
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			
			nameField.setText(dm.getValueAt(row, 1).toString());
			emailField.setText(dm.getValueAt(row, 2).toString());
			phoneField.setText(dm.getValueAt(row, 3).toString());
			noLabel.setText("no: "+dm.getValueAt(row, 0).toString());
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
}
