
package com.mycompany.roulette01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class RouletteClass1 {
    public static File file=new File("InputFile1.txt"); 
    public static File inputFile2=new File("InputFile2.txt"); 
    public static void loadPlayers(){
        try  
        {   
            if(!file.exists()) { 
            file.createNewFile();
            FileWriter writer = new FileWriter("InputFile1.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Tiki_Monkey ");
            bufferedWriter.newLine();
            bufferedWriter.write("Barbara");
            bufferedWriter.close();
        }
    }  
        catch(IOException e)  
        {  
            e.printStackTrace();  
        }
    }
    
    public static void totalsFile(){
        try  
        {   
            if(!inputFile2.exists()) { 
                inputFile2.createNewFile();
            }
        }  
        catch(IOException e)  
        {  
            e.printStackTrace();  
        }
    }
    

    public static class  PlayOutcome{
        PlayOutcome(){};
        private String playerName="";
        private Object bet=""; 
        private String outcome="";
        private Double winnings=.0;
        private Integer TotalBets=0;
        private Integer TotalWins=0;
        
        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

        public void setBet(Object bet) {
            this.bet = bet;
        }

        public void setOutcome(String outcome) {
            this.outcome = outcome;
        }

        public void setWinnings(Double winnings) {
            this.winnings = winnings;
        }

        public void setTotalBets(Integer TotalBets) {
            this.TotalBets = TotalBets;
        }

        public void setTotalWins(Integer TotalWins) {
            this.TotalWins = TotalWins;
        }

        public Object getBet() {
            return bet;
        }

        public String getOutcome() {
            return outcome;
        }

        public Double getWinnings() {
            return winnings;
        }

        public Integer getTotalBets() {
            return TotalBets;
        }

        public Integer getTotalWins() {
            return TotalWins;
        }
        public PlayOutcome(String playerName, String bet, String outcome, Double winnings) {
            this.playerName = playerName;
            this.bet = bet;
            this.outcome = outcome;
            this.winnings = winnings;
        }
        
        
        
    }
    
    public static void main(String args[])  
    {  
    try  
    {  
        loadPlayers();
        FileReader fr=new FileReader(file);   //reads the file  
        BufferedReader br=new BufferedReader(fr); 
        StringBuffer sb=new StringBuffer();    
        String line;
        
    int playerCount=0;
    List<PlayOutcome> ppp=new ArrayList<>();
        Object GamePlayers[][]=new Object[playerCount][4];
        PlayOutcome pl;
        while((line=br.readLine())!=null)  
        {
            sb.append(line);      
            sb.append("\n");
            pl=new PlayOutcome();
            pl.playerName=line.trim();
            ppp.add(pl);
        }  
        char play='y';

        while (play == 'y' || play == 'Y' )
        {
            
            System.out.println("-------------------------");
            System.out.println("Players");
            System.out.println("-------------------------");
            //System.out.println(sb.toString()); 
            for(int x=0;x<ppp.size();x++){
                System.out.println(ppp.get(x).getPlayerName());//GamePlayers[x][0]);
            }
            System.out.println("-------------------------");
            System.out.println("Please enter your name:");        
            Scanner scan=new Scanner(System.in);
            String playerName=scan.next();
            boolean pFound=false;
            int playerIndex=-1;
            for(int y=0;y<ppp.size();y++){
               if(playerName.compareToIgnoreCase(ppp.get(y).getPlayerName())==0){
                   pFound=true;
                   playerIndex=y;
                   break;
               }
            }

            /*
             while (pFound==false)
                {
                   System.out.println("Please enter option 1, 2 or 3: "); 
                    choice = scan.nextInt(); 
                   if(choice==1 || choice==2){
                        ppp.get(playerIndex).bet=choice;
                     break;
                   }
                 }
             */
            /*
            if(pFound==false){
                System.out.println("Player :"+playerName+" NOT Found");
                break;
            }
            else{
                System.out.println(" Hi "+playerName);
            }
            */
            int number;
            int rouletteNum;
            double total = 500;
            double amount;
            char res = 'y';
            int choice,spin = 0;
            Random generator = new Random();
            while (res == 'y' || res == 'Y' && total <= 0)
            {
                choice = -1;
                number = 0;
                System.out.println("Place your bet on: ");
                System.out.println("1 - Even\n2 - Odd\n3 - Number\n");
                choice = scan.nextInt(); 
                
                while (choice < 1 || choice > 3)
                {
                   System.out.println("Please enter option 1, 2 or 3: "); 
                    choice = scan.nextInt(); 
                   if(choice==1 || choice==2){
                        ppp.get(playerIndex).setBet(choice);
                     break;
                   }
                 }
            String outcome="";
            String bet="";
                 if (choice ==3)  
                 {
                   System.out.println("Place your bet on number(1-36): "); 
                   number = scan.nextInt();
                   if(number >= 1 && number <= 36)
                   {
                       ppp.get(playerIndex).setBet(number);
                   }
                   else{
                      while (number < 1 || number > 36)
                      {        
                            ppp.get(playerIndex).setBet(scan.nextInt());
                      } 
                   }  
                 }
                 else{
                     if(choice==1){
                         bet="EVEN";
                        ppp.get(playerIndex).setBet("EVEN"); 
                     }
                     else{
                         bet="ODD";
                        ppp.get(playerIndex).setBet("ODD");
                     }
                     
                 }
                 System.out.println("Enter your bet amount: ");   
                 amount = scan.nextDouble();
                 rouletteNum = generator.nextInt(37);
                 spin++;
                 System.out.println("Winning Number: " + rouletteNum);


                 if (choice == 3)
                 {
                     if(number==rouletteNum){
                         outcome="WIN";
                         ppp.get(playerIndex).setOutcome("WIN");
                         ppp.get(playerIndex).setWinnings(amount);
                         ppp.get(playerIndex).setTotalWins(ppp.get(playerIndex).getTotalWins()+1);
                     }
                     else{
                         outcome="LOSE";
                         ppp.get(playerIndex).outcome="LOSE";
                     }
                     bet=number+"";
                 }
                 else
                 {
                     int remainder=  rouletteNum % 2;
                     if(choice==1 && remainder==0){
                        outcome="WIN";
                        ppp.get(playerIndex).outcome="WIN";
                        ppp.get(playerIndex).setWinnings(amount);
                        ppp.get(playerIndex).setTotalWins(ppp.get(playerIndex).getTotalWins()+1);
                        //ppp.get(playerIndex).winnings+=amount;
                     }
                     else if(choice==2 && (remainder==1 ||rouletteNum==1)){
                        outcome="WIN";
                        ppp.get(playerIndex).outcome="WIN";
                        ppp.get(playerIndex).setWinnings(amount);
                        ppp.get(playerIndex).setTotalWins(ppp.get(playerIndex).getTotalWins()+1);
                        //ppp.get(playerIndex).winnings+=amount;
                     }
                     else{
                        outcome="LOSE"; 
                        ppp.get(playerIndex).outcome="LOSE";
                     }
                 }
        ppp.get(playerIndex).setTotalBets(ppp.get(playerIndex).getTotalBets()+1);
               System.out.println("Player\tBet\tOutcome\tWinnings");
               System.out.println("-----");
               System.out.println(ppp.get(playerIndex).getPlayerName()+"\t"
                     +ppp.get(playerIndex).getBet()+"\t"
                    +ppp.get(playerIndex).getOutcome()+"\t"
                    +ppp.get(playerIndex).getWinnings()+"\t"
                );
               System.out.println("\n Would you like to play another game? (y/n) ");
               res = scan.next().charAt(0);    
           }
            System.out.println("Next player? (y/n) )" );
            play = scan.next().charAt(0);
            if(play!='n'||play!='N'){
                //
               System.out.println("Player\tTotal Win\t Total Bet");
               System.out.println("-----");
                for(int z=0;z<ppp.size();z++){
                    System.out.println(ppp.get(z).getPlayerName()+"\t"+ppp.get(z).getTotalWins()+"\t"+ppp.get(z).getTotalBets());
                }
                //      
                totalsFile();
                FileWriter writer = new FileWriter("InputFile2.txt", false);
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                for(int z=0;z<ppp.size();z++){
                    bufferedWriter.write(ppp.get(z).getPlayerName()+","+ppp.get(z).getTotalWins()+","+ppp.get(z).getTotalBets());
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
            }
        }
        fr.close();    
        }  
        catch(IOException e)  
        {  
            e.printStackTrace();  
        }  
    }  
}  