package mainactivity.musicplayer.example.com.pegersiport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VertivalViewPeger extends ViewPager {
    public VertivalViewPeger(@NonNull Context context) {
        super(context);
        init();
    }

    public VertivalViewPeger(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        setPageTransformer(true, new VerticalPage());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }
    private MotionEvent getIntercableXY(MotionEvent ev){
        float wight = getWidth();
        float height = getHeight();

        float newX = (ev.getY() / height) * wight;
        float newY = (ev.getX() / wight) * height;

        ev.setLocation(newX,newY);

        return ev;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = super.onInterceptTouchEvent(getIntercableXY(ev));
        getIntercableXY(ev);
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(getIntercableXY(ev));
    }
    private class VerticalPage implements PageTransformer{

        @Override
        public void transformPage(@NonNull View view, float position) {
            if (position < -1){
                view.setAlpha(0);
            }else if (position <=1){
                view.setAlpha(1);
                view.setTranslationX(view.getWidth() * -position);
                float yPosition = position * view.getHeight();
                view.setTranslationY(yPosition);
            }else {
                view.setAlpha(0);
            }
        }
    }
}
