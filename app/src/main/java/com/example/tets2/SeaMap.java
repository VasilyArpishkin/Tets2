package com.example.tets2;

public class SeaMap {
    private int[] field2;
    private int[] field1;
    public SeaMap() {
        field2 = new int[100];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                field2[i*10+j]= R.drawable.cell;
            }
        }
        field1= new int[100];
        for(int i=0; i<10;i++){
            for(int j=0;j<10;j++){
                field1[i*10+j]=R.drawable.cell;
            }
        }
    }
    public void shootEnemy(int row, int col, String result) {
        if (result.equals("miss")==true) {
            field2[row*10+col] = R.drawable.dot;
        } else if (result.equals("hit")==true) {
            field2[row*10+col]  = R.drawable.hit;
        } else if (result.equals("sink")==true) {
            for (int i = Math.max(0, row - 1); i < Math.min(10, row + 2); i++) {
                for (int j = Math.max(0, col - 1); j < Math.min(10, col + 2); j++) {
                    if (field2[i*10+j]  == R.drawable.cell) {
                        field2[i*10+j]  = R.drawable.dot;
                    }
                }
            }
            field2[row*10+col] = R.drawable.hit;
            for (int c = 0; c < field2.length; c++) { // Если корабль расположен горизонтально
                if (field2[row*10+c] == R.drawable.hit) {
                    col = c;
                    for (int h = Math.max(0, row - 1); h < Math.min(10, row + 2); h++) {
                        for (int u = Math.max(0, col - 1); u < Math.min(10, col + 2); u++) {
                            if (field2[h*10+u] == R.drawable.cell) {
                                field2[h*10+u] = R.drawable.dot;
                            }
                        }
                    }
                }
            }
            for (int r = 0; r < field2.length; r++) { // Если корабль расположен вертикально
                if (field2[r*10+col] == R.drawable.hit) {
                    row = r;
                    for (int v = Math.max(0, row - 1); v < Math.min(10, row + 2); v++) {
                        for (int u = Math.max(0, col - 1); u < Math.min(10, col + 2); u++) {
                            if (field2[v*10+u] == R.drawable.cell) {
                                field2[v*10+u] = R.drawable.dot;
                            }
                        }
                    }
                }
            }
        }
    }
    public void shootPlayer(int row, int col, String result){
        if(result.equals("miss")==true)field1[row*10+col]=R.drawable.dot;
        else if(result.equals("hit")==true)field1[row*10+col]=R.drawable.hit;
        else if(result.equals("sink")==true){
            for (int i = Math.max(0, row - 1); i < Math.min(10, row + 2); i++) {
                for (int j = Math.max(0, col - 1); j < Math.min(10, col + 2); j++) {
                    if (field1[i*10+j]  == R.drawable.cell) {
                        field1[i*10+j]  = R.drawable.dot;
                    }
                }
            }
            field1[row*10+col] = R.drawable.hit;
            for (int c = 0; c < field1.length; c++) { // Если корабль расположен горизонтально
                if (field1[row*10+c] == R.drawable.hit) {
                    col = c;
                    for (int h = Math.max(0, row - 1); h < Math.min(10, row + 2); h++) {
                        for (int u = Math.max(0, col - 1); u < Math.min(10, col + 2); u++) {
                            if (field1[h*10+u] == R.drawable.cell) {
                                field1[h*10+u] = R.drawable.dot;
                            }
                        }
                    }
                }
            }
            for (int r = 0; r < field1.length; r++) { // Если корабль расположен вертикально
                if (field1[r*10+col] == R.drawable.hit) {
                    row = r;
                    for (int v = Math.max(0, row - 1); v < Math.min(10, row + 2); v++) {
                        for (int u = Math.max(0, col - 1); u < Math.min(10, col + 2); u++) {
                            if (field1[v*10+u] == R.drawable.cell) {
                                field1[v*10+u] = R.drawable.dot;
                            }
                        }
                    }
                }
            }
        }
    }

//    public String win() {
//        int hit1 = 0, hit2 = 0;
//        for (int i = 0; i < 100; i++) {
//            if (field2[i] == R.drawable.hit) hit2++;
//            if (field1[i] == R.drawable.hit) hit1++;
//        }
//        if(hit1==20) {
//            return "Player win";
//        }
//        else if(hit2==20){
//            return "Computer win";
//        }
//    }


//    public int cell(int row, int col) {
//        return field[row*10+col];
//    }
}