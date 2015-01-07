/*
Copyright 2015 Sunghoon Kang (devholic@plusquare.com)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.plusquare.clockview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ClockView extends View {
    private Paint p;
    int c, h, m;

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ClockView);
        c = arr.getColor(R.styleable.ClockView_clockColor, Color.parseColor("#F44336"));
        h = arr.getInteger(R.styleable.ClockView_h, 17);
        m = arr.getInteger(R.styleable.ClockView_m, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        int center_w = (getMeasuredWidth() / 2);
        int center_h = (getMeasuredHeight() / 2);
        int len = (getMeasuredWidth() / 2) - 3;
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setStyle(Paint.Style.FILL);
        p.setColor(c);
        canvas.drawCircle(center_w, center_h, len, p);
        p.setColor(Color.WHITE);
        canvas.drawCircle(center_w, center_h, (float) (int) (len * 0.8), p);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth((float) (int) (len * 0.2));
        p.setStrokeJoin(Paint.Join.ROUND);
        p.setStrokeCap(Paint.Cap.ROUND);
        p.setColor(c);
        //p.setColor(getResources().getColor(R.color.textColorSecondary));
        canvas.drawLine(center_w, center_h, center_w + getMinuteX(len), center_h + getMinuteY(len), p);
        //p.setColor(getResources().getColor(R.color.textColorPrimary));
        canvas.drawLine(center_w, center_h, center_w + getHourX(len), center_h + getHourY(len), p);
    }

    private float getMinuteX(int l) {
        int c = 0;
        if (m < 15) {
            c = m + 45;
        } else {
            c = m - 15;
        }
        double angle = Math.toRadians(c * 6);
        return (float) (0.6 * l * Math.cos(angle));
    }

    private float getMinuteY(int l) {
        int c = 0;
        if (m < 15) {
            c = m + 45;
        } else {
            c = m - 15;
        }
        double angle = Math.toRadians(c * 6);
        return (float) (0.6 * l * Math.sin(angle));
    }

    private float getHourX(int l) {
        double angle = Math.toRadians(((h * 60) + m) / 2 - 90);
        return (float) (0.4 * l * Math.cos(angle));
    }

    private float getHourY(int l) {
        double angle = Math.toRadians(((h * 60) + m) / 2 - 90);
        return (float) (0.4 * l * Math.sin(angle));
    }


}
