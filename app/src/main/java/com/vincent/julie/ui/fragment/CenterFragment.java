package com.vincent.julie.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vincent.julie.R;
import com.vincent.julie.app.MyApplication;
import com.vincent.julie.util.SystemUtilts;
import com.vincent.julie.util.ToastUtils;
import com.vincent.julie.view.AnFQNumEditText;
import com.vincent.julie.view.BottomDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 第三个Fragment
 *
 * @author Vincent QQ1032006226
 *         created at 2016/9/26 15:54
 */
public class CenterFragment extends BackHandledFragment {

    @BindView(R.id.tv_choose_img)
    TextView tvChooseImg;

    private View view;
    private AnFQNumEditText anetDemo;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.main_frg_center, null);
        }
        ButterKnife.bind(this, view);

        anetDemo = (AnFQNumEditText) view.findViewById(R.id.tv_custom);
        anetDemo.setEtHint("内容")//设置提示文字
                .setEtMinHeight(200)//设置最小高度，单位px
                .setLength(50)//设置总字数
                .setType(AnFQNumEditText.SINGULAR)//TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
                .setLineColor("#3F51B5")//设置横线颜色
                .show();
        SystemUtilts.getReflectInstance(getContext(),"com.vincent.julie.entity.Food");
        return view;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @OnClick(R.id.tv_choose_img)
    public void onClick() {
        //在底部弹出一个dialog
        BottomDialog bottomDialog=BottomDialog.newInstance();
        bottomDialog.show(getFragmentManager(),BottomDialog.class.getSimpleName());
    }
}
