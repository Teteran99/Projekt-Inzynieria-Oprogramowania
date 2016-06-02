import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ClearList implements ActionListener {
	private DefaultListModel model = new DefaultListModel();
	private JList list = new JList(model);
	
	public ClearList(DefaultListModel modelRef,JList listRef){
		model=modelRef;
		list=listRef;
		
	}

    public void actionPerformed(ActionEvent e) {
    			model.removeAllElements();		
    }
}