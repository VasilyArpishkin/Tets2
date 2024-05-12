package com.example.tets2;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ComputerGame extends AppCompatActivity {
    private int[] mThumbIds1 = {R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell};
    private int[] mThumbIds2 = {R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell, R.drawable.cell, R.drawable.cell,
            R.drawable.cell};
    private ImageAdapter1 imageAdapter1 = new ImageAdapter1(this, mThumbIds1);
    private ImageAdapter2 imageAdapter2 = new ImageAdapter2(this, mThumbIds2);
    private Button PL;
    private boolean isClicked=false;

    //TextView mSelectText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.computergame);
        //mSelectText = (TextView) findViewById(R.id.info);
        GridView gridview1 = (GridView) findViewById(R.id.GD);
        gridview1.setAdapter(imageAdapter1);
        GridView gridview2 = (GridView) findViewById(R.id.GD2);
        gridview2.setAdapter(imageAdapter2);
        int sum=1;
        gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(isClicked){
                    chooseArea(position);
                } else {
                    setArea(position);
                    isClicked=true;
                }
            }
        });
    }
    public void clearMap() {
        for (int i = 0; i < 99; i++) {
            if (mThumbIds1[i] == R.drawable.sea) {
                mThumbIds1[i] = R.drawable.cell;
            }
        }
        imageAdapter1.notifyDataSetChanged();
    }
    public void chooseArea(int position){
        int a = 0;
        Bitmap ship2 = (Bitmap) imageAdapter1.getItem(position);
        Bitmap sea, ship1, firstship=(Bitmap) BitmapFactory.decodeResource(getResources(), R.drawable.firstplaceship);
        for(int i=0;i<100;i++){
            ship1=(Bitmap) imageAdapter1.getItem(i);
            if(ship1==firstship)a=i;
        }
        sea=BitmapFactory.decodeResource(getResources(), R.drawable.sea);
        if(ship2==sea){
            changeImage(position, R.drawable.firstplaceship);
            if(a>position && a/10==position/10){
                for(int i = position; i<a; i++){
                    changeImage(i, R.drawable.firstplaceship);
                }
                clearMap();
            }
            else if(a<position && a/10==position/10){
                for(int i=position; i>a; i--){
                    changeImage(i, R.drawable.firstplaceship);
                }
                clearMap();
            }
            else if(a>position && a/10>position/10){
                for(int i=position+10; i<=a;i+=10){
                    changeImage(i, R.drawable.firstplaceship);
                }
                clearMap();
            }
            else if(a<position && a/10<position/10){
                for(int i=position-10; i>=a;i-=10){
                    changeImage(i, R.drawable.firstplaceship);
                }
                clearMap();
            }
            else clearMap();
        }
        else {
            TextView textview = findViewById(R.id.message);
            textview.setVisibility(View.VISIBLE);
        }
        imageAdapter1.notifyDataSetChanged();
    }
    public void setArea(int position) {
        changeImage(position, R.drawable.firstplaceship);
        int countL = position - position / 10 * 10;
        int countR = position / 10 * 10 + 9 - position;
        int countT = position / 10;
        int countB = 9 - position / 10;
        if (countR < 4) {
            for (int i = position; i < position + countR; i++) {
                mThumbIds1[i + 1] = R.drawable.sea;
            }
        } else {
            mThumbIds1[position + 1] = R.drawable.sea;
            mThumbIds1[position + 2] = R.drawable.sea;
            mThumbIds1[position + 3] = R.drawable.sea;
        }
        if (countL < 4) {
            for (int i = position; i > position - countL; i--) {
                mThumbIds1[i - 1] = R.drawable.sea;
            }
        } else {
            mThumbIds1[position - 1] = R.drawable.sea;
            mThumbIds1[position - 2] = R.drawable.sea;
            mThumbIds1[position - 3] = R.drawable.sea;
        }
        if (countT < 4) {
            int c = position;
            for (int i = countT; i > 0; i--) {
                mThumbIds1[c - 10] = R.drawable.sea;
                c -= 10;
            }
        } else {
            mThumbIds1[position - 10] = R.drawable.sea;
            mThumbIds1[position - 20] = R.drawable.sea;
            mThumbIds1[position - 30] = R.drawable.sea;
        }
        if (countB < 4) {
            int c = position;
            for (int i = position / 10; i < 9; i++) {
                mThumbIds1[c + 10] = R.drawable.sea;
                c += 10;
            }
        } else {
            mThumbIds1[position + 10] = R.drawable.sea;
            mThumbIds1[position + 20] = R.drawable.sea;
            mThumbIds1[position + 30] = R.drawable.sea;
        }
        imageAdapter1.notifyDataSetChanged();
    }
    int []arr={4,3,3,2,2,2,1,1,1};
    public void changeImage(int position, int newImageResource) {
        mThumbIds1[position] = newImageResource;
        imageAdapter1.notifyDataSetChanged();
    }
}
