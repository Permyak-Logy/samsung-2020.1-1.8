package ru.max.sumsung.hw17;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Circle2D {
    float radius;
    int color;

    float x, y;
    float[] v = new float[2];
    float[] a = {10, 10};

    public Circle2D(){
        x = (float) (Math.random() * 100);
        y = (float) (Math.random() * 100);
        v[0] = (float) (Math.random() * 100 % 10 - 5);
        v[0] = (float) (Math.random() * 100 % 10 - 5);
        radius = 20;
        color = Color.BLUE;
    }

    public Circle2D(float x, float y, float radius, int color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }
    public void update(MyView view, int tick) {
        double t = tick / 1000.;

        x += v[0] * t + a[0] * t * t / 2;
        y += v[1] * t + a[1] * t * t / 2;

        v[0] += a[0] * t;
        v[1] += a[1] * t;

        if (x >= view.getWidth() || x <= 0) {
            v[0] /= -2;
            a[0] *= -1;
            color = Color.RED;
            if (x <= 0)
                x = 0;
            else
                x = view.getWidth();
        } if (y >= view.getHeight() || y <= 0) {
            v[1] /= -2;
            a[1] *= -1;
            color = Color.GREEN;
            if (y <= 0)
                y = 0;
            else
                y = view.getHeight();
        }
    }

    public boolean onDraw(Canvas canvas, Paint paint) {
        int old_color = paint.getColor();
        paint.setColor(color);
        canvas.drawCircle(x, y, radius, paint);
        paint.setColor(old_color);
        return true;
    }
}
