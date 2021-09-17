import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    private View view;
    private Country country;
    private HighScores highScores;
    Virus virus = new Virus(); //virus thread
    Timer t, c, v, tmp, cooldown, info, checkMoney;
    private long money;
    private long i;
    private long virusProgress = 1;
    private int seconds;
    private String name;
    public long score;
    public ArrayList<String> highScore = new ArrayList<>(Arrays.asList(""));


    Country france = new Country("France", 67000000);
    Country poland = new Country("Poland", 38400000);
    Country germany = new Country("Germany", 83000000);
    Country italy = new Country("Italy", 60000000);
    Country romania = new Country("Romania", 20000000);
    Country spain = new Country("Spain", 47000000);
    Country uk = new Country("United Kingdom", 68000000);
    Country greece = new Country("Greece", 11000000);
    Country ukraine = new Country("Ukraine", 42600000);
    Country turkey = new Country("Turkey", 83600000);

    private long all = 0;

    Cure vaccine = new Cure(); // cure thread

    public Controller(View v, Country m, HighScores h)
    {
        view = v;
        country = m;
        highScores = h;
    }

    boolean flagRo = true;
    boolean flagPl = true;
    boolean flagUk = true;
    boolean flagUa = true;
    boolean flagIt = true;
    boolean flagFr = true;
    boolean flagDe = true;
    boolean flagGr = true;
    boolean flagTr = true;
    boolean flagEs = true;

    public void setMenuBar() {
        view.getFrame().setJMenuBar(initMenuBar());
    }
    public void updateTransport() {
        info = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flagRo && romania.getVirus().getVirusProgress()/10 > 24000)
                {
                    JOptionPane.showMessageDialog(null, "Romania is closing its airports",
                            "Romania", JOptionPane.WARNING_MESSAGE);
                    flagRo = false;
                }

                if(flagPl && poland.getVirus().getVirusProgress()/10 > 43000)
                {
                    JOptionPane.showMessageDialog(null, "Poland is temporarily cancelling abroad trips",
                            "Poland", JOptionPane.WARNING_MESSAGE);

                    flagPl = false;
                }
                if(flagUk && uk.getVirus().getVirusProgress()/10 > 65000)
                {
                    JOptionPane.showMessageDialog(null, "United Kingdom lets only their citizens inside",
                            "United Kingdom", JOptionPane.WARNING_MESSAGE);

                    flagUk = false;
                }

                if(flagUa && ukraine.getVirus().getVirusProgress()/10 > 42000)
                {
                    JOptionPane.showMessageDialog(null, "Ukraine stops letting foreigners inside",
                            "Ukraine", JOptionPane.WARNING_MESSAGE);

                    flagUa = false;
                }
                if(flagIt && italy.getVirus().getVirusProgress()/10 > 210000)
                {
                    JOptionPane.showMessageDialog(null, "Italy holds the train connection to Europe",
                            "Italy", JOptionPane.WARNING_MESSAGE);

                    flagIt = false;
                }

                if(flagFr && france.getVirus().getVirusProgress()/10 > 70000)
                {
                    JOptionPane.showMessageDialog(null, "France closes road connection",
                            "France", JOptionPane.WARNING_MESSAGE);

                    flagFr = false;
                }
                if(flagDe && germany.getVirus().getVirusProgress()/10 > 10000)
                {
                    JOptionPane.showMessageDialog(null, "Germany holds international train routes",
                                "Germany", JOptionPane.WARNING_MESSAGE);

                    flagDe = false;
                }

                if(flagGr && greece.getVirus().getVirusProgress()/10 > 20000)
                {
                    JOptionPane.showMessageDialog(null, "Greece closes road connection with Europe and ferry connection with Turkey",
                            "Greece", JOptionPane.WARNING_MESSAGE);

                    flagGr = false;
                }
                if(flagTr && turkey.getVirus().getVirusProgress()/10 > 100000)
                {
                    JOptionPane.showMessageDialog(null, "Turkey closed the airports",
                            "Turkey", JOptionPane.WARNING_MESSAGE);

                    flagTr = false;
                }

                if(flagEs && spain.getVirus().getVirusProgress()/10 > 80000)
                {
                    JOptionPane.showMessageDialog(null, "Spain closes the airports",
                            "Spain", JOptionPane.WARNING_MESSAGE);

                    flagEs = false;
                }
            }
        });
        info.start();
    }
    private JMenuItem exitAppItem;
    private JMenuBar initMenuBar() {
        JMenuBar menubar = new JMenuBar();

        JMenu gameMenu = new JMenu("Game");
        menubar.add(gameMenu);

        exitAppItem = new JMenuItem("Back to Main Menu");
        exitAppItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(exitAppItem)) {
                    int returnvalue = JOptionPane.showConfirmDialog(null,"Are you sure " +
                            "you want to leave?");
                    if (returnvalue == JOptionPane.YES_OPTION){
                        view.getFrame().dispose();
                        new MainMenu();
                    }
                }
            }
        });
        exitAppItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));

        gameMenu.add(exitAppItem);

        return menubar;
    }

    public void CheckScore() {
        if (this.highScore.get(0).equals(""))
            return;
            name = JOptionPane.showInputDialog("Your score is: "+score+". Type in your name.");
            String dHighScore = name + ":" + score;
            highScore.add(0, dHighScore);
            File scoreFile = new File("highscore.dat");
            if (!scoreFile.exists()) {
                try {
                    scoreFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileWriter writeFile = null;
            BufferedWriter writer = null;
            try {
                writeFile = new FileWriter(scoreFile);
                writer = new BufferedWriter(writeFile);
                for(String s : highScore) {
                    if(s != null)
                        writer.write(s + "\n");
                }
                highScores.getHighscorez().removeAllElements();
                for(String s : highScore)
                    highScores.getHighscorez().addElement(s);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null)
                        writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
    public void updateLabels() {
        JOptionPane.showMessageDialog(null, "COVID-19 spotted in Hubei, China has been brought to Europe.",
                "Warning!", JOptionPane.WARNING_MESSAGE);
        virus.start();
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                highScores.getHighscorez().removeAllElements();
                for (String s : GetHighScore())
                    highScores.getHighscorez().addElement(s);

                i++;
                score = 7300 - i*10;
                view.getDay().setText("Day: " + i);
                view.getScoreLabel().setText("Score: " + score);


                if (highScore.get(0).equals("")) {
                    int n = 0;
                    for (String s : GetHighScore()) {
                        if (n == 0) {
                            highScore.clear();
                        }
                        n++;
                        highScore.add(s);
                    }
                }
            }

            private ArrayList<String> GetHighScore() {
                ArrayList<String> hScore = new ArrayList<>();
                FileReader readFile = null;
                BufferedReader reader = null;
                try
                {
                    File file = new File("highscore.dat");
                    readFile = new FileReader("highscore.dat");
                    reader = new BufferedReader(readFile);

                    for(int i = 0; i <= (int)file.length(); i++)
                        hScore.add(reader.readLine());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        if (reader!=null)
                            reader.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                return hScore;
            }
        });
        t.start();
        c = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                all = romania.getVirus().getVirusProgress()/10+greece.getVirus().getVirusProgress()/10+poland.getVirus().getVirusProgress()/10
                        +germany.getVirus().getVirusProgress()/10+italy.getVirus().getVirusProgress()/10+france.getVirus().getVirusProgress()/10+
                        uk.getVirus().getVirusProgress()/10+ukraine.getVirus().getVirusProgress()/10+spain.getVirus().getVirusProgress()/10+turkey.getVirus().getVirusProgress()/10;
                view.getCasesOverall().setText("Cases: " + all);
            }
        });
        c.start();
        seconds = 5;
        cooldown = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seconds > 0){
                seconds--;
                view.getCooldown().setText("Cooldown: "+ seconds);
                }
                if (seconds == 0) {
                    view.getBuy().setEnabled(true);
                    cooldown.stop();
                    seconds = 6;
                }
            }
        });
        cooldown.start();
        checkMoney = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (money >= 10)
                    view.getBuy1().setEnabled(true);
                else view.getBuy1().setEnabled(false);
                if (money >= 20)
                    view.getBuy2().setEnabled(true);
                else view.getBuy2().setEnabled(false);
                if (money >= 50)
                    view.getBuy3().setEnabled(true);
                else view.getBuy3().setEnabled(false);
                if (money >= 70)
                    view.getBuy4().setEnabled(true);
                else view.getBuy4().setEnabled(false);
                if (money >= 120)
                    view.getBuy5().setEnabled(true);
                if (money >= 300 && vaccine.cureProgress==100)
                    view.getBuy6().setEnabled(true);
                else view.getBuy6().setEnabled(false);
            }
        });
        checkMoney.start();
    }

    public static int getRandomInteger(int maximum, int minimum) {
        return ((int) (Math.random() * (maximum - minimum))) + minimum;
    }

    public Timer getInfo() {
        return info;
    }

    public void controlTime() {
        tmp = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i >= 730 || all >= 52060000) {
                    t.stop();
                    c.stop();
                    JOptionPane.showMessageDialog(null, "You lost.");
                    info.stop();
                    view.getFrame().dispose();
                    System.exit(0);
                }
            }
        });
        tmp.start();
    }

    public void controlButtons() {

        highScores.getBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        view.getClickButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (t.isRunning()) {
                    t.stop();
                    c.stop();
                    cooldown.stop();
                    info.stop();
                    checkMoney.stop();
                    view.getClickButton().setIcon(new ImageIcon("out/images/circled-play.png"));
                } else {
                    t.start();
                    c.start();
                    cooldown.start();
                    info.start();
                    checkMoney.start();
                    view.getClickButton().setIcon(new ImageIcon("out/images/circled-pause.png"));
                }
            }
        });

        view.getGermanyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCountryName().setText(germany.getName());
                view.getCountryPopulation().setText("Population: "+germany.getPopulation());
                if (germany.getPopulation() > germany.getCases()) {
                    view.getCountryCases().setText("Cases: " + germany.getVirus().getVirusProgress() / 10);
                }
                else
                    view.getCountryCases().setText("There's no healthy person left. ");
            }
        });
        view.getRomaniaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCountryName().setText(romania.getName());
                view.getCountryPopulation().setText("Population: "+romania.getPopulation());
                if (romania.getPopulation() > romania.getCases()){
                view.getCountryCases().setText("Cases: "+romania.getVirus().getVirusProgress()/10);
                }
                else
                    view.getCountryCases().setText("There's no healthy person left. ");
            }
        });
        view.getSpainButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCountryName().setText(spain.getName());
                view.getCountryPopulation().setText("Population: "+spain.getPopulation());
                if (spain.getPopulation() > spain.getCases())
                    view.getCountryCases().setText("Cases: "+spain.getVirus().getVirusProgress()/10);
                else
                    view.getCountryCases().setText("There's no healthy person left. ");
            }
        });
        view.getPolandButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCountryName().setText(poland.getName());
                view.getCountryPopulation().setText("Population: "+poland.getPopulation());
                if (poland.getPopulation() > poland.getCases())
                    view.getCountryCases().setText("Cases: "+poland.getVirus().getVirusProgress()/10);
                else
                    view.getCountryCases().setText("There's no healthy person left. ");
            }
        });
        view.getFranceButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCountryName().setText(france.getName());
                view.getCountryPopulation().setText("Population: "+france.getPopulation());
                if (france.getPopulation() > france.getCases())
                    view.getCountryCases().setText("Cases: "+france.getVirus().getVirusProgress()/10);
                else
                    view.getCountryCases().setText("There's no healthy person left. ");
            }
        });
        view.getItalyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCountryName().setText(italy.getName());
                view.getCountryPopulation().setText("Population: "+italy.getPopulation());
                if (italy.getPopulation() > italy.getCases())
                    view.getCountryCases().setText("Cases: "+italy.getVirus().getVirusProgress()/10);
                else
                    view.getCountryCases().setText("There's no healthy person left. ");
            }
        });
        view.getUkraineButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCountryName().setText(ukraine.getName());
                view.getCountryPopulation().setText("Population: "+ukraine.getPopulation());
                if (ukraine.getPopulation() > ukraine.getCases())
                    view.getCountryCases().setText("Cases: "+ukraine.getVirus().getVirusProgress()/10);
                else
                    view.getCountryCases().setText("There's no healthy person left. ");
            }
        });
        view.getTurkeyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCountryName().setText(turkey.getName());
                view.getCountryPopulation().setText("Population: "+turkey.getPopulation());
                if (turkey.getPopulation() > turkey.getCases())
                    view.getCountryCases().setText("Cases: "+turkey.getVirus().getVirusProgress()/10);
                else
                    view.getCountryCases().setText("There's no healthy person left. ");
            }
        });
        view.getGreeceButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCountryName().setText(greece.getName());
                view.getCountryPopulation().setText("Population: "+greece.getPopulation());
                if (greece.getPopulation() > greece.getCases())
                    view.getCountryCases().setText("Cases: "+greece.getVirus().getVirusProgress()/10);
                else
                    view.getCountryCases().setText("There's no healthy person left. ");
            }
        });
        view.getUkButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getCountryName().setText(uk.getName());
                view.getCountryPopulation().setText("Population: "+uk.getPopulation());
                if (uk.getPopulation() > uk.getCases())
                    view.getCountryCases().setText("Cases: "+uk.getVirus().getVirusProgress()/10);
                else
                    view.getCountryCases().setText("There's no healthy person left. ");
            }
        });
        view.getBuy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cooldown.start();
                view.getBuy().setEnabled(false);
                if (!t.isRunning())
                    cooldown.stop();

                romania.getVirus().upgrade5();
                germany.getVirus().upgrade5();
                greece.getVirus().upgrade5();
                italy.getVirus().upgrade5();
                uk.getVirus().upgrade5();
                ukraine.getVirus().upgrade5();
                poland.getVirus().upgrade5();
                france.getVirus().upgrade5();
                spain.getVirus().upgrade5();
                turkey.getVirus().upgrade5();

                money = (int) (money + (Math.random()) * 30);

                view.getCurrency().setText("Money: "+ money);
            }
        });
        view.getBuy1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                romania.getVirus().upgrade10();
                germany.getVirus().upgrade10();
                greece.getVirus().upgrade10();
                italy.getVirus().upgrade10();
                uk.getVirus().upgrade10();
                ukraine.getVirus().upgrade10();
                poland.getVirus().upgrade10();
                france.getVirus().upgrade10();
                spain.getVirus().upgrade10();
                turkey.getVirus().upgrade10();

                money -= 10;
                if (money <= 10) {
                    view.getBuy1().setEnabled(false);
                }
                view.getCurrency().setText("Money: "+money);
            }
        });
        view.getBuy2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                romania.getVirus().upgrade20();
                germany.getVirus().upgrade20();
                greece.getVirus().upgrade20();
                italy.getVirus().upgrade20();
                uk.getVirus().upgrade20();
                ukraine.getVirus().upgrade20();
                poland.getVirus().upgrade20();
                france.getVirus().upgrade20();
                spain.getVirus().upgrade20();
                turkey.getVirus().upgrade20();

                money -= 20;
                if (money <= 20) {
                    view.getBuy2().setEnabled(false);
                }
                view.getCurrency().setText("Money: "+money);
            }
        });
        view.getBuy3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                romania.getVirus().upgrade30();
                germany.getVirus().upgrade30();
                greece.getVirus().upgrade30();
                italy.getVirus().upgrade30();
                uk.getVirus().upgrade30();
                ukraine.getVirus().upgrade30();
                poland.getVirus().upgrade30();
                france.getVirus().upgrade30();
                spain.getVirus().upgrade30();
                turkey.getVirus().upgrade30();

                money -= 50;
                if (money <= 50) {
                    view.getBuy3().setEnabled(false);
                }
                view.getCurrency().setText("Money: "+money);
            }
        });
        view.getBuy4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                romania.getVirus().upgrade50();
                germany.getVirus().upgrade50();
                greece.getVirus().upgrade50();
                italy.getVirus().upgrade50();
                uk.getVirus().upgrade50();
                ukraine.getVirus().upgrade50();
                poland.getVirus().upgrade50();
                france.getVirus().upgrade50();
                spain.getVirus().upgrade50();
                turkey.getVirus().upgrade50();

                money -= 70;
                if (money <= 70) {
                    view.getBuy4().setEnabled(false);
                }
                view.getCurrency().setText("Money: "+ money);
            }
        });
        view.getBuy5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getBuy5().setEnabled(false);
                vaccine.start(); //cure prototype
                v = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        view.cure.setText("Cure: "+vaccine.cureProgress+"%");
                        if (vaccine.cureProgress >= 100 && money >= 200)
                            view.getBuy6().setEnabled(true);
                    }
                });
                v.start();

                money -= 120;
