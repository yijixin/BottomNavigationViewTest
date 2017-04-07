package bnvt.zakj.com.bottomnavigationviewtest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import bnvt.zakj.com.bottomnavigationviewtest.fragment.MusicFragment;
import bnvt.zakj.com.bottomnavigationviewtest.fragment.NewsFragment;
import bnvt.zakj.com.bottomnavigationviewtest.fragment.SportFragment;
import bnvt.zakj.com.bottomnavigationviewtest.fragment.VideoFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mList = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mList.add("News");
        mList.add("Sport");
        mList.add("Video");
        mList.add("Music");

        NewsFragment newsFragment = new NewsFragment();
        SportFragment sportFragment = new SportFragment();
        VideoFragment videoFragment = new VideoFragment();
        MusicFragment musicFragment = new MusicFragment();

        mFragments.add(newsFragment);
        mFragments.add(sportFragment);
        mFragments.add(videoFragment);
        mFragments.add(musicFragment);

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mList.get(position);
        }
    }
}
