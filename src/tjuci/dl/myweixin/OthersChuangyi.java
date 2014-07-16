package tjuci.dl.myweixin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class OthersChuangyi extends FragmentActivity implements OnClickListener {
	private ViewPager mViewPager;
	private MyFragmentPageAdapter mAdapter;
	private TextView tabLine;
	private float temp = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.others_chuangyi);
		tabLine = (TextView) findViewById(R.id.cursor_text);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        
        //这里因为是3.0一下版本，所以需继承FragmentActivity，通过getSupportFragmentManager()获取FragmentManager
        //3.0及其以上版本，只需继承Activity，通过getFragmentManager获取事物
        FragmentManager fm = getSupportFragmentManager();
        //初始化自定义适配器
        mAdapter =  new MyFragmentPageAdapter(fm);
        //绑定自定义适配器
        mViewPager.setAdapter(mAdapter);
        
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
        	@Override
        	public void onPageScrolled(int position,
                    float positionOffset, int positionOffsetPixels){
				if (positionOffsetPixels != 0 && position == 0) {
					tabLine.setTranslationX((float)positionOffsetPixels / 1.73f);
					temp = tabLine.getX();
					System.out.println("temp: " + temp);
				}else if (positionOffsetPixels != 0 && position == 1) {
					tabLine.setTranslationX((float)positionOffsetPixels / 1.73f + temp);
				}
        	}
        });
    }
    
    
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		default:
			break;
		}
	}
	
	private class MyFragment extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";
		
		public MyFragment() {}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView;
			int postion = getArguments().getInt(ARG_SECTION_NUMBER);
			if (postion == 0) 
				rootView = inflater.inflate(R.layout.my_follow, container, false);
			else 
				rootView = inflater.inflate(R.layout.find_more, container, false);
			return rootView;
		}
	}
	
	private class MyFragmentPageAdapter extends FragmentPagerAdapter {

		public MyFragmentPageAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			Fragment fragment = new MyFragment();
			Bundle args = new Bundle();
			args.putInt(MyFragment.ARG_SECTION_NUMBER, position);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}
		
	}
}
