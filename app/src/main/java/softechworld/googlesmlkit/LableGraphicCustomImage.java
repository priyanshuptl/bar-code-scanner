package softechworld.googlesmlkit;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.List;

import softechworld.googlesmlkit.GraphicOverlay.Graphic;

/** Graphic instance for rendering image labels. */
class LabelGraphicCustomImage extends Graphic {

    private final Paint textPaint;
    private final GraphicOverlay overlay;

    private List<String> labels;

    LabelGraphicCustomImage(GraphicOverlay overlay) {
        super(overlay);
        this.overlay = overlay;
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(60.0f);
    }

    synchronized void updateLabel(List<String> labels) {
        this.labels = labels;
        postInvalidate();
    }

    @Override
    public synchronized void draw(Canvas canvas) {
        float x = overlay.getWidth() / 4.0f;
        float y = overlay.getHeight() / 4.0f;

        for (String label : labels) {
            canvas.drawText(label, x, y, textPaint);
            y = y - 62.0f;
        }
    }
}