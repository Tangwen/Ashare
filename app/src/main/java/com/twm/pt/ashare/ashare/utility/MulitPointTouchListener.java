package com.twm.pt.ashare.ashare.utility;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// 記得 imageView 要設 android:scaleType="matrix"
/**
 * @Title: MulitPointTouchListener.java
 * @Package org.example.touch
 * @Description:
 * @author fengcunhan fengcunhan@gmail.com
 * @date 2010-7-18 上午10:41:22
 * @version V1.0
 */
public class MulitPointTouchListener implements View.OnTouchListener {
    private static final String TAG = "Touch";
    // These matrices will be used to move and zoom image
    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();

    // We can be in one of these 3 states
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE;

    // Remember some things for zooming
    PointF start = new PointF();
    PointF mid = new PointF();
    float oldDist = 1f;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageView view = (ImageView) v;
        // Log.e("view_width",
        // view.getImageMatrix()..toString()+"*"+v.getWidth());
        // Dump touch event to log
        dumpEvent(event);

        // Handle touch events here...
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN://起始点

                matrix.set(view.getImageMatrix());
                savedMatrix.set(matrix);
                start.set(event.getX(), event.getY());
                //L.d("mode=DRAG");
                mode = DRAG;//处于拖状态

   /*
    * float scaleWidth=180f/320; float scaleHeight=240f/480;
    * matrix.reset(); matrix.postScale(scaleWidth, scaleHeight);
    */
                //L.d("mode=NONE");
                break;
            case MotionEvent.ACTION_POINTER_DOWN://如果有了第二个接触点，则是缩放
                oldDist = spacing(event);//获得两触点距离
                // Log.d(TAG, "oldDist=" + oldDist);
                if (oldDist > 10f) {
                    savedMatrix.set(matrix);
                    midPoint(mid, event);//设置mid的中点
                    mode = ZOOM;//处于缩放状态
                    //L.d("mode=ZOOM");
                }
                break;
            case MotionEvent.ACTION_UP://手势抬起
            case MotionEvent.ACTION_POINTER_UP://其余的一系列活动的终止
                mode = NONE;//终止
                // Log.e("view.getWidth", view.getWidth() + "");
                // Log.e("view.getHeight", view.getHeight() + "");

                break;
            case MotionEvent.ACTION_MOVE:
                if (mode == DRAG) {//如果是拖从一个地方移动到别一个地方
                    // ...
                    matrix.set(savedMatrix);
                    matrix.postTranslate(event.getX() - start.x, event.getY() - start.y);
                } else if (mode == ZOOM) {
                    float newDist = spacing(event);
                    //L.d("newDist=" + newDist + ", oldDist=" + oldDist);
                    if (newDist > 10f) {//如果是缩放则变化大小
                        matrix.set(savedMatrix);
                        float scale = newDist / oldDist;
                        matrix.postScale(scale, scale, mid.x, mid.y);
                    }
                }
                break;
        }

        view.setImageMatrix(matrix);
        return true; // indicate event was handled

    }

    private void dumpEvent(MotionEvent event) {
        String names[] = {"DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE",
                "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?"};
        StringBuilder sb = new StringBuilder();
        int action = event.getAction();
        int actionCode = action & MotionEvent.ACTION_MASK;
        sb.append("event ACTION_").append(names[actionCode]);
  /*指针效果*/
        if (actionCode == MotionEvent.ACTION_POINTER_DOWN
                || actionCode == MotionEvent.ACTION_POINTER_UP) {
            sb.append("(pid ").append(
                    action >> MotionEvent.ACTION_POINTER_ID_SHIFT);
            sb.append(")");
        }
        sb.append("[");
  /*触点个数*/
        for (int i = 0; i < event.getPointerCount(); i++) {
            sb.append("#").append(i);
            sb.append("(pid ").append(event.getPointerId(i));
            sb.append(")=").append((int) event.getX(i));
            sb.append(",").append((int) event.getY(i));
            if (i + 1 < event.getPointerCount())
                sb.append(";");
        }
        sb.append("]");

        //L.d(sb.toString());
    }

    //两个触点的位置的距离
    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float)Math.hypot((double) x,(double) y);
    }

    /**
     * Calculate the mid point of the first two fingers
     */
    private void midPoint(PointF point, MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        point.set(x / 2, y / 2);
    }
}
