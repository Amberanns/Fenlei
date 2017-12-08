package com.bawei.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.myapplication.adapter.MyLeftAdapter;
import com.bawei.myapplication.adapter.MyRightAdapter;
import com.bawei.myapplication.api.Api;
import com.bawei.myapplication.api.Meventss;
import com.bawei.myapplication.bean.Leftbean;
import com.bawei.myapplication.bean.Rightbean;
import com.bawei.myapplication.perstent.LeftPresenter;
import com.bawei.myapplication.perstent.RightPresenter;
import com.bawei.myapplication.view.Iview;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;


public class MainActivity extends AppCompatActivity implements Iview{

    private LeftPresenter leftPresenter;
    private RecyclerView re;
    private int cid;
    private RightPresenter rightPresenter;
    private RecyclerView re2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        leftPresenter = new LeftPresenter(this);
        leftPresenter.getLeftOk(Api.PATH);
        rightPresenter = new RightPresenter(this);
//        rightPresenter.getRightOk(Api.URL, 1);
        re = (RecyclerView) findViewById(R.id.re);
        re2 = (RecyclerView) findViewById(R.id.re2);


    }



    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void noEvent(Meventss meventss) {
        cid = meventss.getCid();
        rightPresenter.getRightOk(Api.PATH, cid);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void showLeft(List<Leftbean.DataBean> list) {
        re.setLayoutManager(new LinearLayoutManager(this));
        re.setAdapter(new MyLeftAdapter(list, this));
        rightPresenter.getRightOk(Api.PATH, 1);
    }


    @Override
    public void shouRight(List<Rightbean.DataBean> lists) {
        re2.setLayoutManager(new LinearLayoutManager(this));
        re2.setAdapter(new MyRightAdapter(lists, this));
    }
}
