package com.example.sabina.tennisscorekeeper.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sabina.tennisscorekeeper.R;

public class MainActivity extends AppCompatActivity {

    private int player1GameScore;
    private int player1SetScore;
    private int player1Fault;
    private int player2GameScore;
    private int player2SetScore;
    private int player2Fault;

    private TextView player1Game;
    private TextView player1Set;
    private TextView player2Game;
    private TextView player2Set;
    private TextView faultP1;
    private TextView faultP2;

    private void incrementScorePlayer1(){
        if (player1GameScore == 0){
            player1GameScore = 15;
        } else if (player1GameScore == 15){
            player1GameScore = 30;
        } else if (player1GameScore == 30){
            player1GameScore = 40;
        } else {
            player1GameScore = 0;
            player1SetScore += 1;
        }
    }

    private void incrementScorePlayer2(){
        if (player2GameScore == 0){
            player2GameScore = 15;
        } else if (player2GameScore == 15){
            player2GameScore = 30;
        } else if (player2GameScore == 30){
            player2GameScore = 40;
        } else {
            player2GameScore = 0;
            player2SetScore += 1;
        }
    }

    private void resetScores(){
        player1GameScore = 0;
        player1SetScore = 0;
        player1Fault = 0;
        player2GameScore = 0;
        player2SetScore = 0;
        player2Fault = 0;
    }

    private void displayScore1(){
        player1Game.setText(String.valueOf(player1GameScore));
        player1Set.setText(String.valueOf(player1SetScore));
    }

    private void displayScore2(){
        player2Game.setText(String.valueOf(player2GameScore));
        player2Set.setText(String.valueOf(player2SetScore));
    }

    private void displayFault1(){
        faultP1.setText(String.valueOf(player1Fault));
        if (player1Fault == 0){
            faultP1.setTextColor(Color.BLACK);
        } else {
            faultP1.setTextColor(Color.RED);
        }
    }

    private void displayFault2(){
        faultP2.setText(String.valueOf(player2Fault));
        if (player2Fault == 0){
            faultP2.setTextColor(Color.BLACK);
        } else {
            faultP2.setTextColor(Color.RED);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetScores();
        initTextViews();
    }

    private void initTextViews(){
        player1Game = findViewById(R.id.player1_game);
        player1Set = findViewById(R.id.player1_set);
        player2Game = findViewById(R.id.player2_game);
        player2Set = findViewById(R.id.player2_set);
        faultP1 = findViewById(R.id.player1_fault);
        faultP2 = findViewById(R.id.player2_fault);
    }

    public void addPointToPlayer1(View view) {
        incrementScorePlayer1();
        displayScore1();
    }

    public void addFaultToPlayer1(View view) {
        player1Fault += 1;
        displayFault1();
    }

    public void addPointToPlayer2(View view) {
        incrementScorePlayer2();
        displayScore2();
    }

    public void addFaultToPlayer2(View view) {
        player2Fault += 1;
        displayFault2();
    }

    public void reset(View view) {
        resetScores();
        displayScore1();
        displayFault1();
        displayScore2();
        displayFault2();
    }
}
