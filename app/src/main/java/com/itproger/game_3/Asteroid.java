package com.itproger.game_3;

import android.content.Context;

import java.util.Random;

public class Asteroid extends SpaceBody {

    private int radius = 2;
    private float minSpeed = (float) 0.1;
    private float maxSpeed = (float) 0.5;


    public Asteroid(Context context) {
        Random random = new Random();

        bitmapId = R.drawable.asteroid;
        y = 0;
        x = random.nextInt(GameView.maxX) - radius;
        size = radius * 2;
        speed = minSpeed + (maxSpeed - minSpeed) * random.nextFloat();

        init(context);
    }

    @Override
    public void update() {
        y += speed;
    }

    public boolean isCollision(float shipX, float shipY, float shipSize) {
        return !(((x + size) < shipX) || (x > (shipX + shipSize)) || ((y + size) < shipY) || (y > (shipY + shipSize)));
    }
}
