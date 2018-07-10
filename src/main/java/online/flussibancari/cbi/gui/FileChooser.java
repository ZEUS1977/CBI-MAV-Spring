package online.flussibancari.cbi.gui;
 
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import online.flussibancari.cbi.mav.beans.Result;
import online.flussibancari.cbi.mav.consts.Constants;
import online.flussibancari.cbi.mav.filler.CodiceFisso14Filler;
import online.flussibancari.cbi.mav.service.CBIMAVFlatService;
import online.flussibancari.cbi.mav.service.CBIMAVFlatServiceImpl;
 
/*
 * FileChooserDemo.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */
public class FileChooser extends JPanel
                             implements ActionListener {
    
	private static final long serialVersionUID = 3435272260622015235L;
	private static final Logger logger = LoggerFactory.getLogger(FileChooser.class);
	
    JButton openButton, saveButton;
    JTextArea jout;
    JFileChooser fc;
 
    public FileChooser() {
        super(new BorderLayout());
 
        //Create the log first, because the action listeners
        //need to refer to it.
        jout = new JTextArea(5,80);
        jout.setMargin(new Insets(5,5,5,5));
        jout.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(jout);

        //Create a file chooser
        fc = new JFileChooser();
 
        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
 
        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        openButton = new JButton("Apri il file Exel",
                                 createImageIcon("resources/images/Open32.png"));
        openButton.addActionListener(this);
 
        //Create the save button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        saveButton = new JButton("Salva il tracciato CBI",
                                 createImageIcon("resources/images/SaveAs32.png"));
        saveButton.addActionListener(this);
 
        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
 
        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
    
 
    public void actionPerformed(ActionEvent e) {
 
        //Handle open button action.
        if (e.getSource() == openButton) {
        	open();
        //Handle save button action.
        } else if (e.getSource() == saveButton) {
        	save();
        }
    }
    
    private void open(){
        int returnVal = fc.showOpenDialog(FileChooser.this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            logger.info("Apertura del file: " + file.getAbsolutePath() + "." + Constants.NEW_LINE);
            jout.append("Apertura del file: " + file.getAbsolutePath() + "." + Constants.NEW_LINE);
            try {
            	CBIMAVFlatService service = new CBIMAVFlatServiceImpl();
            	Result res = service.manageSteps(file.getAbsolutePath());
            	logger.info("File CBI creato." + Constants.NEW_LINE);
            	jout.append("File CBI creato." + Constants.NEW_LINE);
            	logger.info("Righe: " + res.getRows() + " Totale importo MAV: " + res.getTot() + Constants.NEW_LINE);
            	jout.append("Righe: " + res.getRows() + " Totale importo MAV: " + res.getTot() + Constants.NEW_LINE);
        		
            }catch (Exception ex) {
            	jout.append(ex.toString());
            	logger.error(ex.getMessage());
			}
        } else {
        	logger.info("Apertura del file annullata" + Constants.NEW_LINE);
            jout.append("Apertura del file annullata" + Constants.NEW_LINE);
        }
        jout.setCaretPosition(jout.getDocument().getLength());
    }
    
    private void save(){
    	 int returnVal = fc.showSaveDialog(FileChooser.this);
         if (returnVal == JFileChooser.APPROVE_OPTION) {
             File file = fc.getSelectedFile();
             try{
             	Files.copy(new File(Constants.OUT_FILE).toPath(),
             			file.toPath(), StandardCopyOption.REPLACE_EXISTING);
             }catch (Exception ex){
            	jout.append(ex.toString());
             	logger.error(ex.getMessage());
             }
             //This is where a real application would save the file.
             logger.info("Salvataggio del file: " + file.getName() + "." + Constants.NEW_LINE);
             jout.append("Salvataggio del file: " + file.getName() + "." + Constants.NEW_LINE);
         } else {
        	 logger.info("Salvataggio annullato" + Constants.NEW_LINE);
             jout.append("Salvataggio annullato" + Constants.NEW_LINE);
         }
         jout.setCaretPosition(jout.getDocument().getLength());
    }
 
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = FileChooser.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Impossible trovare il file: " + path);
            return null;
        }
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame(Constants.GUI_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.add(new FileChooser());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                createAndShowGUI();
            }
        });
    }
}
