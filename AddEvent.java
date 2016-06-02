import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;

class AddEvent extends JDialog implements ActionListener {

	    JPanel panel = new JPanel();
	    JDialog dialog = new JDialog();
	    JFrame frame = new JFrame();
    	private DefaultListModel model = new DefaultListModel();
    	private JList list = new JList(model);
    	private JApplet applet =new JApplet();


    	JLabel lTitle,lDataStart,lDataStop,lTimeStart,lTimeStop,lDescription;
    	JTextField tTitle;
    	JTextArea tDescription;
    	JButton bSave = new JButton("SAVE");
		private String timeStart="00:00";
		private String timeStop="00:00";
		
		String[] godziny = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		String[] minuty = {"00","05","10","15","20","25","30","35","40","45","50","55"};
		
		JComboBox hStart =new JComboBox<>(godziny);
		JComboBox hStop =new JComboBox<>(godziny);
		JComboBox mStart =new JComboBox<>(minuty);
		JComboBox mStop =new JComboBox<>(minuty);
		JDateChooser dataStartChoose = new JDateChooser();
		JDateChooser dataStopChoose = new JDateChooser();
		
		private String dataStart;
		private String dataStop;
    	
		JTextField teeext= new JTextField();
    	
    	
    	
    	
    	
        
    	public AddEvent(JApplet appletRef, DefaultListModel modelRef, JList listRef) {
    		
    		applet=appletRef;
    		model=modelRef;
    		list=listRef;
    		
    		
    		setVisible(true);
    		setBounds(35, 90, 415, 370);
    		setResizable(false);
    		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	

    		panel.setLayout(null);
    		panel.setBounds(5, 5, 100, 100);


    		bSave.setBounds(100, 270, 200, 50);
    		bSave.addActionListener(this);
    		panel.add(bSave);





    		/////////////////////////////LABELS  LABELS LABELS LABELS LABELS /////////////////////////////////////////
    		lTitle = new JLabel("EVENT TITLE ");
    		lTitle.setBounds(155,5, 80, 20);
    		panel.add(lTitle);

    		lDescription = new JLabel("DESCRIPTION");
    		lDescription.setBounds(155, 120, 80, 20);
    		panel.add(lDescription);


    		/////////////////////////////POLA  POLA POLA POLA POLA /POLA////POLAPOLA///POLA///////////////////////////
    		tTitle=new JTextField();
    		tTitle.setBounds(25, 25, 350, 20);
    		tTitle.setText(null);
    		tTitle.setDocument(new JTextFieldLimit(50));
    		panel.add(tTitle);

    		tDescription=new JTextArea();
    		tDescription.setBounds(25, 140, 350, 120);
    		tDescription.setLayout(null);
    		tDescription.setText(null);
    		tDescription.setAutoscrolls(true);
    		tDescription.setLineWrap(true);
    		tDescription.setDocument(new JTextFieldLimit(254));
    		Border title = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    		tDescription.setBorder(title);

    		panel.add(tDescription);


    		lDataStart = new JLabel("START DATE:");
    		lDataStart.setBounds(24, 63, 80, 20);
    		panel.add(lDataStart);

    		lDataStop = new JLabel("STOP DATE:");
    		lDataStop.setBounds(24, 93, 80, 20);
    		panel.add(lDataStop);

    		dataStartChoose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    		dataStartChoose.setBounds(new Rectangle(100, 65, 95, 20));
    		dataStartChoose.setDateFormatString("dd/MM/yyyy");
    		dataStartChoose.getDateEditor().getUiComponent().setBackground(Color.WHITE);
    		dataStartChoose.getDateEditor().getUiComponent().setFocusable(false);
    		panel.add(dataStartChoose);

    		dataStopChoose.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    		dataStopChoose.setBounds(new Rectangle(100, 95, 95, 20));
    		dataStopChoose.getDateEditor().getUiComponent().setBackground(Color.WHITE);
    		dataStopChoose.getDateEditor().getUiComponent().setFocusable(false);;
    		dataStopChoose.setDateFormatString("dd/MM/yyyy");
    		panel.add(dataStopChoose);


    		hStart.setBounds(270, 65, 50, 20);
    		hStart.setBackground(Color.WHITE);
    		panel.add(hStart);


    		hStop.setBounds(270, 95, 50, 20);
    		hStop.setBackground(Color.WHITE);
    		panel.add(hStop);


    		mStart.setBounds(320, 65, 50, 20);
    		mStart.setBackground(Color.WHITE);
    		panel.add(mStart);


    		mStop.setBounds(320, 95, 50, 20);
    		mStop.setBackground(Color.WHITE);
    		panel.add(mStop);

    		lTimeStart = new JLabel("START TIME:");
    		lTimeStart.setBounds(197, 64, 74, 20);
    		panel.add(lTimeStart);

    		lTimeStop = new JLabel("STOP TIME:");
    		lTimeStop.setBounds(202, 94, 70, 20);
    		panel.add(lTimeStop);


    		timeStart= hStart.getSelectedItem().toString();

    		timeStop= hStop.getSelectedItem().toString();

    		add(panel);
    		
        }






