package com.example.tets2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Battleship extends AppCompatActivity {
    private Button BT1, BT2;
    private TextView TV;
    @Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BT1 = findViewById(R.id.BTcomputer);
        BT2 = findViewById(R.id.BTplayer);
        BT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Battleship.this, ComputerGame.class);
                startActivity(intent);
            }
        });
        BT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Battleship.this, PlayerGame.class);
                startActivity(intent);
            }
        });
    }

}