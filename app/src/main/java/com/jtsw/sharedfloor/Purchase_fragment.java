package com.jtsw.sharedfloor;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jtsw.sharedfloor.adapter.PurchaseAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Purchase_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Purchase_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Purchase_fragment extends Fragment {

    //CODES ADD
    public final int ADDOK=0;
        //adapter
        private PurchaseAdapter purchaseAdapter;


    private Selector_activity selector_activity;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Purchase_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Purchase_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Purchase_fragment newInstance(String param1, String param2) {
        Purchase_fragment fragment = new Purchase_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //create the list
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_purchase_fragment,container,false);
        ListView purchaseList=(ListView)view.findViewById(R.id.listItems);
        purchaseAdapter= new PurchaseAdapter(view.getContext());
        purchaseList.setAdapter(purchaseAdapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        selector_activity=(Selector_activity)context;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_selector_purchase,menu);
        super.onCreateOptionsMenu(menu, inflater);
        menu.getItem(1).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=null;
        switch (item.getItemId()) {

            case R.id.purchase_action_add_item:
                addItem(intent);

                break;

            case R.id.purchase_action_order_alph:
                //dao
               // adapterRecycler.getAlphSortedProducts();

                break;

            case R.id.purchase_action_order_typeName:
                // adapterRecycler.getAlphSortedProducts();
                break;

            case R.id.action_about:
                intent =new Intent(getContext(),About_activity.class);
                break;
            case R.id.action_settings:
                intent =new Intent(getContext(),About_activity.class);
                break;
        }
        if(intent!=null){
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    public void addItem(Intent intent){
        startActivityForResult(intent,ADDOK);

    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
