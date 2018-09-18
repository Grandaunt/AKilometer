package com.bcm.havoc.akilometer.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bcm.havoc.akilometer.Base.application.MyApplication;
import com.bcm.havoc.akilometer.Base.ui.BaseActivity;
import com.bcm.havoc.akilometer.Base.utils.logger.Logger;
import com.bcm.havoc.akilometer.Entity.OrderE;
import com.bcm.havoc.akilometer.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.RxGalleryFinalApi;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultDisposable;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageRadioResultEvent;
import cn.finalteam.rxgalleryfinal.ui.base.IRadioImageCheckedListener;

public class SixActivity extends BaseActivity {
    private RecyclerView mRecyclerView;
    private BaseQuickAdapter adapter;
    private List<OrderE> mDataList;
    private View top;
    private MyApplication application;
    private int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        initData();
        initView();
        initAdapter();
    }
    private void initData() {

        mDataList = new ArrayList<>();

//        for (int j = 0; j< 11; j++) {
            OrderE orderE1 = new OrderE( 3+"",  7*123484+"","", "0");
            OrderE orderE2 = new OrderE( 3+"",  6*123384+"","", "0");
            OrderE orderE3 = new OrderE( 3+"",  5*123584+"","", "0");
            OrderE orderE4 = new OrderE( 3+"",  4*123284+"","", "0");
            OrderE orderE5 = new OrderE( 3+"",  3*123484+"","", "0");
            OrderE orderE6 = new OrderE( 3+"",  2*123684+"","", "0");
            OrderE orderE7 = new OrderE( 3+"",  3*123784+"","", "0");
            OrderE orderE8 = new OrderE( 3+"",  4*123884+"","", "0");
            OrderE orderE9 = new OrderE( 3+"",  5*123984+"","", "0");
            OrderE orderE10 = new OrderE( 3+"",  6*121684+"","", "0");
            OrderE orderE11 = new OrderE( 3+"",  7*122684+"","", "0");
            mDataList.add(orderE1);
            mDataList.add(orderE2);
            mDataList.add(orderE3);
            mDataList.add(orderE4);
            mDataList.add(orderE5);
            mDataList.add(orderE6);
            mDataList.add(orderE7);
            mDataList.add(orderE8);
            mDataList.add(orderE9);
            mDataList.add(orderE10);
            mDataList.add(orderE11);

//        }

//        try {
//            mDataList = db.selector(Stock_OUT.class).where("State","<",5).findAll();
//        } catch (DbException e) {
//            e.printStackTrace();
//        }
    }

    private void initView() {
        application = new MyApplication();
        setTitle("回执单上传");
        setBackBtn();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        top = getLayoutInflater().inflate(R.layout.top_view, (ViewGroup) mRecyclerView.getParent(), false);

    }



    private void initAdapter() {
        adapter = new MyAdapter(mDataList);
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);//动画效果为缩放
//        动画默认只执行一次,如果想重复执行可设置
        adapter.isFirstOnly(false);
        adapter.addHeaderView(top);
//        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Intent intent = new Intent(SixActivity.this, ProInfoActivity.class);
//                intent.putExtra(ProInfoActivity.intenttag, mDataList.get(position));
//                startActivity(intent);
//            }
//        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                flag = position;
                String content = null;
