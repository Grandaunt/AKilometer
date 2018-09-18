package com.bcm.havoc.akilometer.UI.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bcm.havoc.akilometer.Base.adapter.HomeAdapter;
import com.bcm.havoc.akilometer.Base.application.ACache;
import com.bcm.havoc.akilometer.Base.application.MyApplication;
import com.bcm.havoc.akilometer.Base.entity.HomeItem;
import com.bcm.havoc.akilometer.R;
import com.bcm.havoc.akilometer.UI.FiveActivity;
import com.bcm.havoc.akilometer.UI.FourActivity;
import com.bcm.havoc.akilometer.UI.OneActivity;
import com.bcm.havoc.akilometer.UI.SixActivity;
import com.bcm.havoc.akilometer.UI.ThreeActivity;
import com.bcm.havoc.akilometer.UI.TwoActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment  {
    private static final Class<?>[] ACTIVITY = {OneActivity.class, TwoActivity.class, ThreeActivity.class, FourActivity.class, FiveActivity.class, SixActivity.class};
    private static final String[] TITLE = {"配送任务", "发车确认", "车辆监控", "异常上报", "配送签收", "回执单上传"};
    private static final int[] IMG = {R.mipmap.ic_main_61, R.mipmap.ic_main_21, R.mipmap.ic_main_31, R.mipmap.ic_main_41, R.mipmap.ic_main_51, R.mipmap.ic_main_11};
    private ArrayList<HomeItem> mDataList;
    private RecyclerView mRecyclerView;
    private Intent intent;
    private ACache aCache;
    private MyApplication application;
    private int wwcint=0;

    private View top;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static android.support.v4.app.Fragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
        initView(view);
        initData();
        initAdapter();
        return view;
    }
    private void initView( View view) {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//
        mRecyclerView = (RecyclerView)view.findViewById(R.id.rv_list);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

    }

    @SuppressWarnings("unchecked")
    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new HomeAdapter(R.layout.item_view_home, mDataList);
        homeAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN );//动画效果为缩放
//        动画默认只执行一次,如果想重复执行可设置
        homeAdapter.isFirstOnly(false);
//        homeAdapter.addHeaderView(top);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                Intent intent = new Intent(getActivity(), ACTIVITY[position]);
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeItem item = new HomeItem();
            item.setTitle(TITLE[i]);
            item.setActivity(ACTIVITY[i]);
            item.setImageResource(IMG[i]);
            mDataList.add(item);
        }

//
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
