package com.example.sai.facedetector.GraphicHelper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;

public class RectOverlay extends GraphicOverlay.Graphic{

    private int RECT_COLOR = Color.RED;
    private float STROKE_WIDTH = 4.0f;
    private Paint rectpaint;
    private GraphicOverlay graphicOverlay;
    private Rect rect;
    public RectOverlay(GraphicOverlay graphicOverlay,Rect rect) {

        super(graphicOverlay);
        rectpaint = new Paint();
        rectpaint.setColor(RECT_COLOR);
        rectpaint.setStyle(Paint.Style.STROKE);
        rectpaint.setStrokeWidth(STROKE_WIDTH);

        this.graphicOverlay = graphicOverlay;
        this.rect = rect;
        postInvalidate();


    }


    @Override
    public void draw(Canvas canvas) {
        RectF rectf = new RectF(rect);
        rectf.left = translateX(rectf.left);
        rectf.right = translateX(rectf.right);
        rectf.top = translateY(rectf.top);
        rectf.bottom = translateY(rectf.bottom);

        canvas.drawRect(rectf,rectpaint);
    }
}
