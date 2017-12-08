package com.bawei.myapplication.perstent;

import com.bawei.myapplication.bean.Leftbean;
import com.bawei.myapplication.model.Imodel;
import com.bawei.myapplication.model.Onselectleft;
import com.bawei.myapplication.model.model;
import com.bawei.myapplication.view.Iview;

import java.util.List;



public class LeftPresenter {
    Imodel imodel;
    Iview iview;

    public LeftPresenter(Iview iview) {

        this.iview = iview;
        imodel=new model();
    }

    public void getLeftOk(String url) {
        imodel.RequestLeft(url, new Onselectleft() {
            @Override
            public void dataLeftSuccess(List<Leftbean.DataBean> list) {
                iview.showLeft(list);
            }
        });
    }
}
