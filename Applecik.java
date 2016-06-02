
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Applecik extends JApplet implements  ListSelectionListener,ActionListener
{


	private JDialog jdialog= new JDialog();
	private JApplet applet=this;
	
	private JButton newEvent =new JButton();
	private JButton generateFile=new JButton();
	private JButton loadFile=new JButton();
	private JButton clear=new JButton();
	private JLabel lEvent,lInfo;
	private DefaultListModel<Wydarzenie> model = new DefaultListModel<Wydarzenie>();
	private JList list = new JList(model);
	private JScrollPane pane = new JScrollPane(list);
	private JTextArea description = new JTextArea();
	private JButton removeButton = new JButton("Remove Element");
	private JButton editButton = new JButton("Edit Element");
	
	
	JLabel version = new JLabel("Lambda 2.0");
	
	
    int count = 0;
	

	
	public void init()
	{	
		 
		
		 
		 
		 
		 
		 
		 applet.setSize(830, 350);
		 applet.setBackground(Color.WHITE);
		 Border border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		 setBorder(border);
		 
		 version.setBounds(800,300,90,20);
		 add(version);
		 
		 setLayout(null);

		 lInfo=new JLabel("                   Date Start                                                   Date Stop                           Title");
		 lInfo.setBounds(25, 50, 595, 20);
		 
		 add(lInfo);
		 
		
		removeButton.setBounds(100, 280, 150, 50);
		removeButton.addActionListener(new RemoveButton(model,list));
		removeButton.setEnabled(false);
		
		editButton.setBounds(300, 280, 150, 50);
		editButton.addActionListener(this);
		editButton.setEnabled(false);
		

		Wydarzenie eee = new Wydarzenie("dsad", "dsadsada", "dadasdas", "adasdadas", "name", "name");
		Wydarzenie eee2 = new Wydarzenie("222dsad", "d222sadsada", "dadasd22222as", "ada2222sdadas", "n2ame", "na2me");
		model.addElement(eee);
		model.addElement(eee2);
		
		pane.setBounds(25, 70, 495, 200);
		
		list.setFont(new Font("Courier New", Font.ITALIC, 15));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(5);
		
	
		JLabel lDescription = new JLabel("Description");
		lDescription.setBounds(640,50,90,20);
		
		description.setBounds(550,70,250,200);
		Border title = BorderFactory.createEtchedBorder();
		description.setEditable(false);
		description.setBorder(title);
		description.setAutoscrolls(true);
		description.setLineWrap(true);
		
		add(lDescription);
		add(description);
		add(pane);
	    add(removeButton);
	    add(editButton);


		 
		 
		 newEvent = new JButton("New Event");
		 newEvent.addActionListener(this);
		 newEvent.setBounds(25, 5, 120, 30);
		 
		 generateFile = new JButton("Generate File");
		 generateFile.setBounds(150, 5, 120, 30);
		 
		 loadFile = new JButton("Load File");
		 loadFile.setBounds(275, 5, 120, 30);
		 
		 clear = new JButton("Clear List");
		 clear.addActionListener(new ClearList(model,list));
		 clear.setBounds(400, 5, 120, 30);
		 


		 add(newEvent);
		 add(generateFile);
		 add(loadFile);
		 add(clear);
	 }

	private void setBorder(Border border) {
		// TODO Auto-generated method stub
	}

	//////////////////////////VALUE CHANGED//////VALUE CHANGED////////VALUE CHANGED//////////////////
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
            //No selection, disable buttons
            	removeButton.setEnabled(false);
            	editButton.setEnabled(false);
            	
            } else {
            //Selection, enable the buttons
            	removeButton.setEnabled(true);
            	editButton.setEnabled(true);
            	int index=list.getSelectedIndex();
            	description.setText(((Wydarzenie) model.getElementAt(index)).getDescription());
            } 
        }
	}
	
	
	public void destroy(){
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newEvent){
			new AddEvent(applet,model,list);
			//setEnabled(false);
		}else if(e.getSource()==editButton){
			new EditPanel(applet,model,list);
			//setEnabled(false);
		}
		else if(e.getSource()==removeButton)
			new RemoveButton(model,list);
		else if(e.getSource()==clear)
			new ClearList(model,list);
	}

	



}
