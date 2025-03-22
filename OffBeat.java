import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FakeSongRecs 
{
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    JButton startButton, choice1, choice2, choice3, choice4;
    String[] genres= {"rock", "jazz","pop", "rAndB","country"};
    JTextArea mainTextArea;
    int rock, jazz, pop, rAndB, country;
    String[] resultArr1={"Old Town Road", "I Wanna Love You", "Bonfire", "We Built This City"};
    String[] resultArr2={"Love Story", "Loyal", "Revolution 9", "Photograph"};
    String[] resultArr3={"Dirt Road Anthem", "Yeah!", "Metal Machine Music", "Perfect"};
    String[] resultArr4={"Accidental Racist", "Blurred Lines", "Black Skinhead", "Sweet Child O' Mine"};
    String result1 = "";
    String result2= "";
    String result3= "";
    String result4 = "";
    String qNum;
    String max="";
    int maxNum=0;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    
    ImageIcon logo = new ImageIcon(".//res//jackfrost.jpg");

    public static void main(String[] args)
    {
        new FakeSongRecs();
    }
    
    public  FakeSongRecs(){
        
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setIconImage(logo.getImage());
        con = window.getContentPane();
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Song Recs");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);    
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        
        window.setVisible(true);
    }
    
    public void createGameScreen()
    
    {   
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);        
        mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true); 
        mainTextArea.setEditable(false);     
        
        mainTextPanel.add(mainTextArea);
        
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);        
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.black);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler); 
        choice1.setActionCommand("c1"); 
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.black);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.black);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.black);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);
        choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!
        

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        hpLabel = new JLabel("");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        weaponLabel.setBackground(Color.red);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        userSetup();

    }
    public void userSetup()
    {
        pop = 0;
        rAndB = 0;
        rock = 0;
        country = 0;
        
        question1();
    }
    public void question1()
    {
        qNum = "question 1";
        
        mainTextArea.setText("What is your favorite aesthetic?");        
        choice1.setText("Cowboy/Cowgirl");
        choice2.setText("Soulful");
        choice3.setText("Trendy");
        choice4.setText("Grungy");
        
    }
    public void question2()
    {
        qNum = "question 2";
        
        mainTextArea.setText("What is your favorite song?");        
        choice1.setText("This ain't Texas");
        choice2.setText("Bad Habits");
        choice3.setText("Shake it Off");
        choice4.setText("Sweater Weather");
    }
    public void question3()
    {
        qNum = "question 3";
        
        mainTextArea.setText("What is your favorite vibe?");        
        choice1.setText("Outdoorsy");
        choice2.setText("Calm");
        choice3.setText("Party");
        choice4.setText("Harsh");
    }
    public void question4()
    {
        qNum = "question 4";
        
        mainTextArea.setText("What is your emoji?");        
        choice1.setText("Flower emoji");
        choice2.setText("Ocean wave emoji");
        choice3.setText("Confetti emoji");
        choice4.setText("Skull emoji");
        
    }
    public void question5()
    {
        qNum = "question 5";
        
        mainTextArea.setText("What is your favorite thing?");        
        choice1.setText("Horse");
        choice2.setText("Your room");
        choice3.setText("Microphone");
        choice4.setText("Headphones");
    }
    public void question6()
    {
        qNum = "question 6";
        
        mainTextArea.setText("What is your favorite food?");        
        choice1.setText("Steak");
        choice2.setText("Chick-Fil-A");
        choice3.setText("Confetti Cake");
        choice4.setText("Mashed Potatoes");
        
        
    }
    public void question7()
    {
        qNum = "question 7";
        
        mainTextArea.setText("What is your favorite movie?");        
        choice1.setText("Nashville");
        choice2.setText("Bad Boys");
        choice3.setText("Spiderman");
        choice4.setText("Avatar");
    }
    public void question8()
    {
        qNum = "question 8";
        
        mainTextArea.setText("What is your favorite female artist?");        
        choice1.setText("Beyonce");
        choice2.setText("SZA");
        choice3.setText("Taylor Swift");
        choice4.setText("Tina Turner");
        
        
    }
    public void question9()
    {
        qNum = "question 9";
        
        mainTextArea.setText("What is your favorite male artist?");        
        choice1.setText("Johnny Cash");
        choice2.setText("Frank Ocean");
        choice3.setText("Bruno Mars");
        choice4.setText("Elvis Presley");
        
    }
    public void question10()
    {
        qNum = "question 10";
        
        mainTextArea.setText("What is your favorite game?");        
        choice1.setText("Wordle");
        choice2.setText("Operation");
        choice3.setText("Monopoly");
        choice4.setText("Battleship");
        
    }

    
    
    public void ending(){
        
        mainTextArea.setText("Thank you for staying till the end! Here are some song recs:");
        choice1.setText(resultArr1[maxNum]);
        choice2.setText(resultArr2[maxNum]);
        choice3.setText(resultArr3[maxNum]);
        choice4.setText(resultArr4[maxNum]);
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(true);
    }




    public class TitleScreenHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            
            createGameScreen();
        }
    }
    

    public class ChoiceHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            
            String yourChoice = event.getActionCommand();
            
            switch(qNum)
            {
                case "question 1":
                    switch(yourChoice)
                    {
                        case "c1":
                            country++; 
                            question2(); 
                            break;
                        case "c2":
                            rAndB++; 
                            question2(); 
                            break;
                        case "c3":
                            pop++; 
                            question2(); 
                            break;
                        case "c4":
                            rock++; 
                            question2(); 
                            break;
                    }
                    break;
                case "question 2":
                    switch(yourChoice)
                    {
                        case "c1":
                            country++; 
                            question3(); 
                            break;
                        case "c2":
                            rAndB++; 
                            question3(); 
                            break;
                        case "c3":
                            pop++; 
                            question3(); 
                            break;
                        case "c4":
                            rock++; 
                            question3(); 
                            break;
                    }
                    break;
                case "question 3":
                    switch(yourChoice)
                    {
                        case "c1":
                            country++; 
                            question4(); 
                            break;
                        case "c2":
                            rAndB++; 
                            question4(); 
                            break;
                        case "c3":
                            pop++; 
                            question4(); 
                            break;
                        case "c4":
                            rock++; 
                            question4(); 
                            break;
                    }
                    break;
                case "question 4":
                    switch(yourChoice)
                    {
                        case "c1":
                            country++; 
                            question5(); 
                            break;
                        case "c2":
                            rAndB++; 
                            question5(); 
                            break;
                        case "c3":
                            pop++; 
                            question5(); 
                             break;
                        case "c4":
                            rock++; 
                            question5(); 
                            break;
                    }
                    break;
                case "question 5":
                    switch(yourChoice)
                    {
                        case "c1":
                            country++; 
                            question6(); 
                            break;
                        case "c2":
                            rAndB++; 
                            question6(); 
                            break;
                        case "c3":
                            pop++; 
                            question6(); 
                            break;
                        case "c4":
                            rock++; 
                            question6(); 
                            break;
                    }
                    break;
                case "question 6":
                    switch(yourChoice)
                    {
                        case "c1":
                            country++; 
                            question7(); 
                            break;
                        case "c2":
                            rAndB++; 
                            question7(); 
                            break;
                        case "c3":
                            pop++; 
                            question7(); 
                            break;
                        case "c4":
                            rock++; 
                            question7(); 
                            break;
                    }
                    break;
                case "question 7":
                    switch(yourChoice)
                    {
                        case "c1":
                            country++; 
                            question8(); 
                            break;
                        case "c2":
                            rAndB++; 
                            question8(); 
                            break;
                        case "c3":
                            pop++; 
                            question8(); 
                            break;
                        case "c4":
                            rock++; 
                            question8(); 
                            break;
                    }
                    break;
                case "question 8":
                    switch(yourChoice)
                    {
                        case "c1":
                            country++; 
                            question9(); 
                            break;
                        case "c2":
                            rAndB++; 
                            question9(); 
                            break;
                        case "c3":
                            pop++; 
                            question9(); 
                            break;
                        case "c4":
                            rock++; 
                            question9(); 
                            break;
                    }
                    break;
                case "question 9":
                    switch(yourChoice)
                    {
                        case "c1":
                            country++; 
                            question10(); 
                            break;
                        case "c2":
                            rAndB++; 
                            question10(); 
                            break;
                        case "c3":
                            pop++; 
                            question10(); 
                            break;
                        case "c4":
                            rock++; 
                            question10(); 
                            break;
                    }
                    break;
                case "question 10":
                    switch(yourChoice)
                    {
                        case "c1":
                            country++; 
                            max="";
                            if(country>=rock && country>=pop && country>=rAndB)
                            {
                                max="country";
                                maxNum=0;
                            }
                             
                            break;
                        case "c2":
                            rAndB++; 
                            max="";

                            if(rAndB>=rock && rAndB>=pop && rAndB>=country)
                            {
                                max="R&B";
                                maxNum=1;
                            }
                    
                            break;
                        case "c3":
                            pop++; 
                            max="";
                            if(pop>=rock && pop>=country && pop>=rAndB)
                            {
                                max="pop";
                                maxNum=2;
                            }
                        
                            break;
                        case "c4":
                            rock++;
                            max="";
                            if(rock>=pop && rock>=country && rock>=rAndB)
                            {
                                max="rock";
                                maxNum= 3;
                            }
                            
                            
                            break;
                            
                            
                    }
                    ending();
                    break;
                    
            }
        }
    }
}
