package com.jtsw.sharedfloor;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.jtsw.sharedfloor.adapter.PurchaseAdapter;
import com.jtsw.sharedfloor.model.PurchaseItem;
import com.jtsw.sharedfloor.model.TypeItem;
import com.jtsw.sharedfloor.settings.GeneralSetting_activity;

public class Selector_activity extends AppCompatActivity {
    //***************************************************************************************//
        //fab ADditem
    FloatingActionButton fabAddItem;

    private PurchaseAdapter purchaseAdapter;

    //***********************************************************//
       // Menu menu;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    int positionDisplay;

    ActionBar actionbar;

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        purchaseAdapter= new PurchaseAdapter(this);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        fabAddItem=(FloatingActionButton)findViewById(R.id.purchaseFABaddItem);
        fabAddItem.hide();

        //********************TES IMGTABS**********************//
        iconTest();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mSectionsPagerAdapter.fabChange(tab.getPosition());
                positionDisplay=tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mSectionsPagerAdapter.fabChange(position);
                positionDisplay=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void iconTest(){
      // tabLayout.getTabAt(1).setIcon(R.drawable.icono_casa200);
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selector, menu);
       getMenuInflater().inflate(R.menu.menu_selector_purchase,menu);

        return true;
    }

    public void purchaeFABadd(View view) {
       startActivity(new Intent(this,AddItem_activity.class));
    }


    //click on options menu
@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent i=null;
        switch (id){
            case R.id.action_settings:
                i= new Intent(this,GeneralSetting_activity.class);
                break;
            case R.id.action_about:
                i= new Intent(this,About_activity.class);
                break;
            case R.id.action_listTypes:
                i= new Intent(this,ListTypeElement.class);
                break;
            case R.id.purchase_action_order_alph:
                purchaseAdapter.sortItems(PurchaseAdapter.SORTBYNAME);
                purchaseAdapter.notifyDataSetChanged();
                break;
            case R.id.purchase_action_order_typeName:
                purchaseAdapter.sortItems(PurchaseAdapter.SORTBYTYPE);
                purchaseAdapter.notifyDataSetChanged();
                break;
        }
            if(i!=null) {
                startActivity(i);
            }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        switch (mViewPager.getCurrentItem()){
            case 2:
                menu.findItem(R.id.purchase_action_add_item).setVisible(true);
                menu.findItem(R.id.purchase_action_order_alph).setVisible(true);
                menu.findItem(R.id.purchase_action_order_typeName).setVisible(true);
                break;

            default:
                menu.findItem(R.id.purchase_action_add_item).setVisible(false);
                menu.findItem(R.id.purchase_action_order_alph).setVisible(false);
                menu.findItem(R.id.purchase_action_order_typeName).setVisible(false);
                break;
        }
        return super.onPrepareOptionsMenu(menu);
    }




    ///--------------------------TEST--------------------------------/

///-------------------------------

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView=null;
            switch (getArguments().getInt(ARG_SECTION_NUMBER)){
                case 1:
                    rootView=new Home_fragment().onCreateView(inflater,container,savedInstanceState);
                   // rootView=inflater.inflate(R.layout.fragment_home_fragment,container,false);
                    break;
                case 2:
                   // rootView=inflater.inflate(R.layout.fragment_expenses_fragment,container,false);
                    rootView=new Expenses_fragment().onCreateView(inflater,container,savedInstanceState);
                    break;
                case 3:
                    rootView=new Purchase_fragment().onCreateView(inflater,container,savedInstanceState);
                    break;
                case 4:
                    rootView=inflater.inflate(R.layout.fragment_clean_fragment,container,false);
                    break;
                case 5:
                    rootView=inflater.inflate(R.layout.fragment_debts_fragment,container,false);
                    break;
            }

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {

            super(fm);
        }


        @Override
        public Fragment getItem(int position) {

            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return mViewPager.getContext().getResources().getString(R.string.home_title);
                case 1:
                    return mViewPager.getContext().getResources().getString(R.string.expense_title);
                case 2:
                    return mViewPager.getContext().getResources().getString(R.string.purchase_title);
                case 3:
                    return mViewPager.getContext().getResources().getString(R.string.clean_title);
                case 4:
                    return mViewPager.getContext().getResources().getString(R.string.debts_title);
            }
            return null;
        }

        private void fabChange(int position){

            switch (position) {
                case 0:
                    fabAddItem.hide();
                    break;
                case 1:
                    fabAddItem.hide();
                    break;
                case 2:
                    fabAddItem.show();
                    break;
                case 3:
                    fabAddItem.hide();
                    break;
                case 4:
                    fabAddItem.hide();
                    break;
            }
        }

    }
}