		@Override
		public void actionPerformed(ActionEvent e)
    	{
    		Date data = new Date();
    		Toolkit tk = Toolkit.getDefaultToolkit();
    		
    		String kontrolerDataStart =((JTextField)dataStartChoose.getDateEditor().getUiComponent()).getText();
    		String kontrolerDataStop =((JTextField)dataStopChoose.getDateEditor().getUiComponent()).getText();;
    		
    	
  
    		
    		
    		
    		if(tTitle.getText().length()>0)
    		{
    			if((kontrolerDataStart.length()>0) && (kontrolerDataStop.length()>0))
    			{
    				if(data.compareTo(dataStartChoose.getDate())!=1)
    				{
    					if(dataStartChoose.getDate().compareTo(dataStopChoose.getDate())==-1)
    					{
    						timeStart=(String) hStart.getSelectedItem()+":"+mStart.getSelectedItem();
    						timeStop=(String) hStop.getSelectedItem()+":"+mStop.getSelectedItem();
    						dataStart = new SimpleDateFormat("EE dd/MM/yy").format(dataStartChoose.getDate());
    						dataStop = new SimpleDateFormat("EE dd/MM/yy").format(dataStopChoose.getDate());
    						int index=model.size();
    						Wydarzenie newEvent=new Wydarzenie(tTitle.getText(),dataStart,dataStop,timeStart,timeStop,tDescription.getText());
    						model.insertElementAt(newEvent, index);
    						tTitle.requestFocusInWindow();
    						tTitle.setText("");
    						this.dispose();
    						applet.setEnabled(true);
    						JOptionPane.showMessageDialog(null, "New Event has been added!", "ADDED",JOptionPane.INFORMATION_MESSAGE);
    					}
    					else if(dataStartChoose.getDate().compareTo(dataStopChoose.getDate())==1)
    					{
    						
    						tk.beep();
    						JOptionPane.showMessageDialog(null, "Wrong Dates.", "Warning",JOptionPane.WARNING_MESSAGE);
    					}
    				}
    				else
    				{
    					
    					tk.beep();
    					JOptionPane.showMessageDialog(null, "Wrong Dates!", "Warning",JOptionPane.WARNING_MESSAGE);
    				}
    			}
    			else
    			{
    				tk.beep();
					JOptionPane.showMessageDialog(null, "Input Dates!", "Warning",JOptionPane.WARNING_MESSAGE);
    			}
    		}
    		else
    		{
    			tk.beep();
    			JOptionPane.showMessageDialog(null, "Event Title is Epmty!", "Warning",JOptionPane.WARNING_MESSAGE);	
    		}
    		applet.setEnabled(true);
    	} 
}
    		