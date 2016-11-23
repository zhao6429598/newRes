package comt.example.administrator.mobsharedemo;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: zwf(zhaoweifeng@1000phone.com)
 * Date  : 2016-11-17
 * Time  : 15:15
 * Project: MOBShareDemo
 * Descrite:自定义PagerAdapter
 */

public class MyAdapter extends PagerAdapter {


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {


        return super.instantiateItem(container, position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
