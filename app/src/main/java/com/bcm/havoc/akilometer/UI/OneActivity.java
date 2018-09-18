package com.bcm.havoc.akilometer.UI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bcm.havoc.akilometer.Base.ui.BaseActivity;
import com.bcm.havoc.akilometer.Entity.OrderE;
import com.bcm.havoc.akilometer.Entity.ProjectE;
import com.bcm.havoc.akilometer.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class OneActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private BaseQuickAdapter adapter;
    private List<ProjectE> mDataList;
    private List<OrderE> orderEList;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
//        initDb();
        initData();
        initView();
        initAdapter();
    }

    private void initData() {

        mDataList = new ArrayList<>();
        orderEList = new ArrayList<>();
        for (int j = 0; j< 11; j++) {
            OrderE orderE = new OrderE( j+"",  j*123684+"", "","待装车");
            orderEList.add(orderE);
        }

        for (int i = 1; i < 11; i++) {

            ProjectE projectE = new ProjectE(i +"", "开始时间：2018-12-"+i, "2018-12-25", "任务编号："+i*32548+"", "配送方式：全天配送", "花垣县", "凤凰县", "1305", "18710056339", "154", "已完成", orderEList);
            if (i % 2==0) {
                projectE.setSendType("配送方式：顺路配送");
            }

            if (i == 0) {
                projectE.setStatus( "正在进行...");
            }
            mDataList.add(projectE);

        }

//        try {
//            mDataList = db.selector(Stock_OUT.class).where("State","<",5).findAll();
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
    }

    private void initView() {
        setTitle("配送任务");
        setBackBtn();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

    }

    private void refresh() {
        initData();
        initView();
        initAdapter();
        mSwipeRefreshLayout.setRefreshing(false);

    }

    private void initAdapter() {
        adapter = new MyAdapter(mDataList);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);//动画效果为缩放
//        动画默认只执行一次,如果想重复执行可设置
        adapter.isFirstOnly(false);
//        adapter.addHeaderView(top);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(OneActivity.this, ProInfoActivity.class);
                intent.putExtra(ProInfoActivity.intenttag, mDataList.get(position));
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(adapter);
    }

    public class MyAdapter extends BaseQuickAdapter<ProjectE, BaseViewHolder> {
        public MyAdapter(List data) {
            super(R.layout.item_pro, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, ProjectE item) {
//        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetName);

//            helper.setImageResource(R.id.im_item_ew_bs, R.mipmap.im_st_green);
            helper.setText(R.id.item_tv_item_time, item.getStartTime());
            helper.setText(R.id.item_tv_item_no, item.getProjectNo());
            helper.setText(R.id.item_tv_item_type, item.getSendType());
            helper.setText(R.id.item_tv_status, item.getStatus());


        }


    }

    @Override
    protected void onResume() {
        refresh();
        super.onResume();
    }
}