//                if (money <= 120) {
//                    view.getBuy5().setEnabled(false);
//                }
                view.getCurrency().setText("Money: "+ money);
            }
        });
        view.getBuy6().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    romania.getVirus().setVirusProgress(0);
                    germany.getVirus().setVirusProgress(0);
                    greece.getVirus().setVirusProgress(0);
                    italy.getVirus().setVirusProgress(0);
                    uk.getVirus().setVirusProgress(0);
                    ukraine.getVirus().setVirusProgress(0);
                    poland.getVirus().setVirusProgress(0);
                    france.getVirus().setVirusProgress(0);
                    spain.getVirus().setVirusProgress(0);
                    turkey.getVirus().setVirusProgress(0);

                    view.getRomaniaButton().setEnabled(false);
                    view.getGermanyButton().setEnabled(false);
                    view.getGreeceButton().setEnabled(false);
                    view.getItalyButton().setEnabled(false);
                    view.getUkButton().setEnabled(false);
                    view.getUkraineButton().setEnabled(false);
                    view.getPolandButton().setEnabled(false);
                    view.getFranceButton().setEnabled(false);
                    view.getSpainButton().setEnabled(false);
                    view.getTurkeyButton().setEnabled(false);

                money -= 200;
                view.getCurrency().setText("Money: "+ money);
                view.getBuy6().setEnabled(false);

                    c.stop();
                    t.stop();
                    view.getCasesOverall().setText("Cases: 0");
                    virus.cancel();
                    CheckScore();
            }
        });
        view.getBuy7().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score += 100;

                money -= 100;
                if (money <= 100) {
                    view.getBuy7().setEnabled(false);
                }
                view.getCurrency().setText("Money: "+money);
            }
        });
        view.getBuy8().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                score += getRandomInteger(0, 1000);

                money -= 300;
                if (money <= 300) {
                    view.getBuy8().setEnabled(false);
                }
                view.getCurrency().setText("Money: "+money);
            }
        });

    }
}