package com.bawei.myapplication.view;

import com.bawei.myapplication.bean.Leftbean;
import com.bawei.myapplication.bean.Rightbean;

import java.util.List;

/**
 * Created by dell on 2017/12/8.
 */

public interface Iview {

    void showLeft(List<Leftbean.DataBean> list);
    void shouRight(List<Rightbean.DataBean> lists);
}
