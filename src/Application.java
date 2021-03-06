
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nishat
 */
public class Application extends javax.swing.JFrame {

    private Connection connection = null;
    private ResultSet resultSet = null;
    private PreparedStatement pst = null;

    /**
     * Creates new form Application
     */
    public Application() {
        initComponents();
        init();
        connection = DbConnection.connectDb();
        currentDate();
    }

    private void init() {
        setTitle("Recognizing Student's Learning-Main window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    public void currentDate() {
        //Static date and time
        Calendar cal = new GregorianCalendar();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        menuDate.setText("Current Date:" + day + "/" + (month + 1) + "/" + year);
        menuDate.setForeground(Color.blue);

        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        menuTime.setText("Current Time:" + hour + ":" + minute + ":" + second);
        menuTime.setForeground(Color.red);

    }

    public int findMax(int[] vals) {
        int max = -1;

        for (int d : vals) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnSignOut = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCollectTweet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaShow = new javax.swing.JTextArea();
        btnSaveData = new javax.swing.JButton();
        btnShowData = new javax.swing.JButton();
        btnAnalyze = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        mItSignOut = new javax.swing.JMenuItem();
        mItExit = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuDate = new javax.swing.JMenu();
        menuTime = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        btnSignOut.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        btnSignOut.setText(" Sign Out ");
        btnSignOut.setFocusable(false);
        btnSignOut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSignOut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSignOut);

        btnHelp.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Help.png"))); // NOI18N
        btnHelp.setText(" Help ");
        btnHelp.setFocusable(false);
        btnHelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHelp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHelp);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));

        btnCollectTweet.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCollectTweet.setForeground(new java.awt.Color(153, 0, 0));
        btnCollectTweet.setText("Collect Tweets");
        btnCollectTweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCollectTweetActionPerformed(evt);
            }
        });

        txtAreaShow.setColumns(20);
        txtAreaShow.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        txtAreaShow.setRows(5);
        jScrollPane1.setViewportView(txtAreaShow);

        btnSaveData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSaveData.setForeground(new java.awt.Color(153, 0, 0));
        btnSaveData.setText("Save Data");
        btnSaveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDataActionPerformed(evt);
            }
        });

        btnShowData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnShowData.setForeground(new java.awt.Color(153, 0, 0));
        btnShowData.setText("Show Data");
        btnShowData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDataActionPerformed(evt);
            }
        });

        btnAnalyze.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAnalyze.setForeground(new java.awt.Color(153, 0, 0));
        btnAnalyze.setText("Analyze");
        btnAnalyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalyzeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCollectTweet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShowData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAnalyze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnCollectTweet, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSaveData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnShowData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnalyze, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jMenu3.setText(" File ");

        mItSignOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mItSignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close.png"))); // NOI18N
        mItSignOut.setText("Sign Out");
        mItSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItSignOutActionPerformed(evt);
            }
        });
        jMenu3.add(mItSignOut);

        mItExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mItExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/exit.png"))); // NOI18N
        mItExit.setText("Exit");
        mItExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mItExitActionPerformed(evt);
            }
        });
        jMenu3.add(mItExit);

        jMenuBar2.add(jMenu3);

        jMenu1.setText(" About ");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/about.png"))); // NOI18N
        jMenuItem1.setText("About Developer");
        jMenu1.add(jMenuItem1);

        jMenuBar2.add(jMenu1);

        menuDate.setText(" Date ");
        jMenuBar2.add(menuDate);

        menuTime.setText(" Time ");
        jMenuBar2.add(menuTime);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mItSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItSignOutActionPerformed
        // TODO add your handling code here:
        try {
            close();
            LogIn obj = new LogIn();
            obj.setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);
        }/* finally {
         try {
         resultSet.close();
         pst.close();
         connection.close();
         } catch (Exception e) {
         JOptionPane.showMessageDialog(rootPane, e);
         }
         }*/
    }//GEN-LAST:event_mItSignOutActionPerformed

    private void mItExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mItExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mItExitActionPerformed

    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
        // TODO add your handling code here:
        try {
            close();
            LogIn obj = new LogIn();
            obj.setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e);
        } /*finally {
         try {
         resultSet.close();
         pst.close();
         connection.close();
         } catch (Exception e) {
         JOptionPane.showMessageDialog(rootPane, e);
         }
         }*/
    }//GEN-LAST:event_btnSignOutActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnCollectTweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCollectTweetActionPerformed
        // TODO add your handling code here:
        txtAreaShow.setFont(new Font("Monospaced", Font.PLAIN, 18));
        txtAreaShow.append("Collected Tweets\n===================\n");
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("P0fqd23Fqf4rxBjyX7jx3Sfp8")
                .setOAuthConsumerSecret("ukk5WQjVOoX6U3QF1Kr38f3mv4qrV0Bh7H8WshABgHnm66cPCY")
                .setOAuthAccessToken("716462892967538689-v1687NBnOxnEYrXkWCfPDiKznMIZ4Kg")
                .setOAuthAccessTokenSecret("LIWUWF7tQlF4GFlnOqNpL0HiUHd2BNF0bSSbk8xnj7AYk");

        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        Query query = new Query("#engineeringstudents ");
        int numberOfTweets = 5;
        long lastID = Long.MAX_VALUE;
        ArrayList<Status> tweets = new ArrayList<Status>();

        while (tweets.size() < numberOfTweets) {
            if (numberOfTweets - tweets.size() > 100) {
                query.setCount(100);
            } else {
                query.setCount(numberOfTweets - tweets.size());
            }
            try {
                QueryResult result = twitter.search(query);
                tweets.addAll(result.getTweets());
                System.out.println("Gathered " + tweets.size() + " tweets" + "\n");
                for (Status t : tweets) {
                    if (t.getId() < lastID) {
                        lastID = t.getId();
                    }
                }

            } catch (TwitterException te) {
                System.out.println("Couldn't connect: " + te);
            };
            query.setMaxId(lastID - 1);
        }
        for (int i = 0; i < tweets.size(); i++) {
            Status t = (Status) tweets.get(i);

            // GeoLocation loc = t.getGeoLocation();
            String user = t.getUser().getScreenName();
            String msg = t.getText();
            //String time = "";
            //if (loc!=null) {
            //Double lat = t.getGeoLocation().getLatitude();
            //Double lon = t.getGeoLocation().getLongitude();*/
            System.out.println(i + " USER: " + user + " wrote: " + msg + "\n");

            txtAreaShow.append(i + " USER: " + user + " wrote: " + msg + "\n");

            //insert values into database table (Data_Table)
            try {
                String sql = "update Data_Table set col" + i + "='" + msg + "' where col_id ='1'";
                pst = connection.prepareStatement(sql);
                pst.execute();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    }//GEN-LAST:event_btnCollectTweetActionPerformed

    private void btnShowDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDataActionPerformed
        // TODO add your handling code here:
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "DataSet.arff");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error");
        }
    }//GEN-LAST:event_btnShowDataActionPerformed

    private void btnAnalyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalyzeActionPerformed
        txtAreaShow.setFont(new Font("Monospaced", Font.PLAIN, 13));
        try {
            // TODO add your handling code here:
            //reads the arff file
            BufferedReader breader = null;
            breader = new BufferedReader(new FileReader("DataSet.arff"));

            //if 40 attributes availabe then  39 will be the class index/attribuites(yes/no)
            Instances train = new Instances(breader);
            train.setClassIndex(train.numAttributes() - 1);
            breader.close();

            //
            NaiveBayes nB = new NaiveBayes();
            nB.buildClassifier(train);

            Evaluation eval = new Evaluation(train);
            eval.crossValidateModel(nB, train, 10, new Random(1));

            System.out.println("Run Information\n=====================");
            System.out.println("Scheme: " + train.getClass().getName());
            System.out.println("Relation: ");

            System.out.println("\nClassifier Model(full training set)\n===============================");
            System.out.println(nB);

            System.out.println(eval.toSummaryString("\nSummary Results\n==================", true));
            System.out.println(eval.toClassDetailsString());
            System.out.println(eval.toMatrixString());

            //System.out.println(eval.fMeasure(1)+" "+eval.precision(1)+" "+eval.recall(1));
            //System.out.println(eval.toCumulativeMarginDistributionString());
            //txtArea output 
            txtAreaShow.append("\n\n\n");
            txtAreaShow.append("Run Information\n===================\n");
            txtAreaShow.append("Scheme: " + train.getClass().getName());

            txtAreaShow.append("\n\nClassifier Model(full training set)"
                    + "\n======================================\n");
            txtAreaShow.append("" + nB);

            txtAreaShow.append(eval.toSummaryString("\n\nSummary Results\n==================\n", true));
            txtAreaShow.append(eval.toClassDetailsString());
            txtAreaShow.append(eval.toMatrixString());
            txtAreaShow.append("\n\n\n");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalyzeActionPerformed

    private void btnSaveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDataActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < 5; i++) {
            String txtGF = null;
            String txtBF = null;
            String txtDepStatus = null;

            int[] varBF = new int[4];
            int[] varGF = new int[3];
            varBF[0] = 0;
            varBF[1] = 0;
            varBF[2] = 0;
            varBF[3] = 0;
            varGF[0] = 0;
            varGF[1] = 0;
            varGF[2] = 0;
            int varBFCount = 0;
            int varGFCount = 0;

            try {
                String sql = "select col" + i + " from Data_Table where col_id='1'";
                pst = connection.prepareStatement(sql);
                pst.execute();
                resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    String tweet = resultSet.getString("col" + i + "");
                    //System.out.println(tweet+"\n*********\n");

                    //badFeelings counts-heavy study load, lack of social engagement,
                    //                   negative emotion, sleep problems
                    if (tweet.contains("hour")) {
                        varBF[0]++;
                    }
                    if (tweet.contains("project")) {
                        varBF[0]++;
                    }
                    if (tweet.contains("report")) {
                        varBF[0]++;
                    }
                    if (tweet.contains("lab")) {
                        varBF[0]++;
                    }
                    if (tweet.contains("exam")) {
                        varBF[0]++;
                    }
                    if (tweet.contains("homework")) {
                        varBF[0]++;
                    }
                    if (tweet.contains("study")) {
                        varBF[0]++;
                    }
                    if (tweet.contains("world")) {
                        varBF[1]++;
                    }
                    if (tweet.contains("world")) {
                        varBF[1]++;
                    }
                    if (tweet.contains("hidden")) {
                        varBF[1]++;
                    }
                    if (tweet.contains("life")) {
                        varBF[1]++;
                    }
                    if (tweet.contains("freedom")) {
                        varBF[1]++;
                    }
                    if (tweet.contains("time")) {
                        varBF[1]++;
                    }
                    if (tweet.contains("work")) {
                        varBF[1]++;
                    }
                    if (tweet.contains("suck")) {
                        varBF[1]++;
                    }
                    if (tweet.contains("social")) {
                        varBF[1]++;
                    }
                    if (tweet.contains("why")) {
                        varBF[1]++;
                    }
                    if (tweet.contains("angry")) {
                        varBF[2]++;
                    }
                    if (tweet.contains("sick")) {
                        varBF[2]++;
                    }
                    if (tweet.contains("depression")) {
                        varBF[2]++;
                    }
                    if (tweet.contains("death")) {
                        varBF[2]++;
                    }
                    if (tweet.contains("play")) {
                        varBF[2]++;
                    }
                    if (tweet.contains("disappointment")) {
                        varBF[2]++;
                    }
                    if (tweet.contains("goodbye")) {
                        varBF[2]++;
                    }
                    if (tweet.contains("nervous")) {
                        varBF[2]++;
                    }
                    if (tweet.contains("dying")) {
                        varBF[2]++;
                    }
                    if (tweet.contains("stress")) {
                        varBF[3]++;
                    }
                    if (tweet.contains("nightmare")) {
                        varBF[3]++;
                    }
                    if (tweet.contains("sleep")) {
                        varBF[3]++;
                    }
                    if (tweet.contains("napping")) {
                        varBF[3]++;
                    }
                    if (tweet.contains("schedule")) {
                        varBF[3]++;
                    }

                    //goodFeelings counts-proud,curious,motivated
                    if (tweet.contains("job")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("experience")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("happy")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("offer")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("good")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("love")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("chose")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("success")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("school")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("college")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("university")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("campus")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("great")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("answer")) {
                        varGF[0]++;
                    }
                    if (tweet.contains("science")) {
                        varGF[1]++;
                    }
                    if (tweet.contains("tech")) {
                        varGF[1]++;
                    }
                    if (tweet.contains("carrer")) {
                        varGF[1]++;
                    }
                    if (tweet.contains("software")) {
                        varGF[1]++;
                    }
                    if (tweet.contains("conference")) {
                        varGF[1]++;
                    }
                    if (tweet.contains("pen")) {
                        varGF[2]++;
                    }
                    if (tweet.contains("paper")) {
                        varGF[2]++;
                    }
                    if (tweet.contains("solution")) {
                        varGF[2]++;
                    }
                    if (tweet.contains("book")) {
                        varGF[2]++;
                    }
                    if (tweet.contains("semester")) {
                        varGF[2]++;
                    }
                    if (tweet.contains("journey")) {
                        varGF[2]++;
                    }
                    if (tweet.contains("learn")) {
                        varGF[2]++;
                    }

                    varBFCount = varBF[0] + varBF[1] + varBF[2] + varBF[3];
                    varGFCount = varGF[0] + varGF[1] + varGF[2];
                    System.out.println(varBFCount + "========= " + varGFCount);

                    //this section is for writing in the file
                    if (varBFCount == 0 && varGFCount == 0) {
                        continue;
                    } else {
                        int bFMax = findMax(varBF);
                        int gFMax = findMax(varGF);
                        //System.out.println("******* "+bFMax+" ****** "+gFMax);

                        //setting the text for bad feelings to write in the file
                        if (varBF[0] == bFMax) {
                            txtBF = "heavyStudyLoad";
                        } else if (varBF[1] == bFMax) {
                            txtBF = "lackOfSocial";
                        } else if (varBF[2] == bFMax) {
                            txtBF = "negativeEmo";
                        } else {
                            txtBF = "sleepProb";
                        }

                        //setting the text for good feelings to write in the file
                        if (varGF[0] == gFMax) {
                            txtGF = "proud";
                        } else if (varGF[1] == gFMax) {
                            txtGF = "curious";
                        } else {
                            txtGF = "motivated";
                        }

                        //setting the text for depression status to write in the file
                        if (varBFCount > varGFCount) {
                            txtDepStatus = "yes";
                        } else {
                            txtDepStatus = "no";
                        }

                        //now code for writing in the file
                        try {
                            String data = txtBF + "," + txtGF + "," + txtDepStatus;

                            File file = new File("DataSet.arff");

                            //if file doesnt exists, then create it
                            if (!file.exists()) {
                                file.createNewFile();
                            }

                            //true = append file
                            FileWriter fileWritter = new FileWriter(file.getName(), true);
                            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                            bufferWritter.newLine();
                            bufferWritter.write(data);
                            bufferWritter.close();

                            System.out.println("Done");

                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(rootPane, "Cannot write to file!");
                        }
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
        JOptionPane.showMessageDialog(rootPane, "Data saved!");
    }//GEN-LAST:event_btnSaveDataActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Application().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalyze;
    private javax.swing.JButton btnCollectTweet;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnSaveData;
    private javax.swing.JButton btnShowData;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mItExit;
    private javax.swing.JMenuItem mItSignOut;
    private javax.swing.JMenu menuDate;
    private javax.swing.JMenu menuTime;
    private javax.swing.JTextArea txtAreaShow;
    // End of variables declaration//GEN-END:variables
}
