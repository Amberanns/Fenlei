package com.bawei.myapplication.perstent;

import com.bawei.myapplication.bean.Rightbean;
import com.bawei.myapplication.model.Imodel;
import com.bawei.myapplication.model.Onsekectright;
import com.bawei.myapplication.model.model;
import com.bawei.myapplication.view.Iview;

import java.util.List;



/**
 * Created by dell on 2017/12/8.
 */

public class RightPresenter {
    Iview iview;
    Imodel imodel;

    public RightPresenter(Iview iview) {
        this.iview = iview;
        imodel = new model();
    }

    public void getRightOk(String url, int cid) {
        imodel.RequestRight(url, cid, new Onsekectright() {
            @Override
            public void dataRightSuccessd(List<Rightbean.DataBean> lists) {
                iview.shouRight(lists);
            }
        });


    }


}
