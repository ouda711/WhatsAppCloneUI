package com.example.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TabHost;

import com.example.whatsappclone.tabwithpageviewer.TabAdapter;
import com.example.whatsappclone.tabwithpageviewer.fragments.CallFragment;
import com.example.whatsappclone.tabwithpageviewer.fragments.CameraFragment;
import com.example.whatsappclone.tabwithpageviewer.fragments.ChatFragment;
import com.example.whatsappclone.tabwithpageviewer.fragments.StatusFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private final int[] tabIcons = {
        R.drawable.ic_camera_foreground
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        viewPager.setCurrentItem(1);
        adapter = new TabAdapter(getSupportFragmentManager(), this);

        adapter.addFragment(new ChatFragment(), "CHATS", 0);
        adapter.addFragment(new StatusFragment(), "STATUS", 0);
        adapter.addFragment(new CallFragment(), "CALLS", 0);
        adapter.addFragment(new CameraFragment(), "CAMERA", 0);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        highLightCurrentTab(0);viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }@Override
            public void onPageSelected(int position) {
                highLightCurrentTab(position);
            }@Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void highLightCurrentTab(int position) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(null);
            tab.setCustomView(adapter.getTabView(i));
        }

        TabLayout.Tab tab = tabLayout.getTabAt(position);
        assert tab != null;
        tab.setCustomView(null);
        tab.setCustomView(adapter.getSelectedTabView(position));
    }
}