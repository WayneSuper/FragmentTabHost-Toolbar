package com.wayne.github.activity;

import com.wayne.github.R;
import com.wayne.github.activity.fragment.ActiveFragment;
import com.wayne.github.activity.fragment.MeFragment;
import com.wayne.github.activity.fragment.NewsFragment;
import com.wayne.github.activity.fragment.QuestionFragment;

/**
 * Created by Lumia on 2015/3/15.
 */
public enum MainTabs {
    NEWS(0,"资讯", R.drawable.tab_news, NewsFragment.class),
    QUESTION(0,"问答", R.drawable.tab_question, QuestionFragment.class),
    ACTIVE(0,"动态", R.drawable.tab_active, ActiveFragment.class),
    ME(0,"我的", R.drawable.tab_me, MeFragment.class);
    private int id;
    private String tab;
    private int drawable;
    private Class<?> clzz;
     MainTabs(int id, String tab, int drawable, Class<?> clzz) {
         this.id = id;
         this.tab = tab;
         this.drawable = drawable;
         this.clzz = clzz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public Class<?> getClzz() {
        return clzz;
    }

    public void setClzz(Class<?> clzz) {
        this.clzz = clzz;
    }
}
