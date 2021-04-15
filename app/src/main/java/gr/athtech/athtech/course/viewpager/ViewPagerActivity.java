package gr.athtech.athtech.course.viewpager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import gr.athtech.athtech.course.BlankFragment;
import gr.athtech.athtech.course.R;
import gr.athtech.athtech.course.SecondFragment;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        ViewPager viewPager = findViewById(R.id.viewPager);

        List<Fragment> array = new ArrayList<Fragment>();
        array.add(new BlankFragment());
        array.add(SecondFragment.newInstance("", ""));
        array.add(new BlankFragment());
        array.add(SecondFragment.newInstance("", ""));
        array.add(new BlankFragment());

        viewPager.setAdapter(new ViewPagerScreenAdapter(getSupportFragmentManager(), array));


    }
}