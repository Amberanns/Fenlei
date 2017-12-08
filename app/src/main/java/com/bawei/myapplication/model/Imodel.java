package com.bawei.myapplication.model;

/**
 * Created by dell on 2017/12/8.
 */

public interface Imodel {
    void RequestLeft(String url, Onselectleft onselect);
   void RequestRight(String url, int cid, Onsekectright onsekectright);

}
