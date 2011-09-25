import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class NBA_Alert extends JFrame 
{ 
	
	Button startButton, endButton;
	JLabel westConf, eastConf;
	JCheckBox w1Spurs, w2Lakers, w3Mavericks, w4Thunder, w5Nuggets, w6Trailblazers, w7Hornets, w8Grizzlies, e1Bulls, e2Heat, e3Celtics, e4Magic, e5Hawks, e6Knicks, e776ers, e8Pacers;
	String wPage;	
	
	public NBA_Alert() 
	{ 
		
		setTitle("NBA Alert v1.0");
		setLayout(null); 
		
		//buttons
		startButton = new Button("Start Play-By-Play!"); 
		startButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("here we go");
				
				 if(w1Spurs.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310417024";
				 }
				 
				 if(w2Lakers.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310417013";
				 }
				 
				 if(w3Mavericks.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310416006";
				 }
				 
				 if(w4Thunder.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310417025";
				 }
				 if(w5Nuggets.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310417025";
				 }
				 if(w6Trailblazers.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310416006";
				 }
				 
				 if(w7Hornets.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310417013";
				 }
				 
				 if(w8Grizzlies.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310417024";
				 }
				 
				 if(e1Bulls.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310416004";
				 }
				 
				 if(e2Heat.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310416014";
				 }
				 
				 if(e3Celtics.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310416006";
				 }
				 
				 if(e4Magic.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310417025";
				 }
				 
				 if(e5Hawks.isSelected()){
					 wPage = "http://espn.go.com/nba/playbyplay?gameId=310417025";
				 }
				 
				if(e6Knicks.isSelected()){
					wPage = "http://espn.go.com/nba/playbyplay?gameId=310416006";
				}
				 
				if(e776ers.isSelected()){
					wPage = "http://espn.go.com/nba/playbyplay?gameId=310416014";
				}
				
				if(e8Pacers.isSelected()){
					wPage = "http://espn.go.com/nba/playbyplay?gameId=310416004";
				}
				 
				parse_info parsedSite = new parse_info(wPage);
				try {
					parsedSite.parseSite();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
        endButton = new Button("End");

        //West&East conference labels
        westConf = new JLabel("Western Conference");
        westConf.setFont(new Font("Arial", Font.BOLD, 14));
        westConf.setForeground(Color.white);
        		
        eastConf = new JLabel("Eastern Conference");
        eastConf.setFont(new Font("Arial", Font.BOLD, 14));
        eastConf.setForeground(Color.white);
        
        //West conference selections
        w1Spurs = new JCheckBox("San Antonio Spurs", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310417024
        w1Spurs.setOpaque(false);
        w1Spurs.setForeground(Color.WHITE);
        w2Lakers = new JCheckBox("Los Angeles Lakers", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310417013
        w2Lakers.setOpaque(false);
        w2Lakers.setForeground(Color.WHITE);
        w3Mavericks = new JCheckBox("Dallas Mavericks", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310416006
        w3Mavericks.setOpaque(false);
        w3Mavericks.setForeground(Color.WHITE);
        w4Thunder = new JCheckBox("Oklahoma City Thunder", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310417025
        w4Thunder.setOpaque(false);
        w4Thunder.setForeground(Color.WHITE);
        w5Nuggets = new JCheckBox("Denver Nuggets", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310417025
        w5Nuggets.setOpaque(false);
        w5Nuggets.setForeground(Color.WHITE);
        w6Trailblazers = new JCheckBox("Portland Trailblazers", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310416006
        w6Trailblazers.setOpaque(false);
        w6Trailblazers.setForeground(Color.WHITE);
        w7Hornets = new JCheckBox("New Orleans Hornets", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310417013
        w7Hornets.setOpaque(false);
        w7Hornets.setForeground(Color.WHITE);
        w8Grizzlies = new JCheckBox("Memphis Grizzlies", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310417024
        w8Grizzlies.setOpaque(false);
        w8Grizzlies.setForeground(Color.WHITE);

        //East conference selections
        e1Bulls = new JCheckBox("Chicago Bulls", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310416004
        e1Bulls.setOpaque(false);
        e1Bulls.setForeground(Color.WHITE);
        e2Heat = new JCheckBox("Miami Heat", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310416014
        e2Heat.setOpaque(false);
        e2Heat.setForeground(Color.WHITE);
        e3Celtics = new JCheckBox("Boston Celtics", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310424018
        e3Celtics.setOpaque(false);
        e3Celtics.setForeground(Color.WHITE);
        e4Magic = new JCheckBox("Orlando Magic", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310416019
        e4Magic.setOpaque(false);
        e4Magic.setForeground(Color.WHITE);
        e5Hawks = new JCheckBox("Atlanta Hawks", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310416019
        e5Hawks.setOpaque(false);
        e5Hawks.setForeground(Color.WHITE);
        e6Knicks = new JCheckBox("New York Knicks", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310424018
        e6Knicks.setOpaque(false);
        e6Knicks.setForeground(Color.WHITE);
        e776ers = new JCheckBox("Philadelphia 76ers", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310416014
        e776ers.setOpaque(false);
        e776ers.setForeground(Color.WHITE);
        e8Pacers = new JCheckBox("Indiana Pacers", false); //if true, set URL to: http://espn.go.com/nba/playbyplay?gameId=310416004
        e8Pacers.setOpaque(false);
        e8Pacers.setForeground(Color.WHITE);
        
        //location/sizes of components
        westConf.setBounds(30,200,200,30);    
        w1Spurs.setBounds(30,230,150,30); 
        w2Lakers.setBounds(30,260,150,30); 
        w3Mavericks.setBounds(30,290,150,30); 
        w4Thunder.setBounds(30,320,150,30); 
        w5Nuggets.setBounds(30,350,150,30); 
        w6Trailblazers.setBounds(30,380,150,30); 
        w7Hornets.setBounds(30,410,150,30); 
        w8Grizzlies.setBounds(30,440,150,30); 
            
        eastConf.setBounds(220,200,200,30);
        e1Bulls.setBounds(220,230,150,30); 
        e2Heat.setBounds(220,260,150,30); 
        e3Celtics.setBounds(220,290,150,30);
        e4Magic.setBounds(220,320,150,30); 
        e5Hawks.setBounds(220,350,150,30); 
        e6Knicks.setBounds(220,380,150,30); 
        e776ers.setBounds(220,410,150,30); 
        e8Pacers.setBounds(220,440,150,30); 
        
        startButton.setBounds(135,500,130,30); 
        endButton.setBounds(165,540,70,30);

        //add components to the screen
        add(westConf);
        add(w1Spurs); 
        add(w2Lakers); 
        add(w3Mavericks); 
        add(w4Thunder);
        add(w5Nuggets); 
        add(w6Trailblazers);
        add(w7Hornets); 
        add(w8Grizzlies);
      
	    add(eastConf);
	    add(e1Bulls); 
	    add(e2Heat); 
	    add(e3Celtics); 
	    add(e4Magic);
	    add(e5Hawks); 
	    add(e6Knicks);
	    add(e776ers); 
	    add(e8Pacers);

        add(startButton); 
        add(endButton);
     }
   
	public static void main(String[] args) 
	{
		//initialize panel for displaying background image
		ImagePanel panel = new ImagePanel(new ImageIcon("bgImage.jpg").getImage());
		
		NBA_Alert app = new NBA_Alert();
	
		app.getContentPane().add(panel);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
		app.setVisible(true);
		app.setSize(410,640);
		
		
	}
	
}

//background image must be on a separate JPanel
class ImagePanel extends JPanel {
	private Image img;
	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}
	
	public ImagePanel(Image img) {
		this.img=img;
		 Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		    setPreferredSize(size);
		    setMinimumSize(size);
		    setMaximumSize(size);
		    setSize(size);
		    setLayout(null);

		  }

		  public void paintComponent(Graphics g) {
		    g.drawImage(img, 0, 0, null);
		  }

		}
