package com.qft3.maimeng;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.qft3.maimeng.comicModule.ui.ComicFragment;
import com.qft3.maimeng.homeModule.ui.HomeFragment;
import com.qft3.maimeng.infoModule.ui.InfoFragment;
import com.qft3.maimeng.picModule.ui.PictureFragment;
import com.qft3.maimeng.test.OtherFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.main_tab_rg)
    RadioGroup mainTabRg;

    private FragmentManager manager;
    private Fragment mShowFragment;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        init();
    }

    private void initFragment() {
        if (fragments.size() == 0) {
            fragments.add(InfoFragment.newInstance("",""));
            fragments.add(ComicFragment.newInstance());
            fragments.add(PictureFragment.newInstance("",""));
            fragments.add(HomeFragment.newInstance());
        }
    }

    private void init() {
        initFragment();
        manager = getSupportFragmentManager();
        ButterKnife.bind(this);
//        mainTabRg = (RadioGroup) findViewById(R.id.main_tab_rg);

        mainTabRg.setOnCheckedChangeListener(this);
        ctrlFragment(fragments.get(1));
    }

    private void ctrlFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        if (mShowFragment != null && mShowFragment.isAdded()) {
            fragmentTransaction.hide(mShowFragment);
        }
        if (!fragment.isAdded()) {
            fragmentTransaction.add(R.id.main_content_fl, fragment);
        } else {
            fragmentTransaction.show(fragment);
        }
        fragmentTransaction.commit();
        mShowFragment = fragment;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.main_tab_info_rb:
                ctrlFragment(fragments.get(0));
                break;
            case R.id.main_tab_comic_rb:
                ctrlFragment(fragments.get(1));
                break;
            case R.id.main_tab_pic_rb:
                ctrlFragment(fragments.get(2));
                break;
            case R.id.main_tab_home_rb:
                ctrlFragment(fragments.get(3));
                break;
        }
    }
}
