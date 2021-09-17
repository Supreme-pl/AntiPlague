import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class View extends JFrame {

    Transport2 demo = new Transport2();

    JLabel day;

    JLabel casesOverall;
    JLabel background1;

    JButton germanyButton;
    JButton polandButton;
    JButton franceButton;
    JButton romaniaButton;
    JButton turkeyButton;
    JButton spainButton;
    JButton italyButton;
    JButton ukButton;
    JButton ukraineButton;
    JButton greeceButton;

    JButton buy;
    JButton buy1;
    JButton buy2;
    JButton buy3;
    JButton buy4;
    JButton buy5;
    JButton buy6;
    JButton buy7;
    JButton buy8;

    JButton clickButton;

    JTabbedPane jTabbedPane;

    JLabel topLabel;
    JLabel bottomLabel;
    JLabel leftLabel;
    JLabel rightLabel;

    JFrame frame;

    JPanel status;
    JPanel upgrades;
    JPanel transportInfos;

    JLabel countryName;
    JLabel countryPopulation;
    JLabel countryCases;
    JLabel cure;
    JLabel scoreLabel;
    JLabel currency;
    JLabel cooldown;

    public View() {

        frame = new JFrame("Anti-PlaGUI (Easy mode)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Virus virus = new Virus();
        virus.start();

        Image icon = Toolkit.getDefaultToolkit().getImage("out/images/icon.png");
        frame.setIconImage(icon);

        ImageIcon img = new ImageIcon("out/images/mapka760760.JPG");
        background1 = new JLabel("", img, JLabel.CENTER);
        background1.setBounds(0, 0, 760, 760);

        germanyButton = new JButton("Germany");
        germanyButton.setFont(new Font("Arial", Font.PLAIN, 10));
        germanyButton.setBounds(305, 430, 77, 20);

        polandButton = new JButton("Poland");
        polandButton.setFont(new Font("Arial", Font.PLAIN, 10));
        polandButton.setBounds(423, 400, 77, 20);

        franceButton = new JButton("France");
        franceButton.setFont(new Font("Arial", Font.PLAIN, 10));
        franceButton.setBounds(200, 520, 77, 20);

        romaniaButton = new JButton("Romania");
        romaniaButton.setFont(new Font("Arial", Font.PLAIN, 10));
        romaniaButton.setBounds(524, 514, 77, 20);

        turkeyButton = new JButton("Turkey");
        turkeyButton.setFont(new Font("Arial", Font.PLAIN, 10));
        turkeyButton.setBounds(674, 625, 77, 20);

        ukraineButton = new JButton("Ukraine");
        ukraineButton.setFont(new Font("Arial", Font.PLAIN, 10));
        ukraineButton.setBounds(580, 420, 77, 20);

        greeceButton = new JButton("Greece");
        greeceButton.setFont(new Font("Arial", Font.PLAIN, 10));
        greeceButton.setBounds(495, 668, 77, 20);

        spainButton = new JButton("Spain");
        spainButton.setFont(new Font("Arial", Font.PLAIN, 10));
        spainButton.setBounds(85, 631, 77, 20);

        italyButton = new JButton("Italy");
        italyButton.setFont(new Font("Arial", Font.PLAIN, 10));
        italyButton.setBounds(340, 605, 77, 20);

        ukButton = new JButton("United Kingdom");
        ukButton.setFont(new Font("Arial", Font.PLAIN, 10));
        ukButton.setBounds(134, 353, 120, 20);

        clickButton = new JButton();
        clickButton.setBounds(620, 90, 110, 110);
        clickButton.setIcon(new ImageIcon("out/images/circled-pause.png"));

        ImageIcon img1 = new ImageIcon("out/images/plaga.png");

        day = new JLabel();
        day.setBorder(BorderFactory.createLineBorder(Color.black));
        day.setText("Day: 0");
        day.setFont(new Font("Arial", Font.BOLD, 16));
//        day.setBackground(Color.decode("#00261F2E"));
        day.setBackground(Color.white);
        day.setForeground(Color.black);
        day.setOpaque(true);
        day.setBounds(20, 10, 80, 30);


        casesOverall = new JLabel();
        casesOverall.setBorder(BorderFactory.createLineBorder(Color.black));
        casesOverall.setText("Cases: 0");
        casesOverall.setFont(new Font("Arial", Font.BOLD, 16));
        casesOverall.setBackground(Color.white);
        casesOverall.setForeground(Color.black);
        casesOverall.setOpaque(true);
        casesOverall.setBounds(130, 10, 200, 30);

        cure = new JLabel();
        cure.setBorder(BorderFactory.createLineBorder(Color.black));
        cure.setText("Cure: 0%");
        cure.setFont(new Font("Arial", Font.BOLD, 16));
        cure.setBackground(Color.white);
        cure.setForeground(Color.black);
        cure.setOpaque(true);
        cure.setBounds(330, 10, 100, 30);

        scoreLabel = new JLabel();
        scoreLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        scoreLabel.setText("Score: 7300");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scoreLabel.setBackground(Color.white);
        scoreLabel.setForeground(Color.black);
        scoreLabel.setOpaque(true);
        scoreLabel.setBounds(450, 10, 200, 30);


        currency = new JLabel();
        currency.setBorder(BorderFactory.createLineBorder(Color.black));
        currency.setText("Money: 0");
        currency.setFont(new Font("Arial", Font.BOLD, 16));
        currency.setBackground(Color.white);
        currency.setForeground(Color.black);
        currency.setOpaque(true);
        currency.setBounds(800, 10, 100, 30);

        countryName = new JLabel();
        countryName.setBounds(2, 0, 1000, 50);
        countryName.setFont(new Font("Arial", Font.BOLD, 15));
        countryPopulation = new JLabel();
        countryPopulation.setBounds(2, 25, 1000, 50);
        countryPopulation.setFont(new Font("Arial", Font.PLAIN, 15));
        countryCases = new JLabel();
        countryCases.setBounds(2, 50, 1000, 50);
        countryCases.setFont(new Font("Arial", Font.PLAIN, 15));

        status = new JPanel();
        status.setBackground(Color.lightGray);
        status.setLayout(null);
        status.add(countryName);
        status.add(countryPopulation);
        status.add(countryCases);

        JLabel text = new JLabel("Upgrade 1: Send some people on");
        JLabel word = new JLabel("quarantine.");
        text.setForeground(Color.black);
        word.setForeground(Color.black);
        cooldown = new JLabel("Cooldown: 5");
        cooldown.setForeground(Color.gray);

        buy = new JButton("Send");
        buy.setMnemonic(KeyEvent.VK_H);
        buy.setEnabled(false);

        JLabel text1 = new JLabel("Upgrade 2: Close up some");
        JLabel a = new JLabel("schools");
        a.setForeground(Color.black);
        text1.setForeground(Color.black);
        JLabel cost1 = new JLabel("Cost: 10");

        buy1 = new JButton("Buy");
        buy1.setEnabled(false);

        JLabel text2 = new JLabel("Upgrade 3: Disinfect tables in");
        JLabel b = new JLabel("restaurants");
        b.setForeground(Color.black);
        text2.setForeground(Color.black);
        JLabel cost2 = new JLabel("Cost: 20");

        buy2 = new JButton("Buy");
        buy2.setEnabled(false);

        JLabel text3 = new JLabel("Upgrade 4: Stop testing people");
        JLabel c = new JLabel("for a day");
        c.setForeground(Color.black);
        text3.setForeground(Color.black);
        JLabel cost3 = new JLabel("Cost: 50");

        buy3 = new JButton("Buy");
        buy3.setEnabled(false);

        JLabel text4 = new JLabel("Upgrade 5: Let government fake");
        JLabel d = new JLabel("data");
        d.setForeground(Color.black);
        text4.setForeground(Color.black);
        JLabel cost4 = new JLabel("Cost: 70");

        buy4 = new JButton("Buy");
        buy4.setEnabled(false);

        JLabel text5 = new JLabel("Upgrade 8: Start working on the");
        JLabel worddd = new JLabel("cure");
        text5.setForeground(Color.black);
        worddd.setForeground(Color.black);
        JLabel cost5 = new JLabel("Cost: 120");

        buy5 = new JButton("Buy");
        buy5.setEnabled(false);

        JLabel text6 = new JLabel("Upgrade 9: Give away the cure for");
        JLabel wordd = new JLabel("people (end game)");
        text6.setForeground(Color.black);
        wordd.setForeground(Color.black);
        JLabel cost6 = new JLabel("Cost: 200");

        buy6 = new JButton("Buy");
        buy6.setEnabled(false);

        JLabel text7 = new JLabel("Upgrade 6: +100 Score Bonus");
        text7.setForeground(Color.black);
        JLabel cost7 = new JLabel("Cost: 50");

        buy7 = new JButton("Buy");
        buy7.setEnabled(false);

        JLabel text8 = new JLabel("Upgrade 7: Random score bonus");
        JLabel wordie = new JLabel("(0 - 1000)");
        text8.setForeground(Color.black);
        wordie.setForeground(Color.black);
        JLabel cost8 = new JLabel("Cost: 300");
        buy8 = new JButton("Buy");
        buy8.setEnabled(false);



        upgrades = new JPanel();
        upgrades.setBackground(Color.pink);
        upgrades.setLayout(new BoxLayout(upgrades, BoxLayout.Y_AXIS));
        upgrades.add(text);
        upgrades.add(word);
        upgrades.add(cooldown);
        upgrades.add(buy);
        upgrades.add(text1);
        upgrades.add(a);
        upgrades.add(cost1);
        upgrades.add(buy1);
        upgrades.add(text2);
        upgrades.add(b);
        upgrades.add(cost2);
        upgrades.add(buy2);
        upgrades.add(text3);
        upgrades.add(c);
        upgrades.add(cost3);
        upgrades.add(buy3);
        upgrades.add(text4);
        upgrades.add(d);
        upgrades.add(cost4);
        upgrades.add(buy4);
        upgrades.add(text7);
        upgrades.add(cost7);
        upgrades.add(buy7);
        upgrades.add(text8);
        upgrades.add(wordie);
        upgrades.add(cost8);
        upgrades.add(buy8);
        upgrades.add(text5);
        upgrades.add(worddd);
        upgrades.add(cost5);
        upgrades.add(buy5);
        upgrades.add(text6);
        upgrades.add(wordd);
        upgrades.add(cost6);
        upgrades.add(buy6);

        JScrollPane scrollPane = new JScrollPane(upgrades, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(100, 100));

        jTabbedPane = new JTabbedPane();
        jTabbedPane.add("Upgrades", scrollPane);
        jTabbedPane.add("Status", status);
        jTabbedPane.setBounds(770, 100, 220, 600);


        rightLabel = new JLabel("", img1, JLabel.CENTER);
        rightLabel.setBackground(Color.decode("#261F2E"));
        rightLabel.setOpaque(true);
        rightLabel.setBounds(760, 0, 264, 760);

        topLabel = new JLabel("", img1, JLabel.CENTER);
        topLabel.setBackground(Color.decode("#261F2E"));
        topLabel.setOpaque(true);
        topLabel.setBounds(0, 0, 1024, 60);

        bottomLabel = new JLabel("", img1, JLabel.CENTER);
        bottomLabel.setBackground(Color.decode("#261F2E"));
        bottomLabel.setOpaque(true);
        bottomLabel.setBounds(0, 710, 1024, 70);

        leftLabel = new JLabel("", img1, JLabel.CENTER);
        leftLabel.setBackground(Color.decode("#261F2E"));
        leftLabel.setOpaque(true);
        leftLabel.setBounds(0, 0, 10, 760);

        frame.add(new Transport2());
        frame.add(new Transport());
        frame.add(clickButton);

        frame.add(italyButton);
        frame.add(ukButton);
        frame.add(spainButton);
        frame.add(greeceButton);
        frame.add(romaniaButton);
        frame.add(turkeyButton);
        frame.add(ukraineButton);
        frame.add(franceButton);
        frame.add(germanyButton);
        frame.add(polandButton);

        frame.add(jTabbedPane);
        frame.add(day);
        frame.add(casesOverall);
        frame.add(cure);
        frame.add(scoreLabel);
        frame.add(currency);
        frame.add(rightLabel);
        frame.add(leftLabel);
        frame.add(topLabel);
        frame.add(bottomLabel);

        frame.add(background1);


        frame.setResizable(false);
//        this.getContentPane().setLayout(null);
        frame.setLayout(null);
        frame.setSize(1024, 780);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



    public JLabel getDay() {
        return day;
    }

    public JButton getGermanyButton() {
        return germanyButton;
    }

    public JButton getPolandButton() {
        return polandButton;
    }

    public JButton getFranceButton() {
        return franceButton;
    }

    public JButton getRomaniaButton() {
        return romaniaButton;
    }

    public JButton getTurkeyButton() {
        return turkeyButton;
    }

    public JButton getSpainButton() {
        return spainButton;
    }

    public JButton getItalyButton() {
        return italyButton;
    }

    public JButton getUkButton() {
        return ukButton;
    }

    public JButton getUkraineButton() {
        return ukraineButton;
    }

    public JButton getGreeceButton() {
        return greeceButton;
    }

    public JButton getClickButton() {
        return clickButton;
    }
    public JFrame getFrame() {
        return frame;
    }

    public JLabel getCountryName() {
        return countryName;
    }

    public JLabel getCountryPopulation() {
        return countryPopulation;
    }

    public JLabel getCasesOverall() {
        return casesOverall;
    }

    public JLabel getCountryCases() {
        return countryCases;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public JLabel getCurrency() {
        return currency;
    }

    public JButton getBuy(){return buy;}

    public JButton getBuy1() {
        return buy1;
    }

    public JButton getBuy2() {
        return buy2;
    }

    public JButton getBuy3() {
        return buy3;
    }

    public JButton getBuy4() {
        return buy4;
    }

    public JButton getBuy5() {
        return buy5;
    }

    public JButton getBuy6() {
        return buy6;
    }

    public JButton getBuy7() {
        return buy7;
    }

    public JButton getBuy8() {
        return buy8;
    }

    public JLabel getCooldown() {
        return cooldown;
    }
}
