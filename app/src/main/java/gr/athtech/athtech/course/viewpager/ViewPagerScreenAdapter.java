package gr.athtech.athtech.course.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class ViewPagerScreenAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> dataList;

    public ViewPagerScreenAdapter(@NonNull FragmentManager fm, List<Fragment> array) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.dataList = array;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }
}
