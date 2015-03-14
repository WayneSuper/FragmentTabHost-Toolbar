package com.wayne.github.activity;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.wayne.github.R;


public class MainActivity extends ActionBarActivity {
    FragmentTabHost mTabhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.main_action_bar);
        mToolbar.setTitle("底部导航");
        setSupportActionBar(mToolbar);
        mTabhost.setup(MainActivity.this, getSupportFragmentManager(), R.id.container);
        initTabs();
        mTabhost.setCurrentTab(0);
        mTabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
               int size =  mTabhost.getTabWidget().getTabCount();
                for (int i = 0; i < size; i++) {
                    View view = mTabhost.getTabWidget().getChildAt(i);
                    if(i==mTabhost.getCurrentTab()) {
                        view.findViewById(R.id.tab_image).setSelected(true);
                        view.findViewById(R.id.tab_text).setSelected(true);
                    }else {
                        view.findViewById(R.id.tab_image).setSelected(false);
                        view.findViewById(R.id.tab_text).setSelected(false);
                    }
                }
                supportInvalidateOptionsMenu();
            }
        });

        if(Build.VERSION.SDK_INT>10) {
            mTabhost.getTabWidget().setShowDividers(0);
        }

    }

    private void initTabs() {
        MainTabs[] tabs = MainTabs.values();
        for (int i = 0; i < tabs.length; i++) {
            MainTabs mTab = tabs[i];
            TabHost.TabSpec tab = mTabhost.newTabSpec(mTab.getTab());
            View indcator = getLayoutInflater().inflate(R.layout.layout_tab,null);
            ImageView img = (ImageView) indcator.findViewById(R.id.tab_image);
            img.setImageResource(mTab.getDrawable());
            TextView text = (TextView) indcator.findViewById(R.id.tab_text);
            text.setText(mTab.getTab());
            tab.setIndicator(indcator);
            tab.setContent(new TabHost.TabContentFactory() {
                @Override
                public View createTabContent(String tag) {
                    return new View(MainActivity.this);
                }
            });

            mTabhost.addTab(tab,mTab.getClzz(),null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);



        return true;
    }
}