//                Supplier_Info item = (Supplier_Info) adapter.getItem(position);
                switch (view.getId()) {
                    case R.id.im_add_photo:
                        openRadio();

                        break;
                    case R.id.item_scan_reslf:
//                        content = "name:" + status.getUserName();
                        Toast.makeText(SixActivity.this, "扫描结果", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.btn_up:
//                        content = "tweetText:" + status.getUserName();
                        mDataList.get(flag).setStatus("2");
                        adapter.setNewData(mDataList);
                        Toast.makeText(SixActivity.this, "上传成功", Toast.LENGTH_LONG).show();
                        // you have set clickspan .so there should not solve any click event ,just empty
                        break;

                }
            }
        });
        mRecyclerView.setAdapter(adapter);
    }


    /**
     * 自定义单选
     * =
     * @param position
     */
    public void openRadio() {

        RxGalleryFinal
                .with(SixActivity.this)
                .image()
                .radio()
//                .cropAspectRatioOptions(0, new AspectRatio("9:9", 90, 90))
//                .crop()
                .imageLoader(ImageLoaderType.FRESCO)
                .subscribe(new RxBusResultDisposable<ImageRadioResultEvent>() {
                    @Override
                    protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                        String  path = imageRadioResultEvent.getResult().getOriginalPath();
                        Logger.i(path);
                        mDataList.get(flag).setPhoto(path);
                        mDataList.get(flag).setStatus("1");
                        adapter.setNewData(mDataList);
//                        initAdapter();
//                        Toast.makeText(BaseInfoActivity.this, "选中了图片路径：" + imageRadioResultEvent.getResult().getOriginalPath(), Toast.LENGTH_SHORT).show();
//                        UImage(path);
//                        if(flag==1){
//                            x.image().bind(im_beer_1, path, application.imageOptions);
//                        }
//                        else     if(flag==2){
//                            x.image().bind(im_beer_2, path, application.imageOptions);
//                        }
//                        else{
//                            x.image().bind(im_beer_3, path, application.imageOptions);
//                        }
                    }
                })
                .openGallery();


    }
    /**
     * OPEN 图片单选实现方法
     * <p>
     * 默认使用 第三个 ，如果运行sample,可自行改变Type，运行Demo查看效果
     */
    private void openImageSelectRadioMethod(int type) {
        RxGalleryFinalApi instance = RxGalleryFinalApi.getInstance(this);
        switch (type) {
            case 0:

                //打开单选图片，默认参数
                instance
                        .setImageRadioResultEvent(new RxBusResultDisposable<ImageRadioResultEvent>() {
                            @Override
                            protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                                Logger.i("0imageRadioResultEvent");
                            }
                        }).open();

                break;
            case 1:

                //设置自定义的参数
                instance
                        .setType(RxGalleryFinalApi.SelectRXType.TYPE_IMAGE, RxGalleryFinalApi.SelectRXType.TYPE_SELECT_RADIO)
                        .setImageRadioResultEvent(new RxBusResultDisposable<ImageRadioResultEvent>() {
                            @Override
                            protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                                Logger.i("1imageRadioResultEvent");
                            }
                        }).open();

                break;
            case 2:

                //快速打开单选图片,flag使用true不裁剪
                RxGalleryFinalApi
                        .openRadioSelectImage(this, new RxBusResultDisposable<ImageRadioResultEvent>() {
                            @Override
                            protected void onEvent(ImageRadioResultEvent o) throws Exception {
                                Logger.i("2imageRadioResultEvent");
                            }
                        }, true);

                break;
            case 3:

                //单选，使用RxGalleryFinal默认设置，并且带有裁剪
                instance
                        .openGalleryRadioImgDefault(
                                new RxBusResultDisposable<ImageRadioResultEvent>() {
                                    @Override
                                    protected void onEvent(ImageRadioResultEvent imageRadioResultEvent) throws Exception {
                                        Logger.i("3imageRadioResultEvent");
                                    }
                                })
                        .onCropImageResult(
                                new IRadioImageCheckedListener() {
                                    @Override
                                    public void cropAfter(Object t) {
                                        Logger.i("裁剪完成");
                                    }

                                    @Override
                                    public boolean isActivityFinish() {
                                        Logger.i("返回false不关闭，返回true则为关闭");
                                        return true;
                                    }
                                });

                break;
        }
    }
    public class MyAdapter extends BaseQuickAdapter<OrderE, BaseViewHolder> {
        public MyAdapter(List data) {
            super(R.layout.item_hzd, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, OrderE item) {

            helper.addOnClickListener(R.id.im_add_photo).addOnClickListener(R.id.item_scan_reslf).addOnClickListener(R.id.btn_up);
//        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetName);
            ImageView icon = helper.getView(R.id.im_add_photo);
            if(item.getPhoto()!=null&&item.getPhoto().length()>0) {
                x.image().bind(icon, item.getPhoto(), application.imageOptions);
            }
//            helper.setImageBitmap(R.id.im_add_photo, R.mipmap.im_st_green);
            helper.setText(R.id.item_scan_reslf, item.getOrderId());
            if(item.getStatus().equals("2")){
                helper.setBackgroundColor(R.id.btn_up, getResources().getColor(R.color.gray9));
                helper.setTextColor(R.id.btn_up, getResources().getColor(R.color.grayd));
            }

//            helper.setText(R.id.item_tv_item_type, item.getSendType());
//            helper.setText(R.id.item_tv_status, item.getStatus());


        }


    }
    @Override
    protected void onResume() {

        super.onResume();
    }
}
