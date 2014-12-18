package com.example.myapplication.ui.activity;

import android.app.FragmentTransaction;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import com.example.myapplication.R;
import com.example.myapplication.manager.BaseApplication;
import com.example.myapplication.ui.fragment.MainFragment;
import com.example.myapplication.ui.fragment.MenuFragment;
import com.example.myapplication.utils.UIUtils;


public class MainActivity extends BaseActivity {

    private SlidingPaneLayout mSlidingPaneLayout;
    private MenuFragment mMenu;
    private android.support.v4.app.FragmentTransaction transaction;
    private DisplayMetrics displayMetrics = new DisplayMetrics();
    private MainFragment mMain;
    private int maxMargin;
    private ActionBar mActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BaseApplication.addActivity(this);
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initActionBar();
    }

    private void initActionBar() {
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("婚博会");
        mActionBar.setBackgroundDrawable(UIUtils.getDrawable(R.drawable.actionbar));

    }

    private void initView() {
        mSlidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.slidingpanellayout);
        mMenu = new MenuFragment();
        mMain = new MainFragment();
        transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.slidingpane_menu, mMenu);
        transaction.replace(R.id.slidingpane_content, mMain);
        transaction.commit();

        maxMargin = displayMetrics.heightPixels / 10;
        mSlidingPaneLayout.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View view, float slideOffset) {
                int contentMargin = (int) (slideOffset * maxMargin);

                FrameLayout.LayoutParams contentParams = mMain
                        .getCurrentViewParams();
                contentParams.setMargins(0, contentMargin, 0, contentMargin);

                mMain.setCurrentViewParams(contentParams);

                float scale = 1 - ((1 - slideOffset) * maxMargin * 3)
                        / (float) displayMetrics.heightPixels;
                mMenu.getCurrentView().setScaleX(scale);//设置缩放的基准点
                mMenu.getCurrentView().setScaleY(scale);// 设置缩放的基准点
                mMenu.getCurrentView().setPivotX(0);// 设置缩放和选择的点
                mMenu.getCurrentView().setPivotY(
                        displayMetrics.heightPixels / 2);
                mMenu.getCurrentView().setAlpha(slideOffset);

            }

            @Override
            public void onPanelOpened(View view) {
                mActionBar.hide();
            }

            @Override
            public void onPanelClosed(View view) {
                mActionBar.show();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 返回键监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }
}
