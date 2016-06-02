import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class RemoveButton implements ActionListener {
	private DefaultListModel model = new DefaultListModel();
	private JList list = new JList(model);
	
	public RemoveButton(DefaultListModel modelRef,JList listRef){
		model=modelRef;
		list=listRef;
		
	}
	
        public void actionPerformed(ActionEvent e) {
            int index = list.getSelectedIndex();
            model.remove(index);

                if (index == model.getSize()) {
                    index--;
                }

            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }
        
    }