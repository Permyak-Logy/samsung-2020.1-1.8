package ru.max.sumsung.hw17;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    Paint paint = new Paint();
    Circle2D[] arrayCircleList;
    float[] _remember = new float[2];
    float[] _delta = new float[2];

    public MyView(Context context, int countOfCircle) {
        super(context);
        arrayCircleList = new Circle2D[countOfCircle];
        for (int i = 0; i < arrayCircleList.length; i++) {
            arrayCircleList[i] = new Circle2D();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Circle2D circle : arrayCircleList) {
            circle.update(this, 45);
            circle.onDraw(canvas, paint);
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (Circle2D obj : arrayCircleList) {
                    obj.v[0] = event.getX() - obj.x;
                    obj.v[1] = event.getY() - obj.y;
                }
                break;
            case MotionEvent.ACTION_UP:
                for (Circle2D obj : arrayCircleList) {
                    obj.v[0] = -event.getX() + obj.x;
                    obj.v[1] = -event.getY() + obj.y;
                }
                break;
        }

        return true;
    }
}
